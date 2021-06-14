package leetcode.review;

import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/10
 */
public class R93_1 {
    public static void main(String[] args) {
        List<String> list = new R93_1().restoreIpAddresses("010010");
        System.out.println(list);
    }
    //			执行耗时:5 ms,击败了36.19% 的Java用户
    //			内存消耗:38.8 MB,击败了16.13% 的Java用户
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        if(s.length()>12){
            return list;
        }
        Deque<String> path=new LinkedList<>();
        for(int i = 0; i < s.length()&&i<4; i++){
            path.offerLast(s.substring(0,i+1));
            doWrite(s.substring(i+1),path,list);
            path.pollLast();
        }
        return list;
    }

    private void doWrite(String s, Deque<String> path, List<String> list) {
        if(s.isEmpty()&&path.size()==4){
            //检查每位数值范围
            StringBuilder sb=new StringBuilder();
            for (String a : path) {
                if((a.length()>1&&a.charAt(0)=='0')||Integer.parseInt(a)>255){
                    return;
                }
                sb.append(a).append(".");
            }
            list.add(sb.substring(0,sb.length()-1));
            return;
        }else if(s.isEmpty()|| path.size()==4){
            return;
        }
        for(int i = 0; i < s.length()&&i<4; i++){
            path.offerLast(s.substring(0,i+1));
            doWrite(s.substring(i+1),path,list);
            path.pollLast();
        }
    }
}
