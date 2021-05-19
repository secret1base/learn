package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/17
 */
public class R51_1 {
    //n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
// 示例 1：
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 示例 2：
//输入：n = 1
//输出：[["Q"]]
// 提示：
// 1 <= n <= 9
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
    public static void main(String[] args) {
        List<List<String>> lists = new R51_1().solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 			执行耗时:242 ms,击败了5.41% 的Java用户
     * 			内存消耗:39.2 MB,击败了22.44% 的Java用户
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        boolean[][] attack=new boolean[n][n];
        List<StringBuilder> queen=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s=new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            queen.add(s);
        }
        doWrite(0,n,attack,queen,result);
        return result;
    }

    private void doWrite(int level, int n, boolean[][] attack, List<StringBuilder> queen, List<List<String>> result) {
        if(level==attack.length){
            List<String> list=new ArrayList<>();
            for (StringBuilder stringBuilder : queen) {
                list.add(stringBuilder.toString());
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < n;i++){
            if(!attack[level][i]){
                //不在攻击范围，尝试放置
                //备份
                boolean[][] tmp=new boolean[n][n];
                for (int j = 0; j < n; j++) {
                    tmp[j]=attack[j].clone();
                }
                //放置皇后
                StringBuilder tmpq = queen.get(level);
                tmpq.replace(i, i + 1, "Q");
                for (StringBuilder stringBuilder : queen) {
                    System.out.println(stringBuilder);
                }
                System.out.println("queen");
                //更新攻击范围
                updataAttack(level,i,attack);
                //进行下一步放置
                doWrite(level+1,n,attack,queen,result);
                //递归结束后回退
                attack=tmp;
                tmpq.replace(i, i + 1, ".");
            }
        }
    }

    private void updataAttack(int row, int col, boolean[][] attack) {
        /**
         * x-1,y-1 x,y-1 x+1,y-1
         * x-1,y   x,y   x+1,y
         * x-1,y+1 x,y+1 x+1,y+1
         */
        //方向为左上、上、右上、左、右、左下、下、右下
        //(-1,-1)(0,-1)(1,-1)(-1,0)(1,0)(-1,1)(0,1)(1,1)
        int [] cols=new int[]{-1,0,1,-1,1,-1,0,1};
        int [] rows=new int[]{-1,-1,-1,0,0,1,1,1};
        for(int i = 0; i < attack.length; i++){
            for (int j = 0; j < 8; j++) {
                //8个方向
                int c=col+i*cols[j];
                int r=row+i*rows[j];
                //限制在边界内
                if(r>=0&&r<attack.length&&c>=0&&c<attack[r].length){
                    attack[r][c]=true;
                }
            }
        }
//        for (boolean[] booleans : attack) {
//            System.out.println(Arrays.toString(booleans));
//        }
//        System.out.println("----------------");
    }
}
