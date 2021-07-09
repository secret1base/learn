package leetcode;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * @author: wyj
 * @date: 2021/07/02
 */
public class A154_FindTheMinimumValueIIInTheRotationSortArray {
    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
     *  若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     *  若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     *  注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2],
     * ..., a[n-2]] 。
     *  给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     *  示例 1：
     * 输入：nums = [1,3,5]
     * 输出：1
     *  示例 2：
     * 输入：nums = [2,2,2,0,1]
     * 输出：0
     *
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.2 MB,击败了78.23% 的Java用户
     */
    public int findMin(int[] nums) {
        //旋转后的数组可以理解为两个升序数组
        //左侧数组的最小值为下标为0的位置，右侧数组的最小值为右侧数组与左侧数组的交界点
        int left=nums[0];
        int min=left;
        for (int right = nums.length-1; right >=0; right--) {
            if(right-1>=0&&nums[right]<nums[right-1]){
                //发现下一个节点是破坏升序排列的节点时，则当前节点为右边这个升序数组的最小值
                min=Math.min(min,nums[right]);
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int min = new A154_FindTheMinimumValueIIInTheRotationSortArray().findMin(new int[]{2, 2, 2, 0, 1});
        System.out.println(min);
    }
}
