package leetcode;

/**
 * 922. 按奇偶排序数组 II
 * @author: wyj
 * @date: 2021/07/26
 */
public class A922_SortArrayByParityII {
    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *  对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *  你可以返回任何满足上述条件的数组作为答案。
     *  示例：
     *  输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     *  提示：
     *  2 <= A.length <= 20000
     *  A.length % 2 == 0
     *  0 <= A[i] <= 1000
     *  		执行耗时:2 ms,击败了100.00% 的Java用户
     * 			内存消耗:40.1 MB,击败了49.79% 的Java用户
     */
    public int[] sortArrayByParityII(int[] nums) {
        //偶数
        int[] left=new int[nums.length/2];
        //奇数
        int[] right=new int[nums.length/2];
        int l=0;
        int r=0;
        for (int num : nums) {
            if(num%2==0){
                left[l++]=num;
            }else{
                right[r++]=num;
            }
        }
        l=0;
        r=0;
        for (int i = 0; i < nums.length; i++) {
            int val=0;
            if(i%2==0){
                val = left[l++];
            }else{
                val=right[r++];
            }
            nums[i]=val;
        }
        return nums;
    }
}
