package leetcode;

/**
 * 37.解数独
 * @author: wyj
 * @date: 2021/04/28
 */
public class A37_SolveSudoku {
    /**
     * 37. 解数独
     * 编写一个程序，通过填充空格来解决数独问题。
     * 数独的解法需 遵循如下规则：
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 37(1).png
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * 示例：
     * 输入：board =
     * [
     * ["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出：[
     * ["5","3","4","6","7","8","9","1","2"],
     * ["6","7","2","1","9","5","3","4","8"],
     * ["1","9","8","3","4","2","5","6","7"],
     * ["8","5","9","7","6","1","4","2","3"],
     * ["4","2","6","8","5","3","7","9","1"],
     * ["7","1","3","9","2","4","8","5","6"],
     * ["9","6","1","5","3","7","2","8","4"],
     * ["2","8","7","4","1","9","6","3","5"],
     * ["3","4","5","2","8","6","1","7","9"]]
     * 37(2).png
     * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
     * 提示：
     * board.length == 9
     * board[i].length == 9
     * board[i][j] 是一位数字或者 '.'
     * 题目数据 保证 输入数独仅有一个解
     */

//这是道回溯算法的题目：与八皇后类似，因此需要学习后再进行解答，解答此题后，需要解答八皇后题目，保证能够理解
    //https://mp.weixin.qq.com/s/VCirGskFGPln-S2LGFTgKg
//关联题目 36\980
    /**
     * 			执行耗时:3 ms,击败了87.91% 的Java用户
     * 			内存消耗:35.7 MB,击败了90.85% 的Java用户
     *      * 数字 1-9 在每一行只能出现一次。
     *      * 数字 1-9 在每一列只能出现一次。
     *      * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * @param board
     */
    public void solveSudoku(char[][] board) {
        //通过三个bool数组记录已经被使用的数字
        boolean[][] rowP=new boolean[board.length][10];
        boolean[][] colP=new boolean[board.length][10];
        boolean[][][] p=new boolean[board.length/3][board.length/3][10];
        for (int row=0;row<board.length;row++){
            for (int col = 0; col < board[row].length; col++){
                char c = board[row][col];
                if(c!='.'){
                    int num = Character.digit(c, 10);
                    rowP[row][num]=true;
                    colP[col][num] = true;
                    p[row/3][col/3][num]=true;
                }
            }
        }
        doWrite(0,0,board,rowP,colP,p);
    }

    /**
     *
     * @param row 行数
     * @param col 列数
     * @param board
     * @param rowP 记录行中数字是否使用
     * @param colP 记录列中数字是否使用
     * @param p 记录3x3块中数字是否使用
     * @return
     */
    private boolean doWrite(int row, int col, char[][] board, boolean[][] rowP, boolean[][] colP, boolean[][][] p) {
        if(col==board[row].length){
            //到达边界
            col=0;
            row++;
            if(row==board.length){
                return true;
            }
        }
        if(board[row][col] == '.'){
            for(int i=1;i<=9;i++){
                //校验是否可以填写,一旦有一个值为true，就不能填写
                boolean b = rowP[row][i] || colP[col][i] || p[row / 3][col / 3][i];
                if(!b){
                    //填值
                    char c = Character.forDigit(i, 10);
                    board[row][col]=c;
                    rowP[row][i]=true;
                    colP[col][i]=true;
                    p[row / 3][col / 3][i]=true;
                    //进入下一格
                    if(doWrite(row, col + 1, board, rowP, colP, p)){
                        return true;
                    }
                    //进入这里说明不成功，取消本次填值
                    board[row][col]='.';
                    rowP[row][i]=false;
                    colP[col][i]=false;
                    p[row / 3][col / 3][i]=false;
                }
            }
        }else{
            if(doWrite(row,col+1,board, rowP, colP, p)){
                return true;
            }
        }
        return false;
    }
}
