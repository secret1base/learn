package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/07/12
 */
public class R18_1 {
    //给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。
// 注意：答案中不可以包含重复的四元组。
// 示例 1：
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 示例 2：
//输入：nums = [], target = 0
//输出：[]

    /**
     * 			执行耗时:139 ms,击败了6.44% 的Java用户
     * 			内存消耗:38.9 MB,击败了44.16% 的Java用户
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length-3; a++) {
            if(a-1>=0&&nums[a]==nums[a-1]){
                continue;
            }
            for (int b=a+1;b<nums.length-2;b++){
                if(b-1>=a+1&&nums[b]==nums[b-1]){
                    continue;
                }
                for (int c=b+1;c<nums.length-1;c++){
                    if(c-1>=b+1&&nums[c]==nums[c-1]){
                        continue;
                    }
                    for(int d=c+1;d<nums.length;d++){
                        if(d-1>=c+1&&nums[d]==nums[d-1]){
                            continue;
                        }
                        //因为是从最小起步的因此，一旦四数之和比target大，就没有继续的必要
                        if(nums[a]+nums[b]+nums[c]+nums[d]>target){
                            break;
                        }else if(nums[a]+nums[b]+nums[c]+nums[d]==target){
                            List<Integer> tmp=new ArrayList<>();
                            tmp.add(nums[a]);
                            tmp.add(nums[b]);
                            tmp.add(nums[c]);
                            tmp.add(nums[d]);
                            list.add(tmp);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new R18_1().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}
