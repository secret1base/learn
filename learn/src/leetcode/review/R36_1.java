package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/07/22
 */
public class R36_1 {
    // 数字 1-9 在每一行只能出现一次。
    // 数字 1-9 在每一列只能出现一次。
    // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

    /**
     * 			执行耗时:2 ms,击败了84.85% 的Java用户
     * 			内存消耗:38.7 MB,击败了18.07% 的Java用户
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowp=new boolean[board.length][10];
        boolean[][] colp=new boolean[board[0].length][10];
        boolean[][][] p=new boolean[board.length/3][board[0].length/3][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char c = board[row][col];
                if(c!='.'){
                    int num = c - '0';
                    if(rowp[row][num]||colp[col][num]||p[row/3][col/3][num]){
                        //此数字已经存在
                        return false;
                    }else{
                        rowp[row][num]=true;
                        colp[col][num]=true;
                        p[row/3][col/3][num]=true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean validSudoku = new R36_1().isValidSudoku(new char[][]{{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}});
        System.out.println(validSudoku);
    }
}
