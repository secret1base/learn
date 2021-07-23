package leetcode;

/**
 * 1254. 统计封闭岛屿的数目
 * @author: wyj
 * @date: 2021/07/21
 */
public class A1254_StatisticsOnTheNumberOfClosedIslands {
    /**
     * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
     *  我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
     *  如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
     *  请返回封闭岛屿的数目。
     *  示例 1：
     *  输入：grid = [
     *  [1,1,1,1,1,1,1,0],
     *  [1,0,0,0,0,1,1,0],
     *  [1,0,1,0,1,1,1,0],
     *  [1,0,0,0,0,1,0,1],
     *  [1,1,1,1,1,1,1,0]]
     * 输出：2
     * 解释：
     * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
     *
     *  示例 2：
     *  输入：grid = [
     *  [0,0,1,0,0],
     *  [0,1,0,1,0],
     *  [0,1,1,1,0]]
     * 输出：1
     *
     *
     *  示例 3：
     *
     *  输入：grid = [
     * [1,1,1,1,1,1,1],
     * [1,0,0,0,0,0,1],
     * [1,0,1,1,1,0,1],
     * [1,0,1,0,1,0,1],
     * [1,0,1,1,1,0,1],
     * [1,0,0,0,0,0,1],
     * [1,1,1,1,1,1,1]]
     * 输出：2
     *  提示：
     *  1 <= grid.length, grid[0].length <= 100
     *  0 <= grid[i][j] <=1
     *
     *  一次过
     *  		执行耗时:3 ms,击败了39.86% 的Java用户
     * 			内存消耗:39 MB,击败了25.14% 的Java用户
     */
    public int closedIsland(int[][] grid) {
        //边界为false,岛屿中但凡陆地靠近边界即为false
        //记录各个陆地是否为false
        boolean[][] arr=new boolean[grid.length][grid[0].length];
        //记录各个陆地是否被使用
        boolean[][] used=new boolean[grid.length][grid[0].length];
        //初始化
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                //除了边界都是true
                if(row!=0&&row!=grid.length-1&&col!=0&&col!=grid[row].length-1){
                    arr[row][col]=true;
                }
            }
        }
        int count=0;
        //放弃从边界开始找
        for (int row=1;row<grid.length-1;row++){
            for (int col = 1; col < grid[row].length-1; col++) {
                if(grid[row][col]==0&&!used[row][col]){
                    //这是陆地,对陆地进行延申
                    if(climb(row,col,arr,used,grid)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean climb(int row, int col, boolean[][] arr, boolean[][] used, int[][] grid) {
        used[row][col]=true;
        //对四个方向进行延申
        if(row-1>=0&&grid[row-1][col]==0&&!used[row-1][col]){
            arr[row][col]=climb(row-1,col,arr,used,grid)&&arr[row][col];
        }
        if(row+1<arr.length&&grid[row+1][col]==0&&!used[row+1][col]){
            arr[row][col]=climb(row+1,col,arr,used,grid)&&arr[row][col];
        }
        if(col-1>=0&&grid[row][col-1]==0&&!used[row][col-1]){
            arr[row][col]=climb(row,col-1,arr,used,grid)&&arr[row][col];
        }
        if(col+1<arr[row].length&&grid[row][col+1]==0&&!used[row][col+1]){
            arr[row][col]=climb(row,col+1,arr,used,grid)&&arr[row][col];
        }
        return arr[row][col];
    }

    public static void main(String[] args) {
        int i = new A1254_StatisticsOnTheNumberOfClosedIslands().closedIsland(new int[][]{{1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1}});
        System.out.println(i);
    }
}
