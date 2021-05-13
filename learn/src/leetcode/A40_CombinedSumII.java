package leetcode;

import java.util.*;

/**
 * 40.组合总和
 * @author: wyj
 * @date: 2021/05/13
 */
public class A40_CombinedSumII {
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
     */
    public static void main(String[] args) {
//        List<List<Integer>> list = new A40_CombinedSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//        List<List<Integer>> list = new A40_CombinedSumII().combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 27);
        List<List<Integer>> list = new A40_CombinedSumII().combinationSum2(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
    List<List<Integer>> list=new ArrayList<>();
    Map<String,Integer> exits=new HashMap<>();

    /**
     * 思路与39题基本一致，但多了几个注意事项：
     * 1、先对数组进行排序
     * 2、每个位置的值只可以使用一次
     * 3、进入递归后在遍历的第3次的值如果和第二次的值相等那么第三次不进入递归(也就是下面注释剪枝的部分)
     * 			执行耗时:19 ms,击败了16.63% 的Java用户
     * 			内存消耗:39 MB,击败了11.51% 的Java用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> tmp=new ArrayList<>();
            tmp.add(candidates[i]);
            doWrite(i,candidates[i],candidates,target,tmp);
        }
        return list;
    }

    private boolean doWrite(int i, int sum, int[] candidates, int target, List<Integer> tmp) {
        if(sum==target){
            String s = tmp.toString();
            Integer orDefault = exits.getOrDefault(s, -1);
            if (orDefault == -1) {
                list.add(tmp);
                exits.put(s,0);
            }
            return true;
        }else if(sum>target){
            return false;
        }else{
            for (int k=i+1;k<candidates.length;k++){
                //这一块的剪枝特别重要，当i+1后面的元素出现重复值时可以不进行重复执行
                if (k>i+1&&candidates[k] == candidates[k-1]){
                    continue;
                }
                List<Integer> newList=new ArrayList<>();
                for (Integer integer : tmp) {
                    newList.add(integer);
                }
                newList.add(candidates[k]);
                doWrite(k, sum+candidates[k], candidates, target, newList);
            }
        }
        return false;
    }
}
