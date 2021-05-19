package leetcode.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R46_1 {
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
        List<List<Integer>> permute = new R46_1().permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
    //		执行耗时:2 ms,击败了54.44% 的Java用户
    //			内存消耗:38.4 MB,击败了91.92% 的Java用户
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        Deque<Integer> stack=new LinkedList<>();
        int n = nums.length;
        doUse(n,nums,used,stack,list);
        return list;
    }

    private void doUse(int n, int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> list) {
        if(path.size()==n){
            list.add(new ArrayList<>(path));
        }
        for (int i = 0; i < n; i++) {
            if(!used[i]){
                //标记使用
                used[i]=true;
                //添加
                path.push(nums[i]);
                //进行下一次
                doUse(n, nums, used,path, list);
                //撤退
                used[i] = false;
                path.poll();
            }
        }
    }

}
