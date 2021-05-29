package leetcode.review;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R46_5 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new R46_5().permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }

    /**
     * 		执行耗时:2 ms,击败了55.26% 的Java用户
     * 		内存消耗:38.8 MB,击败了24.85% 的Java用户
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        Deque<Integer> path=new LinkedList<>();
        boolean[] used=new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            path.offer(nums[i]);
            used[i]=true;
            doRecord(nums,path,used,list);
            used[i]=false;
            path.poll();
        }
        return list;
    }

    private void doRecord(int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> list) {
        if(path.size()==nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.offerLast(nums[i]);
                used[i]=true;
                doRecord(nums,path,used,list);
                path.pollLast();
                used[i]=false;
            }
        }
    }
}
