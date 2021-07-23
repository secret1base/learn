package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * @author: wyj
 * @date: 2021/07/16
 */
public class A77_Combination {
    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *  示例:
     *  输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     *
     * 			执行耗时:18 ms,击败了59.09% 的Java用户
     * 			内存消耗:39.4 MB,击败了93.53% 的Java用户
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            path.offerLast(i);
            record(path,list,n,k,i);
            path.pollLast();
        }
        return list;
    }

    private void record(Deque<Integer> path, List<List<Integer>> list, int n, int k,int begin) {
        if(path.size()==k){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin+1; i <= n; i++) {
            path.offerLast(i);
            record(path,list, n, k,i);
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new A77_Combination().combine(4, 2);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }
}
