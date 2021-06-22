package leetcode;

/**
 * 79. 单词搜索
 * @author: wyj
 * @date: 2021/06/23
 */
public class A79_WordSearch {
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *  单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *  示例 1：
     * 输入：board = [
     * ["A","B","C","E"],
     * ["S","F","C","S"],
     * ["A","D","E","E"]
     * ],
     * word = "ABCCED"
     * 输出：true
     *  示例 2：
     * 输入：board = [
     * ["A","B","C","E"],
     * ["S","F","C","S"],
     * ["A","D","E","E"]],
     * word = "SEE"
     * 输出：true
     *  示例 3：
     * 输入：board = [
     * ["A","B","C","E"],
     * ["S","F","C","S"],
     * ["A","D","E","E"]],
     * word = "ABCB"
     * 输出：false
     *
     * better and better
     * 		执行耗时:114 ms,击败了34.84% 的Java用户
     * 		内存消耗:38.9 MB,击败了22.78% 的Java用户
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] used=new boolean[board.length][board[0].length];
        char c = word.charAt(0);
        for (int row = 0; row < board.length;row++){
            for (int col = 0; col < board[row].length;col++){
                if(board[row][col]==c){
                    //进入
                    used[row][col]=true;
                    if(record(1,word,board,used,row,col)){
                        return true;
                    }
                    used[row][col]=false;
                }
            }
        }
        return false;
        //找到word的起始字母，然后进行上下左右的移动，移动时注意不能走used为true的地方，因为不能走回头路
    }

    private boolean record(int i, String word, char[][] board, boolean[][] used, int row, int col) {
        if(i==word.length()){
            return true;
        }
        //向上下左右走，找到满足的条件
        int[] x=new int[]{0,0,-1,1};
        int[] y=new int[]{-1,1,0,0};
        char c = word.charAt(i);
        for (int j = 0; j < 4;j++){
            int b=row+y[j];
            int a=col+x[j];
            if(b>=0&&b<board.length&&a>=0&&a<board[b].length){
                if(!used[b][a]&&board[b][a]==c){
                    used[b][a]=true;
                    if(record(i+1,word,board,used,b,a)){
                        return true;
                    }
                    used[b][a]=false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean see = new A79_WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEEA");
        System.out.println(see);
    }
}
