package leetcode.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/07/23
 */
public class R51_6 {
    /**
     * 			执行耗时:15 ms,击败了6.12% 的Java用户
     * 			内存消耗:39.3 MB,击败了11.73% 的Java用户
     */
    public List<List<String>> solveNQueens(int n) {
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
        return list;
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

    public static void main(String[] args) {
        List<List<String>> list = new R51_6().solveNQueens(4);
        for (List<String> strings : list) {
            System.out.println(strings);
        }
    }
}
