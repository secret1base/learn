package leetcode.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/20
 */
public class R51_3 {
    public static void main(String[] args) {
        List<List<String>> lists = new R51_3().solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        boolean[][] attack=new boolean[n][n];
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

    private void doWrite(int level,int n, List<StringBuilder> queen, boolean[][] attack, List<List<String>> list) {
        if(level==n){
            List<String> tmp=new ArrayList<>();
            for (StringBuilder s : queen) {
                tmp.add(s.toString());
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
                updateAttack(level,i,attack);
                doWrite(level+1,n,queen,attack,list);
                q.replace(i,i+1,".");
                attack=tmp;
            }
        }
    }

    private void updateAttack(int row, int col, boolean[][] attack) {
        /**
         * 八个方向
         * x-1,y-1  x,y-1  x+1,y-1
         * x-1,y    x,y    x+1,y
         * x-1,y+1  x,y+1  x+1,y+1
         */
        int[] colp=new int[]{-1,0,1,-1,1,-1,0,1};
        int[] rowp=new int[]{-1,-1,-1,0,0,1,1,1};
        for (int i = 0; i < attack.length; i++) {
            for(int k=0;k<8;k++){
                int x=col+i*colp[k];
                int y=row+i*rowp[k];
                if(x>=0&&x<attack.length&&y>=0&&y<attack.length){
                    attack[y][x]=true;
                }
            }
        }
    }
}
