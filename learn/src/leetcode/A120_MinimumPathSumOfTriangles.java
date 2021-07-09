package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * @author: wyj
 * @date: 2021/06/26
 */
public class A120_MinimumPathSumOfTriangles {
    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *  每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
     * 正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *  示例 1：
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     *  示例 2：
     * 输入：triangle = [[-10]]
     * 输出：-10
     *
     * 动态规划，憋了好久，题目虽然简单，但是动态规划难写
     * 			执行耗时:4 ms,击败了36.96% 的Java用户
     * 			内存消耗:38.4 MB,击败了66.65% 的Java用户
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] store=new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
            store[i]=new int[triangle.get(i).size()];
        }
        store[0][0]=triangle.get(0).get(0);
        int min=Integer.MAX_VALUE;
        for (int row = 1; row < store.length; row++) {
            for (int j = 0; j < store[row].length;j++){
                //上一层的j-1和j
                int tmp=Integer.MAX_VALUE;
                for (int pre=j-1;pre<j+1;pre++){
                    if(pre>=0&&pre<store[row-1].length){
                        tmp=Math.min(tmp,store[row-1][pre]);
                    }
                }
                store[row][j]=tmp+triangle.get(row).get(j);
            }
        }
        int[] ints = store[store.length - 1];
        for (int a : ints) {
            min = Math.min(min, a);
        }
        return min;
    }
//    /**
//     * 回溯算法又超时了，看来还是得试试动态规划
//     */
//    int min=Integer.MAX_VALUE;
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int size = triangle.size();
////        Deque<Integer> path=new LinkedList<>();
//        recordMin(0,0,0,size,triangle);
//        return min;
//    }
//
//    private void recordMin(int level, int index, int sum, int size, List<List<Integer>> triangle) {
//        if(level==size){
//            min=Math.min(min,sum);
////            System.out.println(path);
//            return;
//        }
//        for (int i = index; i <=index+1&&i<triangle.get(level).size();i++){
////            path.offerLast(triangle.get(level).get(i));
//            recordMin(level+1,i,sum+triangle.get(level).get(i),size,triangle);
////            path.pollLast();
//        }
//    }

    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<>();
        {
            List<Integer> a= new ArrayList<>();
            a.add(2);
            list.add(a);
        }
        {
            List<Integer> a= new ArrayList<>();
            a.add(3);
            a.add(4);
            list.add(a);
        }
        {
            List<Integer> a= new ArrayList<>();
            a.add(6);
            a.add(5);
            a.add(7);
            list.add(a);
        }
        {
            List<Integer> a= new ArrayList<>();
            a.add(4);
            a.add(1);
            a.add(8);
            a.add(3);
            list.add(a);
        }
        int i = new A120_MinimumPathSumOfTriangles().minimumTotal(list);
        System.out.println(i);
    }
}
