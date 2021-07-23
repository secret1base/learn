package leetcode;

/**
 * 977. 有序数组的平方
 * @author: wyj
 * @date: 2021/07/13
 */
public class A977_SquareOfOrderedArray {
    /**
     * 			执行耗时:494 ms,击败了5.01% 的Java用户，用Arrays.sort(arr);可以提升到48%
     * 			内存消耗:40.3 MB,击败了30.14% 的Java用户
     */
    public int[] sortedSquares(int[] nums) {
        int[] arr=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i]=nums[i]*nums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int tmp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        return arr;
    }
}
