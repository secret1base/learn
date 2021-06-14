package leetcode.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R179_2 {
    //			执行耗时:8 ms,击败了39.29% 的Java用户
    //			内存消耗:38 MB,击败了48.78% 的Java用户
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(Integer.toString(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a=o1+o2;
                String b=o2+o1;
                return a.compareTo(b);
            }
        });
        StringBuilder s=new StringBuilder();
        for (int i = list.size()-1; i>=0; i--) {
            s.append(list.get(i));
        }
        if(s.charAt(0)=='0'){
            return "0";
        }
        return s.toString();
    }
}
