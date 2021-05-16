package leetcode.review;

/**
 * 37题复习 第一次
 * @author: wyj
 * @date: 2021/05/14
 */
public class R37_1 {
    public void solveSudoku(char[][] board) {
        boolean[][] rowp=new boolean[board.length][10];
        boolean[][] colp=new boolean[board.length][10];
        boolean[][][] p=new boolean[board.length/3][board.length / 3][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char c = board[row][col];
                if(c!='.'){
                    int i = c - '0';
                    rowp[row][i]=true;
                    colp[col][i]=true;
                    p[row/3][col/3][i]=true;
                }
            }
        }
        doSolve(0,0,rowp, colp,p,board);
    }

    private boolean doSolve(int row, int col, boolean[][] rowp, boolean[][] colp, boolean[][][] p, char[][] board) {
        if(col==board.length){
            col=0;
            row++;
            if(row==board.length){
                return true;
            }
        }
        if(board[row][col]=='.'){
            for(int i=1;i<10;i++){
                boolean b = rowp[row][i] || colp[col][i] || p[row / 3][col / 3][i];
                if(!b){
                    board[row][col]=Character.forDigit(i,10);
                    rowp[row][i]=true;
                    colp[col][i]=true;
                    p[row/3][col/3][i]=true;
                    if(doSolve(row,col+1,rowp,colp,p,board)){
                        return true;
                    }
                    board[row][col]='.';
                    rowp[row][i]=false;
                    colp[col][i]=false;
                    p[row/3][col/3][i]=false;
                }
            }
        }else{
            if(doSolve(row,col+1,rowp,colp,p,board)){
                return true;
            }
        }
        return false;
    }
}
