package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R37_5 {
    public void solveSudoku(char[][] board) {
        if(board.length == 0){
            return;
        }
        boolean[][] rowp=new boolean[board.length][10];
        boolean[][] colp=new boolean[board[0].length][10];
        boolean[][][] p=new boolean[board.length/3][board[0].length/3][10];
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
                //检测是否可以填值
                boolean exist = rowp[row][i] || colp[col][i] || p[row / 3][col / 3][i];
                if(!exist){
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
        }else {
            if(doWrite(col+1,row,rowp,colp,p,board)){
                return true;
            }
        }
        return false;

    }
}
