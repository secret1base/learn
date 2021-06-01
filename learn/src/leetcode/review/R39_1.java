package leetcode.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/01
 */
public class R39_1 {
    /**
     * 		执行耗时:5 ms,击败了31.79% 的Java用户
     * 		内存消耗:39 MB,击败了12.54% 的Java用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            path.offerLast(candidates[i]);
            doRecord(i,candidates[i],target,path,list,candidates);
            path.pollLast();
        }
        return list;
    }

    private void doRecord(int index, int sum, int target, Deque<Integer> path, List<List<Integer>> list, int[] candidates) {
        if(sum==target){
            list.add(new ArrayList<>(path));
            return;
        }else if(sum>target){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.offerLast(candidates[i]);
            doRecord(i,sum+candidates[i],target,path,list,candidates);
            path.pollLast();
        }
    }
}
