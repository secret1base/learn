package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R15_1 {
    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
// 注意：答案中不可以包含重复的三元组。
// 示例 1：
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
    public static void main(String[] args) {
//        List<List<Integer>> list = new R15_1().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        List<List<Integer>> list = new R15_1().threeSum(new int[]{0,0,0,0});
        List<List<Integer>> list = new R15_1().threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            if(a>0&&nums[a-1]==nums[a]){
                //如果和上一个相同则跳过
                continue;
            }
            //加快速度采用左右遍历
            int right=nums.length-1;
            for (int left=a+1; left < nums.length; left++) {
                if(left>a+1&&nums[left]==nums[left-1]){
                    continue;
                }
                while (right>left&&nums[left]+nums[right]>-nums[a]){
                    right--;
                }
                if(left==right){
                    break;
                }
                if(nums[a]+nums[left]+nums[right]==0){
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(nums[a]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    list.add(tmp);
                }
            }
        }
        return list;
    }

}
