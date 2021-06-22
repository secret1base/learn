package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 128.最长连续序列
 * @author: wyj
 * @date: 2021/06/16
 */
public class A128_LongestContinuousSequence {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *  进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
     *  示例 1：
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *  示例 2：
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *
     * 			执行耗时:12 ms,击败了51.70% 的Java用户
     * 			内存消耗:44.4 MB,击败了31.69% 的Java用户
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int max=1;
        int count=1;
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]+1){
                count++;
                max=Math.max(max,count);
            }else if(i>0&&nums[i] == nums[i-1]){
                //不进行处理
            }else{
                count=1;
            }
        }
        return max;
    }

//    /**
//     * 去重排序的超时了
//     */
//    public int longestConsecutive(int[] nums) {
//        if(nums.length==0){
//            return 0;
//        }
//        //需要去重排序
//        List<Integer> list= new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(!list.contains(nums[i])){
//                list.add(nums[i]);
//            }
//        }
//        Collections.sort(list);
//        int max=1;
//        int count=1;
//        for (int i = 0; i < list.size(); i++) {
//            if(i>0&&list.get(i)==list.get(i-1)+1){
//                count++;
//                max=Math.max(max,count);
//            }else{
//                count=1;
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
//        int i = new A128_LongestContinuousSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        int i = new A128_LongestContinuousSequence().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        System.out.println(i);
    }
}
