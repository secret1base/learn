package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 36. 有效的数独
 * @author: wyj
 * @date: 2021/04/28
 */
public class A36_EffectiveSudoku {
    /**
     * 36. 有效的数独
     * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 36.png
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * 注意：
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 示例 1：
     * 输入：board =
     * [["5","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * 输出：true
     * 示例 2：
     * 输入：board =
     * [["8","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * 输出：false
     * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     * 提示：
     * board.length == 9
     * board[i].length == 9
     * board[i][j] 是一位数字或者 '.'
     */
    public static void main(String[] args) {
//        char[][] chars = new char[9][9];
//        char[] a1=new char[]{'5','3','.','.','7','.','.','.','.'};
//        char[] a2=new char[]{'6','.','.','1','9','5','.','.','.'};
//        char[] a3=new char[]{'.','9','8','.','.','.','.','6','.'};
//        char[] a4=new char[]{'8','.','.','.','6','.','.','.','3'};
//        char[] a5=new char[]{'4','.','.','8','.','3','.','.','1'};
//        char[] a6=new char[]{'7','.','.','.','2','.','.','.','6'};
//        char[] a7=new char[]{'.','6','.','.','.','.','2','8','.'};
//        char[] a8=new char[]{'.','.','.','4','1','9','.','.','5'};
//        char[] a9=new char[]{'.','.','.','.','8','.','.','7','9'};
//        chars[0]=a1;
//        chars[1]=a2;
//        chars[2]=a3;
//        chars[3]=a4;
//        chars[4]=a5;
//        chars[5]=a6;
//        chars[6]=a7;
//        chars[7]=a8;
//        chars[8]=a9;
//        boolean validSudoku = new A36_EffectiveSudoku().isValidSudoku(chars);
//        System.out.println(validSudoku);
        char[][] chars = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = new A36_EffectiveSudoku().isValidSudoku(chars);
        System.out.println(validSudoku);
    }

    /**
     * 根据题目要求进行校验即可
     * 执行耗时:3 ms,击败了50.36% 的Java用户
     * 内存消耗:38.4 MB,击败了80.16% 的Java用户
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        //根据要求进行校验
        /**
         * 数字 1-9 在每一行只能出现一次。
         * 数字 1-9 在每一列只能出现一次。
         * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
         */
        //校验列使用colMap
        Map<Integer,Map<Character,Integer>> colMap=new HashMap<>();
        for (int i=0;i<board.length; i++){
            char[] chars = board[i];
            //校验行使用的rowMap
            Map<Character,Integer> rowMap=new HashMap<>();
            for (int j=0;j<chars.length; j++) {
                char c = chars[j];
                if(c!='.'){
                    //行校验
                    Integer count = rowMap.getOrDefault(c, 0);
                    if(count==1){
                        return false;
                    }else{
                        rowMap.put(c,1);
                    }
                    //列校验
                    Map<Character, Integer> coltmp = colMap.get(j);
                    if(coltmp==null){
                        coltmp=new HashMap<Character, Integer>();
                        colMap.put(j,coltmp);
                    }
                    Integer colCount = coltmp.getOrDefault(c, 0);
                    if(colCount == 1){
                        return false;
                    }else{
                        coltmp.put(c,1);
                    }
                }
            }
        }
        //3x3校验
        /**
         *
         */
        for(int i=0;i<9;i+=3){
            for (int j = 0; j <9;j+=3 ){
                int a=i;
                int b=j;
                //校验3x3方块
                Map<Character,Integer> tmp=new HashMap<>();
                while (a<i+3&&b<j+3){
                    char c = board[a][b];
                    if(c!='.'){
                        Integer count = tmp.getOrDefault(c, 0);
                        if(count==1){
                            return false;
                        }else{
                            tmp.put(c,1);
                        }
                    }
                    /**
                     * a=0b=0
                     * a=1b=0
                     * a=2b=0
                     * a=0b=1
                     * a=1b=1
                     * a=2b=1
                     * a=0b=2
                     * a=1b=2
                     * a=2b=2
                     * 这是一次3x3的获取
                     */
//                    System.out.println("a="+a+"b="+b);
                    //执行规律
                    //a=> 0,1,2 b=0
                    //a=> 0,1,2 b=1
                    //a=> 0,1,2 b=2
                    if(a<i+3&&b<j+3){
                        if(a<i+2){
                            //行递增，列不变
                            a++;
                        }else if(a==i+2&&b!=j+2){
                            //行为最大值且列不为最大值时，行清零，列+1
                            a=i;
                            b++;
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }

                }
            }
        }
        return true;
    }

//    /**
//     * 			执行耗时:2 ms,击败了84.85% 的Java用户
//     * 			内存消耗:38.7 MB,击败了18.07% 的Java用户
//     */
//    public boolean isValidSudoku(char[][] board) {
//        boolean[][] rowp=new boolean[board.length][10];
//        boolean[][] colp=new boolean[board[0].length][10];
//        boolean[][][] p=new boolean[board.length/3][board[0].length/3][10];
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[row].length; col++) {
//                char c = board[row][col];
//                if(c!='.'){
//                    int num = c - '0';
//                    if(rowp[row][num]||colp[col][num]||p[row/3][col/3][num]){
//                        //此数字已经存在
//                        return false;
//                    }else{
//                        rowp[row][num]=true;
//                        colp[col][num]=true;
//                        p[row/3][col/3][num]=true;
//                    }
//                }
//            }
//        }
//        return true;
//    }

}
