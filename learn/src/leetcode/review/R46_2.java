package leetcode.review;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/05/20
 */
public class R46_2 {
    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
// 示例 1：
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    public static void main(String[] args) {
        List<List<Integer>> permute = new R46_2().permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        Stack<Integer> tmp=new Stack<>();
        doWrite(0,used,list,nums,tmp);
        return list;
    }

    private void doWrite(int index, boolean[] used, List<List<Integer>> list, int[] nums, Stack<Integer> path) {
        if(index==nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.push(nums[i]);
                used[i] = true;
                doWrite(index+1,used,list,nums,path);
                used[i] = false;
                path.pop();
            }
        }
    }
}
