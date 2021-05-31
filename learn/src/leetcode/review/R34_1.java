package leetcode.review;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/06/01
 */
public class R34_1 {
    /**
     * 		执行耗时:1 ms,击败了14.25% 的Java用户
     * 		内存消耗:41.5 MB,击败了85.20% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left=-1;
        int right=-1;
        for (int i = 0; i < nums.length;i++){
            if(nums[i]==target){
                if(left==-1){
                    left=i;
                    right=i;
                }else{
                    right=i;
                }
            }else if(right!=-1){
                break;
            }
        }
        return new int[]{left,right};
    }

    public static void main(String[] args) {
        int[] ints = new R34_1().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ints));
    }
}
