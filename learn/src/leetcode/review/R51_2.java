package leetcode.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R51_2 {
    //解答成功: 执行耗时:18 ms,击败了5.31% 的Java用户 内存消耗:39.5 MB,击败了5.50% 的Java用户
    public static void main(String[] args) {
        List<List<String>> lists = new R51_2().solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        boolean[][] attack=new boolean[n][n];
        List<StringBuilder> queen=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s=new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            queen.add(s);
        }
        doWrite(0,n,queen,attack,res);
        return res;
    }

    private void doWrite(int level, int n, List<StringBuilder> queen, boolean[][] attack, List<List<String>> res) {
        if(level==n){
            List<String> list=new ArrayList<>();
            for (StringBuilder stringBuilder : queen) {
                list.add(stringBuilder.toString());
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n;i++){
            if(!attack[level][i]){
                //可以放置
                //备份
                boolean[][] tmp=new boolean[n][n];
                for (int j = 0; j < n; j++) {
                    tmp[j] = attack[j].clone();
                }
                StringBuilder q = queen.get(level);
                q.replace(i,i+1,"Q");
                attack[level][i]=true;
                updateAttack(level,i,attack);
                doWrite(level+1,n,queen,attack,res);
                //回退
                q.replace(i, i+1,".");
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
            for (int k=0;k<8;k++){
                int c=col+i*colp[k];
                int r=row+i*rowp[k];
                if(c>=0&&c<attack.length&&r>=0&&r<attack.length){
                    attack[r][c]=true;
                }
            }
        }
    }
}
