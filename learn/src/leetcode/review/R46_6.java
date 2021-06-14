package leetcode.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R46_6 {
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//			执行耗时:1 ms,击败了97.50% 的Java用户
//			内存消耗:38.7 MB,击败了43.85% 的Java用户
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            path.offerLast(nums[i]);
            used[i]=true;
            doWrite(used,path,list,nums);
            path.pollLast();
            used[i] = false;
        }
        return list;
    }

    private void doWrite(boolean[] used, Deque<Integer> path, List<List<Integer>> list, int[] nums) {
        if(path.size()==nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                used[i]=true;
                path.offerLast(nums[i]);
                doWrite(used,path,list,nums);
                path.pollLast();
                used[i]=false;
            }
        }

    }
}
