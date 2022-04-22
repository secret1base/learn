package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 845. 数组中的最长山脉
 * @author: wyj
 * @date: 2021/07/27
 */
public class A845_LongestMountainRangeInArray {
    /**
     * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
     *  B.length >= 3
     *  存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
     * [B.length - 1]
     *  （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
     *  给出一个整数数组 A，返回最长 “山脉” 的长度。
     *  如果不含有 “山脉” 则返回 0。
     *  示例 1：
     *  输入：[2,1,4,7,3,2,5]
     * 输出：5
     * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
     *  示例 2：
     *  输入：[2,2,2]
     * 输出：0
     * 解释：不含 “山脉”。
     *  提示：
     *  0 <= A.length <= 10000
     *  0 <= A[i] <= 10000
     *
     *  之前试着从左到右查找山脉，后面发现还是过于费劲了，还是从中间找比较好
     *  	执行耗时:2 ms,击败了100.00% 的Java用户
     * 		内存消耗:39.6 MB,击败了27.26% 的Java用户
     */
    public int longestMountain(int[] arr) {
        //之前试着从左到右查找山脉，后面发现还是过于费劲了，还是从中间找比较好
        int max=0;
        for (int i=1;i<arr.length-1;i++){
            if(arr[i-1]<arr[i]&&arr[i]>arr[i+1]){
                int tmp=3;
                int left=i-1;
                while (left-1>=0&&arr[left-1]<arr[left]){
                    tmp++;
                    left--;
                }
                int right=i+1;
                while (right+1<arr.length&&arr[right]>arr[right+1]){
                    tmp++;
                    right++;
                }
                max=Math.max(tmp,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new A845_LongestMountainRangeInArray().longestMountain(new int[]{2,1,4,7,3,2,5});
        System.out.println(i);
    }
}
