package leetcode;

import java.util.Arrays;

/**
 * 200.岛屿数量
 * @author: wyj
 * @date: 2021/05/17
 */
public class A200_NumberOfIslands {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *  岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *  此外，你可以假设该网格的四条边均被水包围。
     *  示例 1：
     * 输入：grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * 输出：1
     *  示例 2：
     * 输入：grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * 输出：3
     *  提示：
     *  m == grid.length
     *  n == grid[i].length
     *  1 <= m, n <= 300
     *  grid[i][j] 的值为 '0' 或 '1'
     */
    public static void main(String[] args) {
        int i = new A200_NumberOfIslands().numIslands(new char[][]{{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}});
//        int i = new A200_NumberOfIslands().numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
//        int i = new A200_NumberOfIslands().numIslands(new char[][]{{'1'}});
//        int i = new A200_NumberOfIslands().numIslands(new char[][]{{'1','1','1'},{'1','1','1'},{'1','1','1'}});
        System.out.println(i);
    }
    /**
     * 解题思路参考n皇后
     * 通过attack标记已经被使用过的1
     * 			执行耗时:5 ms,击败了21.00% 的Java用户
     * 			内存消耗:46.7 MB,击败了5.08% 的Java用户
     * @param grid
     * @return
     */
    int count=0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        boolean[][] attack=new boolean[grid.length][grid[0].length];
        doWrite(0,0,attack,grid);
        return count;
    }

    private void doWrite(int col, int row, boolean[][] attack, char[][] grid) {
        if(col==grid[row].length){
            col=0;
            row++;
            if(row == grid.length){
                return;
            }
        }
        char c = grid[row][col];
        if(c=='1'){
            //判断是否被标记过
            if(!attack[row][col]){
                //没有被标记过
                //岛屿数量加1
                count++;
                //更新岛屿连接范围
                updateAttack(col,row,attack,grid);
                doWrite(col+1,row,attack,grid);
            }else{
                doWrite(col+1,row,attack,grid);
            }
        }else{
            doWrite(col + 1, row, attack, grid);
        }
    }

    private void updateAttack(int col, int row, boolean[][] attack, char[][] grid) {
        if(attack[row][col]){
            return;
        }
        attack[row][col]=true;
        //向上、下、左、右进行标记
        //向右
        if (col + 1 < attack[row].length) {
            if (grid[row][col + 1] == '1') {
                updateAttack(col + 1, row, attack, grid);
            }
        }
        //向下找连接岛屿
        if (row + 1 < attack.length) {
            if (grid[row + 1][col] == '1') {
                updateAttack(col, row + 1, attack, grid);
            }
        }
        //向上
        if (row - 1 >=0) {
            if (grid[row - 1][col] == '1') {
                updateAttack(col, row - 1, attack, grid);
            }
        }
        //向左
        if (col - 1 >=0) {
            if (grid[row][col - 1] == '1') {
                updateAttack(col - 1, row, attack, grid);
            }
        }
    }
}
