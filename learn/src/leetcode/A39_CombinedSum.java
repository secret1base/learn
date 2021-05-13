package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * @author: wyj
 * @date: 2021/04/28
 */
public class A39_CombinedSum {
    /**
     * 39. 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2：
     *
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     * 提示：
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     */
    /**
     * 需要通过搜索回溯算法解决
     * @return
     */
    public static void main(String[] args) {
        List<List<Integer>> list = new A39_CombinedSum().combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
    public List<List<Integer>> list=new ArrayList<>();

    /**
     *
     * 			执行耗时:9 ms,击败了8.41% 的Java用户
     * 			内存消耗:39.2 MB,击败了6.10% 的Java用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> tmp=new ArrayList<>();
            tmp.add(candidates[i]);
            doWrite(i,candidates[i],candidates,target,tmp);
        }
        return list;
    }

    private boolean doWrite(int i,int sum,int[] candidates, int target,List<Integer> tmp) {
        if(sum==target){
            list.add(tmp);
            return true;
        }else if(sum>target){
            return false;
        }else {
            for (int k=i; k < candidates.length; k++) {
                List<Integer> newList=new ArrayList<>();
                for (Integer integer : tmp) {
                    newList.add(integer);
                }
                newList.add(candidates[k]);
                doWrite(k,sum+candidates[k],candidates,target,newList);
            }
        }
        return false;
    }


}
