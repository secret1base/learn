package leetcode.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R78_1 {
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//			执行耗时:1 ms,击败了87.14% 的Java用户
//			内存消耗:38.7 MB,击败了58.64% 的Java用户
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        list.add(new ArrayList<>());
        boolean[] used=new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            path.offerLast(nums[i]);
            used[i]=true;
            list.add(new ArrayList<>(path));
            doWrite(i,path,list,nums,used);
            path.pollLast();
            used[i]=false;
        }
        return list;
    }

    private void doWrite(int start, Deque<Integer> path, List<List<Integer>> list, int[] nums, boolean[] used) {
        if(path.size() == nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if(!used[i]){
                path.offerLast(nums[i]);
                used[i]=true;
                list.add(new ArrayList<>(path));
                doWrite(i,path,list,nums, used);
                path.pollLast();
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new R78_1().subsets(new int[]{1, 2, 3});
        for (List<Integer> s : subsets) {
            System.out.println(s);
        }
    }
}
