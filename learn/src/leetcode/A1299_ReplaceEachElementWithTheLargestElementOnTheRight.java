package leetcode;

import java.util.Arrays;

/**
 * 1299. 将每个元素替换为右侧最大元素
 * @author: wyj
 * @date: 2021/07/26
 */
public class A1299_ReplaceEachElementWithTheLargestElementOnTheRight {
    /**
     * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
     *  完成所有替换操作后，请你返回这个数组。
     *  示例 1：
     * 输入：arr = [17,18,5,4,6,1]
     * 输出：[18,6,6,6,1,-1]
     * 解释：
     * - 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
     * - 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
     * - 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
     * - 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
     * - 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
     * - 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
     *  示例 2：
     * 输入：arr = [400]
     * 输出：[-1]
     * 解释：下标 0 的元素右侧没有其他元素。
     *  提示：
     *  1 <= arr.length <= 104
     *  1 <= arr[i] <= 105
     *  		执行耗时:2 ms,击败了68.03% 的Java用户
     * 			内存消耗:39 MB,击败了99.24% 的Java用户
     */
    public int[] replaceElements(int[] arr) {
        int[] right=new int[arr.length];
        for (int i = arr.length - 1; i >=0; i--) {
            if(i==arr.length-1){
                right[i]=-1;
            }else{
                //右侧元素或者右侧最大值
                right[i]=Math.max(arr[i+1],right[i+1]);
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] ints = new A1299_ReplaceEachElementWithTheLargestElementOnTheRight().replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        System.out.println(Arrays.toString(ints));
    }
}
