package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 52. N皇后 II
 * @author: wyj
 * @date: 2021/07/23
 */
public class A52_NQueenII {
    /**
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *  给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
     *  示例 1：
     * 输入：n = 4
     * 输出：2
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     *  示例 2：
     * 输入：n = 1
     * 输出：1
     *  提示：
     *  1 <= n <= 9
     *  皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
     * 和51是同一道题目
     *  		执行耗时:15 ms,击败了6.12% 的Java用户
     * 			内存消耗:39.3 MB,击败了10.90% 的Java用户
     *
     */
    public int totalNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        List<StringBuilder> queens=new ArrayList<>();
        boolean[][] attack=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringBuilder tmp=new StringBuilder();
            for (int j = 0; j < n; j++) {
                tmp.append(".");
            }
            queens.add(tmp);
        }
        record(0,queens,attack,list);
        return list.size();
    }

    private void record(int level, List<StringBuilder> queens, boolean[][] attack, List<List<String>> list) {
        if(level==queens.size()){
            List<String> tmp=new ArrayList<>();
            for (StringBuilder queen : queens) {
                tmp.add(queen.toString());
            }
            list.add(tmp);
            return;
        }
        for(int i=0;i<queens.size();i++){
            if(!attack[level][i]){
                //没被攻击
                StringBuilder preQueen = queens.get(level);
                preQueen.replace(i,i+1,"Q");
                boolean[][] preAttack=new boolean[queens.size()][queens.size()];
                for (int a=0;a<preAttack.length;a++){
                    preAttack[a]=attack[a].clone();
                }
                updateAttack(level,i,attack);
                record(level+1,queens,attack,list);
                //恢复
                preQueen.replace(i,i+1,".");
                attack=preAttack;
            }
        }

    }

    private void updateAttack(int row, int col, boolean[][] attack) {
        /**
         * x-1,y-1 x,y-1 x+1,y-1
         * x-1,y   x,y   x+1,y
         * x-1,y+1 x,y+1 x+1,y+1
         * 八个方向进行攻击
         */
        int[] colp=new int[]{-1,0,1,-1,1,-1,0,1};
        int[] rowp=new int[]{-1,-1,-1,0,0,1,1,1};
        for(int i=0;i<attack.length;i++){
            for(int c=0;c<8;c++){
                int y = rowp[c] * i + row;
                int x = colp[c] * i + col;
                if(y>=0&&y<attack.length&&x>=0&&x<attack.length){
                    attack[y][x]=true;
                }
            }
        }
    }
}
