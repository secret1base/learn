package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/15
 */
public class R37_2 {
    // 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//
//
//
//
//
// 示例：
//
//
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]

    /**
     * 执行耗时:4 ms,击败了61.97% 的Java用户 内存消耗:35.8 MB,击败了68.01% 的Java用
     * @param board
     */
    public void solveSudoku(char[][] board) {
        boolean[][] rowp=new boolean[board.length][10];
        boolean[][] colp=new boolean[board.length][10];
        boolean[][][] p=new boolean[board.length/3][board.length/3][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col]!='.'){
                    int num = board[row][col] - '0';
                    rowp[row][num]=true;
                    colp[col][num]=true;
                    p[row/3][col/3][num]=true;
                }
            }
        }
        doWrite(0,0,rowp,colp,p,board);
    }

    private boolean doWrite(int col, int row, boolean[][] rowp, boolean[][] colp, boolean[][][] p, char[][] board) {
        if(col==board.length){
            col=0;
            row++;
            if(row==board.length){
                return true;
            }
        }
        if(board[row][col]=='.'){
            for (int i = 1; i <= 9; i++) {
                boolean b = rowp[row][i] || colp[col][i] || p[row / 3][col / 3][i];
                if(!b){
                    board[row][col]=Character.forDigit(i,10);
                    rowp[row][i]=true;
                    colp[col][i]=true;
                    p[row/3][col/3][i]=true;
                    if(doWrite(col+1,row,rowp,colp,p,board)){
                        return true;
                    }
                    board[row][col]='.';
                    rowp[row][i]=false;
                    colp[col][i]=false;
                    p[row/3][col/3][i]=false;
                }
            }
        }else{
            if(doWrite(col+1,row,rowp,colp,p,board)){
                return true;
            }
        }
        return false;
    }
}
