package leetcode;

import java.util.Arrays;

/**
 * 703. 数据流中的第K大元素
 * @author: wyj
 * @date: 2021/07/13
 */
public class A703_TheKthLargestElementInDataStream {
    /**
     * 			执行耗时:671 ms,击败了5.83% 的Java用户
     * 			内存消耗:45.6 MB,击败了5.04% 的Java用户
     */
    //没考虑效率随便写的
    int[] arr=null;
    int a=-1;
    public A703_TheKthLargestElementInDataStream(int k, int[] nums) {
        arr=nums;
        Arrays.sort(arr);
        a=k;
    }

    public int add(int val) {
        int[] newArr=new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i]=arr[i];
        }
        newArr[newArr.length-1]=val;
        Arrays.sort(newArr);
        arr=newArr;
        return arr[arr.length-a];
    }
}
