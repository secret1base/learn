package leetcode.review;

import java.util.*;

/**
 * @author: wyj
 * @date: 2021/06/30
 */
public class R40_1 {
    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *  candidates 中的每个数字在每个组合中只能使用一次。
     *  说明：
     *  所有数字（包括目标数）都是正整数。
     *  解集不能包含重复的组合。
     *  示例 1:
     *  输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     *  示例 2:
     *  输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     *      执行耗时:6 ms,击败了27.28% 的Java用户
     * 		内存消耗:38.8 MB,击败了22.12% 的Java用户
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        for (int a = 0; a < candidates.length; a++) {
            if(a-1>=0&&candidates[a]==candidates[a-1]){
                continue;
            }
            path.offerLast(candidates[a]);
            record(candidates[a],path,candidates,target,list,a);
            path.pollLast();
        }
        return list;
    }

    private void record(int sum, Deque<Integer> path, int[] candidates, int target, List<List<Integer>> list, int index) {
        if(sum==target){
            list.add(new ArrayList<>(path));
            return;
        }else if(sum>target){
            return;
        }
        for (int a = index+1; a < candidates.length; a++) {
            if(a-1>=index+1&&candidates[a]==candidates[a-1]){
                continue;
            }
            path.offerLast(candidates[a]);
            record(candidates[a]+sum,path,candidates,target,list,a);
            path.pollLast();
        }
    }
}
