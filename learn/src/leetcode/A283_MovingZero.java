package leetcode;

import java.util.Arrays;

/**
 * 283. 移动零
 * @author: wyj
 * @date: 2021/06/02
 */
public class A283_MovingZero {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *  示例:
     *  输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *  说明:
     *  必须在原数组上操作，不能拷贝额外的数组。
     *  尽量减少操作次数。
     */
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.7 MB,击败了59.37% 的Java用户
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index=-1;
        for (int col = 0; col < nums.length; col++) {
            if(nums[col]==0&&index==-1){
                index=col;
            }else if(index!=-1&&nums[col]!=0){
                nums[index++]=nums[col];
                nums[col]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3};
        new A283_MovingZero().moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}
