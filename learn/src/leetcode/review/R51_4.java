package leetcode.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R51_4 {
    public static void main(String[] args) {
        List<List<String>> list = new R51_4().solveNQueens(4);
        System.out.println(list);
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
        doWrite(0,n,attack,list,queen);
        return list;
    }

    private void doWrite(int level, int n, boolean[][] attack, List<List<String>> list, List<StringBuilder> queen) {
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
                for (int k = 0; k < n; k++){
                    tmp[k]=attack[k].clone();
                }
                updateAttack(level,i,attack);
                doWrite(level+1,n,attack,list,queen);
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
        int[] colp=new int[]{-1,0,1,-1,1,-1,0,1};
        int[] rowp=new int[]{-1,-1,-1,0,0,1,1,1};
        for (int i = 0; i < attack.length; i++) {
            for(int j = 0; j < 8; j++){
                int r=row+rowp[j]*i;
                int c=col+colp[j]*i;
                if(r>=0&&r<attack.length&&c>=0&&c<attack[r].length){
                    attack[r][c]=true;
                }
            }
        }
    }
}
