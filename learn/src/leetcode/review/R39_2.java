package leetcode.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R39_2 {
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
public static void main(String[] args) {
    List<List<Integer>> list = new R39_2().combinationSum(new int[]{2, 3, 6, 7}, 7);
    for (List<Integer> integers : list) {
        System.out.println(integers);
    }
}
//			执行耗时:5 ms,击败了31.82% 的Java用户
//			内存消耗:39.1 MB,击败了10.50% 的Java用户
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            path.offerLast(candidates[i]);
            doWrite(candidates[i],target,list,path,candidates,i);
            path.pollLast();
        }
        return list;
    }

    private void doWrite(int sum, int target, List<List<Integer>> list, Deque<Integer> path, int[] candidates, int start) {
        if(sum==target){
            list.add(new ArrayList<>(path));
            return;
        }else if(sum>target){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.offerLast(candidates[i]);
            doWrite(candidates[i]+sum,target,list,path,candidates, i);
            path.pollLast();
        }
    }
}
