package leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R169_3 {
    //			执行耗时:15 ms,击败了21.17% 的Java用户
    //			内存消耗:43.8 MB,击败了37.45% 的Java用户
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int a : nums) {
            Integer count = map.getOrDefault(a, 0);
            count++;
            if(count>nums.length/2){
                return a;
            }
            map.put(a,count);
        }
        return -1;
    }
}
