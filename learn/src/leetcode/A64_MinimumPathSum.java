package leetcode;

import java.util.*;

/**
 * 64.最小路径和
 * @author: wyj
 * @date: 2021/06/11
 */
public class A64_MinimumPathSum {
    /**
     * 注意：只能向右、向下走，之前解题没有留意到
     * 			执行耗时:2 ms,击败了98.22% 的Java用户
     * 			内存消耗:41 MB,击败了78.41% 的Java用户
     * 	动态规划
     * 	解题思路64.docx
     */
    public int minPathSum(int[][] grid) {
        //动态规划
        int[][] store=new int[grid.length][grid[0].length];
        //初始化顶部和左侧的两条边
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(row==0&&col==0){
                    store[row][col]=grid[row][col];
                }else if(row==0){
                    store[row][col]=store[row][col-1]+grid[row][col];
                }else if(col==0){
                    store[row][col] = store[row-1][col] + grid[row][col];
                }
            }
        }
        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[row].length; col++) {
                //取上、左的最小值+当前grid格的值
                store[row][col]=Math.min(store[row-1][col],store[row][col-1])+grid[row][col];
            }
        }
//        for (int[] ints : store) {
//            System.out.println(Arrays.toString(ints));
//        }
        return store[grid.length - 1][grid[0].length-1];
    }
    public static void main(String[] args) {
        //47
//        int list = new A64_MinimumPathSum().minPathSum(new int[][]{{1,4,8,6,2,2,1,7},{4,7,3,1,4,5,5,1},{8,8,2,1,1,8,0,1},{8,9,2,9,8,0,8,9},{5,7,5,7,1,8,5,5},{7,0,9,4,5,6,5,6},{4,9,9,7,9,1,9,0}});
        int list = new A64_MinimumPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
        System.out.println(list);
    }
    /**
     * 回溯算法超时
     */
//    int minSum=Integer.MAX_VALUE;
//    public int minPathSum(int[][] grid) {
//        int y = grid.length;
//        int x=grid[0].length;
//        boolean[][] used=new boolean[y][x];
//        walk(0,0,grid[0][0],grid,used);
//        return minSum;
//    }
//
//    private void walk(int row, int col, int sum, int[][] grid, boolean[][] used) {
//        if(row==grid.length-1&&col==grid[row].length-1){
//            minSum=Math.min(minSum,sum);
//            return;
//        }
//        /**
//         *       x,y-1
//         * x-1,y x,y   x+1,y
//         *       x,y+1
//         */
//        if(row+1<grid.length&&!used[row+1][col]){
//            //向下
//            used[row+1][col]=true;
//            walk(row+1,col,sum+grid[row+1][col],grid,used);
//            used[row+1][col] = false;
//        }
//        if(col+1<grid[row].length&&!used[row][col+1]){
//            //右
//            used[row][col+1]=true;
//            walk(row,col+1,sum+grid[row][col+1],grid,used);
//            used[row][col+1] = false;
//        }
//    }
}
