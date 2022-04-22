package leetcode;

import java.util.Arrays;

/**
 * 130. 被围绕的区域
 * @author: wyj
 * @date: 2021/07/28
 */
public class A130_SurroundedAreas {
    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
     *  示例 1：
     * 输入：board = [
     * ["X","X","X","X"],
     * ["X","O","O","X"],
     * ["X","X","O","X"],
     * ["X","O","X","X"]]
     * 输出：[
     * ["X","X","X","X"],
     * ["X","X","X","X"],
     * ["X","X","X","X"],
     * ["X","O","X","X"]]
     * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     *  示例 2：
     * 输入：board = [["X"]]
     * 输出：[["X"]]
     *  提示：
     *  m == board.length
     *  n == board[i].length
     *  1 <= m, n <= 200
     *  board[i][j] 为 'X' 或 'O'
     *
     *  调试后通过
     *  		执行耗时:3 ms,击败了33.66% 的Java用户
     * 			内存消耗:40.5 MB,击败了52.25% 的Java用户
     */
    public void solve(char[][] board) {
        //记录边界0以及与边界相连接的0
        char[][] os=new char[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(row==0&&col==1){
                    System.out.println("");
                }
                if((col==0||row==0||col==board[row].length-1||row==board.length-1)&&board[row][col]=='O'){
                    os[row][col]='O';
                    //更新四个方向的'O'
                    update(row,col,board,os);
                }
            }
        }
        for (int row = 0; row < os.length; row++) {
            for (int col = 0; col < os[row].length; col++) {
                board[row][col]=os[row][col]=='O'?'O':'X';
            }
        }
    }

    private void update(int row, int col, char[][] board, char[][] os) {
        if(row-1>=0&&board[row-1][col]=='O'&&os[row-1][col]!='O'){
            os[row-1][col]='O';
            update(row-1, col, board, os);
        }
        if(row+1<board.length&&board[row+1][col]=='O'&&os[row+1][col]!='O'){
            os[row+1][col]='O';
            update(row+1, col, board, os);
        }
        if(col-1>=0&&board[row][col-1]=='O'&&os[row][col-1]!='O'){
            os[row][col-1]='O';
            update(row, col-1, board, os);
        }
        if(col+1<board[row].length&&board[row][col+1]=='O'&&os[row][col+1]!='O'){
            os[row][col+1]='O';
            update(row, col+1, board, os);
        }
    }

    public static void main(String[] args) {
        char[][] chars ={{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        new A130_SurroundedAreas().solve(chars);
        for (char[] aChar : chars) {
            System.out.println(Arrays.toString(aChar));
        }
    }


}
