package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R51_5 {
    public static void main(String[] args) {
        List<List<String>> list = new R51_5().solveNQueens(4);
        for (List<String> s : list) {
            System.out.println(s);
        }
    }

    /**
     * 			执行耗时:18 ms,击败了5.36% 的Java用户
     * 			内存消耗:39.2 MB,击败了27.00% 的Java用户
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        boolean[][] attack=new boolean[n][n];
        List<List<String>> list=new ArrayList<>();
        List<StringBuilder> queen=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s=new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            queen.add(s);
        }
        doWrite(0,n,queen,attack,list);
        return list;
    }

    private void doWrite(int level, int n, List<StringBuilder> queen, boolean[][] attack, List<List<String>> list) {
        if(level==n){
            List<String> tmp=new ArrayList<>();
            for (StringBuilder a : queen) {
                tmp.add(a.toString());
            }
            list.add(tmp);
            return;
        }
        for (int i = 0; i < n;i++){
            if(!attack[level][i]){
                StringBuilder q = queen.get(level);
                q.replace(i,i+1,"Q");
                boolean[][] tmp=new boolean[n][n];
                for (int k = 0; k < n; k++) {
                    tmp[k]=attack[k].clone();
                }
                attack[level][i]=true;
                updateAttack(level,i,attack);
                doWrite(level+1,n,queen,attack,list);
                q.replace(i,i+1,".");
                attack=tmp;
            }
        }
    }

    private void updateAttack(int row, int col, boolean[][] attack) {
        /**
         * x-1,y-1 x,y-1 x+1,y-1
         * x-1,y   x,y   x+1,y
         * x-1,y+1 x,y+1 x+1,y+1
         */
        int[] cols=new int[]{-1,0,1,-1,1,-1,0,1};
        int[] rows=new int[]{-1,-1,-1,0,0,1,1,1};
        for (int i = 0; i < attack.length; i++) {
            for (int j = 0; j < 8; j++) {
                int x=col+i*cols[j];
                int y=row+i*rows[j];
                if(x<attack.length&&x>=0&&y<attack.length&&y>=0){
                    attack[y][x]=true;
                }
            }
        }
    }
}
