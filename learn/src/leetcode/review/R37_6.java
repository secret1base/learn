package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R37_6 {
// ["5","3",".",".","7",".",".",".","."],
// ["6",".",".","1","9","5",".",".","."],
// [".","9","8",".",".",".",".","6","."],
// ["8",".",".",".","6",".",".",".","3"],
// ["4",".",".","8",".","3",".",".","1"],
// ["7",".",".",".","2",".",".",".","6"],
// [".","6",".",".",".",".","2","8","."],
// [".",".",".","4","1","9",".",".","5"],
// [".",".",".",".","8",".",".","7","9"]]

    /**
     * 			执行耗时:4 ms,击败了62.13% 的Java用户
     * 			内存消耗:36 MB,击败了32.13% 的Java用户
     * @param board
     */
    public void solveSudoku(char[][] board) {
    boolean[][] rowp=new boolean[board.length][10];
    boolean[][] colp=new boolean[board[0].length][10];
    boolean[][][] p=new boolean[board.length/3][board[0].length/3][10];
    //初始化
    for (int row=0;row<board.length;row++){
        for (int col = 0; col < board[row].length; col++) {
            char c = board[row][col];
            if(Character.isDigit(c)){
                int num = c - '0';
                rowp[row][num]=true;
                colp[col][num]=true;
                p[row/3][col/3][num]=true;
            }
        }
    }
    record(0,0,rowp,colp,p,board);
}

    private boolean record(int row, int col, boolean[][] rowp, boolean[][] colp, boolean[][][] p, char[][] board) {
        if(col==board[row].length){
            col=0;
            row++;
            if(row==board.length){
                return true;
            }
        }
        if(!Character.isDigit(board[row][col])){
            for (int i = 1; i < 10; i++) {
                boolean b = rowp[row][i] || colp[col][i] || p[row/3][col/3][i];
                if(!b){
                    rowp[row][i]=true;
                    colp[col][i]=true;
                    p[row/3][col/3][i]=true;
                    board[row][col]=Character.forDigit(i,10);
                    if(record(row,col+1,rowp,colp,p,board)){
                        return true;
                    }
                    rowp[row][i]=false;
                    colp[col][i]=false;
                    p[row/3][col/3][i]=false;
                    board[row][col]='.';
                }
            }
        }else{
            if(record(row,col+1,rowp,colp,p,board)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] a=new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new R37_6().solveSudoku(a);
        for (char[] chars : a) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
