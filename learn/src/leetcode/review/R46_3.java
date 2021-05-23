package leetcode.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R46_3 {
    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        boolean[] used=new boolean[nums.length];
        doWrite(path,used,list,nums);
        return list;
    }

    private void doWrite(Deque<Integer> path, boolean[] used, List<List<Integer>> list, int[] nums) {
        if(path.size()==nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.push(nums[i]);
                used[i]=true;
                doWrite(path,used,list,nums);
                path.poll();
                used[i]=false;
            }
        }
    }
}
