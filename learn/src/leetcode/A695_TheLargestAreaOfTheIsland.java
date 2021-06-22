package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 695. 岛屿的最大面积
 * @author: wyj
 * @date: 2021/06/17
 */
public class A695_TheLargestAreaOfTheIsland {
    /**
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
     * 这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被0（代表水）包围着。
     *  找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     *  示例 1:
     *  [
     *  [0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]
     *  ]
     *  对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     *  示例 2:
     *  [[0,0,0,0,0,0,0,0]]
     *  对于上面这个给定的矩阵, 返回 0。
     *
     *  		执行耗时:4 ms,击败了30.70% 的Java用户
     * 			内存消耗:38.7 MB,击败了92.17% 的Java用户
     */
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        //题目与计算岛屿数量类似
        boolean[][] used=new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++) {
                int i = grid[row][col];
                if(i==1&&!used[row][col]){
                    List<Integer> list=new ArrayList<>();
                    updateUsed(list,used,row,col,grid);
                    max=Math.max(max,list.size());
                }
            }
        }
        return max;
    }

    private void updateUsed(List<Integer> list, boolean[][] used, int row, int col, int[][] grid) {
        if(grid[row][col]==1&&!used[row][col]){
            used[row][col]=true;
            list.add(1);
        }else{
            return;
        }
        //上下左右
        if(row-1>=0){
            updateUsed(list,used,row-1,col,grid);
        }
        if(row+1<grid.length){
            updateUsed(list,used,row+1,col,grid);
        }
        if(col-1>=0){
            updateUsed(list,used,row,col-1,grid);
        }
        if(col+1<grid[row].length){
            updateUsed(list,used,row,col+1,grid);
        }
    }

    public static void main(String[] args) {
        int i = new A695_TheLargestAreaOfTheIsland().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
        );
        System.out.println(i);
    }
}
