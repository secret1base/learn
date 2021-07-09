package leetcode;

import java.util.*;

/**
 * 47. 全排列 II
 * @author: wyj
 * @date: 2021/06/24
 */
public class A47_FullArrayII {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *  示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     *  示例 2：
     * 输入：nums = [1,2,3]
     * 输出：[
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]]
     *
     */
    /**
     * 不追求效率的化比预期的简单
     * 		执行耗时:132 ms,击败了7.09% 的Java用户
     * 		内存消耗:39.3 MB,击败了27.11% 的Java用户
     */
    Map<String,Integer> map=new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int length = nums.length;
        boolean[] used=new boolean[length];
        Deque<Integer> path=new LinkedList<>();
        for (int i = 0; i < nums.length;i++){
            path.offerLast(nums[i]);
            used[i]=true;
            record(length,used,path,list,nums);
            used[i]=false;
            path.pollLast();
        }
        return list;
    }

    private void record(int length, boolean[] used, Deque<Integer> path, List<List<Integer>> list, int[] nums) {
        if(length==path.size()){
            ArrayList<Integer> tmp = new ArrayList<>(path);
            String s = tmp.toString();
            Integer orDefault = map.getOrDefault(s, 0);
            if(orDefault==0){
                list.add(tmp);
                map.put(s,1);
            }
            return;
        }
        for (int i = 0; i < nums.length;i++){
            if(!used[i]){
                path.offerLast(nums[i]);
                used[i]=true;
                record(length,used,path,list,nums);
                used[i]=false;
                path.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new A47_FullArrayII().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}
