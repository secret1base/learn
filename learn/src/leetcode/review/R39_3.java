package leetcode.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R39_3 {
    /**
     * 			执行耗时:5 ms,击败了31.67% 的Java用户
     * 			内存消耗:38.7 MB,击败了46.71% 的Java用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            path.offerLast(candidate);
            record(i,target,candidates,path,candidate,list);
            path.pollLast();
        }
        return list;
    }

    private void record(int index, int target, int[] candidates, Deque<Integer> path, int sum, List<List<Integer>> list) {
        if(sum==target){
            list.add(new ArrayList<>(path));
            return;
        }else if(sum>target){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            path.offerLast(candidate);
            record(i,target,candidates,path,candidate+sum,list);
            path.pollLast();
        }
    }

}
