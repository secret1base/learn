package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/18
 */
public class R37_4 {
    /**
     * 			执行耗时:3 ms,击败了87.76% 的Java用户
     * 			内存消耗:35.8 MB,击败了67.01% 的Java用户
     * @param board
     */
    public void solveSudoku(char[][] board) {
        boolean[][] rowp=new boolean[board.length][10];
        boolean[][] colp=new boolean[board.length][10];
        boolean[][][] p=new boolean[board.length/3][board.length/3][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char c = board[row][col];
                if(c!='.'){
                    int num = c - '0';
                    rowp[row][num]=true;
                    colp[col][num]=true;
                    p[row/3][col/3][num]=true;
                }
            }
        }
        doWrite(0,0,rowp,colp,p,board);
    }

    private boolean doWrite(int col, int row, boolean[][] rowp, boolean[][] colp, boolean[][][] p, char[][] board) {
        if(col==board[row].length){
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
            if(doWrite(col + 1, row,rowp,colp,p,board)){
                return true;
            }
        }
        return false;
    }
}
