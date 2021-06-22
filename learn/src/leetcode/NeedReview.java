package leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 需要复习的题目
 * @author: wyj
 * @date: 2021/06/22
 */
public class NeedReview {
    public static void main(String[] args) {
        Set<Integer> list=new TreeSet<>();
        StringBuilder writeStr=new StringBuilder();
        try(BufferedReader br=new BufferedReader(new FileReader("src/leetcode/review.txt"))){
            String s=null;
            while ((s=br.readLine())!=null){
                list.add(Integer.parseInt(s));
            }
            for (Integer integer : list) {
                System.out.println(integer);
                writeStr.append(integer).append("\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("src/leetcode/review.txt"))){
            bw.write(writeStr.toString());
            bw.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}
