package leetcode;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * @author: wyj
 * @date: 2021/06/22
 */
public class A189_RotationArray {
    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *  进阶：
     *  尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     *  你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     *  示例 1:
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *  示例 2:
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     */
    /**
     * 			执行耗时:1 ms,击败了63.53% 的Java用户
     * 			内存消耗:55 MB,击败了63.15% 的Java用户
     */
    public void rotate(int[] nums, int k) {
        while (k-nums.length>=0){
            k=k-nums.length;
        }
        int[] arr=new int[nums.length];
        int index=0;
        for (int i = nums.length-k; i < nums.length; i++) {
            arr[index++]=nums[i];
        }
        for (int i = 0; i < nums.length-k; i++) {
            arr[index++]=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=arr[i];
        }
    }
//    /**
//     * 超时了
//     * @param nums
//     * @param k
//     */
//    public void rotate(int[] nums, int k) {
//        for (int i = 0; i < k; i++) {
//            //移动k次，每次将最后面的元素放到最前面
//            Integer num=null;
//            for (int j = 0; j < nums.length; j++) {
//                if(num==null){
//                    num = nums[j];
//                    nums[j]=nums[nums.length - 1];
//                }else{
//                    int tmp = nums[j];
//                    nums[j]=num;
//                    num=tmp;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] ints = {1, 2};
        new A189_RotationArray().rotate(ints,3);
        System.out.println(Arrays.toString(ints));
    }
}
