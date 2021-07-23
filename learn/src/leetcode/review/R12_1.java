package leetcode.review;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/07/16
 */
public class R12_1 {
    /**
     * 			执行耗时:12 ms,击败了9.93% 的Java用户
     * 			内存消耗:38.4 MB,击败了22.08% 的Java用户
     */
    public String intToRoman(int num) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        List<Integer> list=new ArrayList<>();
        for (Integer integer : map.keySet()) {
            list.add(integer);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //倒序排列
                return Integer.compare(o2,o1);
            }
        });
        StringBuilder sb=new StringBuilder();
        int i=0;
        while (num>0){
            Integer integer = list.get(i);
            if(num>=integer){
                sb.append(map.get(integer));
                num-=integer;
            }else{
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new R12_1().intToRoman(58);
        System.out.println(s);
    }
}
