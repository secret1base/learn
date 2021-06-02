package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 78.子集
 * @author: wyj
 * @date: 2021/06/01
 */
public class A78_Subsets {
    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *  解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *  示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *  示例 2：
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *  提示：
     *  1 <= nums.length <= 10
     *  -10 <= nums[i] <= 10
     *  nums 中的所有元素 互不相同
     *
     * @param nums
     * @return
     */
    /**
     * 		执行耗时:1 ms,击败了86.38% 的Java用户
     * 		内存消耗:38.5 MB,击败了85.51% 的Java用户
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<> ());
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            path.offerLast(nums[i]);
            list.add(new ArrayList<>(path));
            doRecord(i+1,path,nums,list);
            path.pollLast();
        }
        return list;
    }

    private void doRecord(int i, Deque<Integer> path, int[] nums, List<List<Integer>> list) {
        for (int a = i; a < nums.length; a++) {
            path.offerLast(nums[a]);
            list.add(new ArrayList<>(path));
            doRecord(a+1,path,nums,list);
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new A78_Subsets().subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
