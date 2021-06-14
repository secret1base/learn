package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R283_1 {
    //			执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:38.8 MB,击败了25.99% 的Java用户
    public void moveZeroes(int[] nums) {
        int index=-1;
        for (int i = 0; i < nums.length; i++){
            if(index==-1&&nums[i]==0){
                index=i;
            }
            if(nums[i] != 0&&index!=-1){
                int tmp = nums[i];
                nums[i]=nums[index];
                nums[index]=tmp;
                index++;
            }

        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 0, 0, 3, 4, 0,5,0};
        new R283_1().moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
