package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * @author: wyj
 * @date: 2021/04/19
 */
public class A18_SumOfFourNumbers {
    /**
     * 18. 四数之和
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：答案中不可以包含重复的四元组。
     * 示例 1：
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     * 输入：nums = [], target = 0
     * 输出：[]
     * 提示：
     * 0 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */
    public static void main(String[] args) {
//        List<List<Integer>> list = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        List<List<Integer>> list = fourSum(new int[]{-1,0,1,2,-1,-4}, -1);
//        List<List<Integer>> list = fourSum(new int[]{0,0,0}, 0);
        System.out.println(list);
    }

    /**
     * 执行用时：25 ms, 在所有 Java 提交中击败了22.57%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了50.23%的用户
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length<4){
            return list;
        }
        Arrays.sort(nums);
        int a;
        int one;
        int two;
        int three;
        int length = nums.length;
        for(a=0;a<length;a++){
            if(a>0&&nums[a]==nums[a-1]){
                continue;
            }
            for(one=a+1;one<length;one++){
                if(one>a+1&&nums[one] == nums[one-1]){
                    continue;
                }
                for (two=one+1;two<length;two++){
                    if(two>one+1&&nums[two] == nums[two-1]){
                        continue;
                    }
                    three=length-1;
                    while (three>two&&nums[one]+nums[two]+nums[three]+nums[a]>target){
                        three--;
                    }
                    if(three==two){
                        break;
                    }
                    if(nums[one]+nums[two]+nums[three]+nums[a]==target){
                        List<Integer> tmp=new ArrayList<>();
                        tmp.add(nums[a]);
                        tmp.add(nums[one]);
                        tmp.add(nums[two]);
                        tmp.add(nums[three]);
                        list.add(tmp);
                    }
                }
            }
        }
        return list;
    }
}
