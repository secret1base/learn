package leetcode.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R46_4 {
    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    public static void main(String[] args) {
        List<List<Integer>> permute = new R46_4().permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Stack<Integer> path=new Stack<>();
        boolean[] used=new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            path.push(nums[i]);
            used[i]=true;
            doWrite(used,path,nums,list);
            path.pop();
            used[i]=false;
        }
        return list;
    }

    private void doWrite( boolean[] used, Stack<Integer> path, int[] nums, List<List<Integer>> list) {
        if(path.size()==nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.push(nums[i]);
                used[i]=true;
                doWrite(used,path,nums,list);
                path.pop();
                used[i]=false;
            }
        }
    }
}
