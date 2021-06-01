package leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 * @author: wyj
 * @date: 2021/06/01
 */
public class A153_FindTheMinimumValueInTheRotationSortArray {
    /**
     * 思路：不管如何旋转前后部分一定是按升序排列的，首先取第一个值为最小值，中间一旦有值破坏升序排列则该值为最小值
     * 如果没有则一定是已经转回来了，所以第一个值就是最小值
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.9 MB,击败了46.64% 的Java用户
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int min=nums[0];
        for (int i=0;i<nums.length; i++){
            if(i+1<nums.length&&nums[i]>nums[i+1]){
                return nums[i+1];
            }
        }
        return min;
    }
}
