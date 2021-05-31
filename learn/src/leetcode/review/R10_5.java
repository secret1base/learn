package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R10_5 {
    /**
     * 			执行耗时:3 ms,击败了90.18% 的Java用户
     * 			内存消耗:38.3 MB,击败了67.70% 的Java用户
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int x=s.length()+1;
        int y=p.length()+1;
        boolean[][] arr=new boolean[y][x];
        for(int col = 0; col < x; col++){
            for (int row=0;row<y;row++){
                if(col==0&&row==0){
                    arr[row][col] = true;
                }else if(col==0){
                    if(row>0){
                        char c = p.charAt(row - 1);
                        if(c=='*'){
                            if(row>1){
                                arr[row][col]=arr[row-1][col]||arr[row-2][col];
                            }else{
                                arr[row][col]=arr[row-1][col];
                            }
                        }
                    }
                }
            }
        }
        for(int col = 1; col < x; col++) {
            for (int row = 1; row < y; row++) {
                char c = p.charAt(row - 1);
                if(c=='*'){
                    if(row>1){
                        arr[row][col]=arr[row-1][col]||arr[row-2][col];
                    }else{
                        arr[row][col]=arr[row-1][col];
                    }
                    if(!arr[row][col]){
                        if(row>1&&arr[row][col-1]&&(p.charAt(row-2)==s.charAt(col-1)||p.charAt(row-2)=='.')){
                            arr[row][col]=true;
                        }
                    }
                }else if(c=='.'){
                    arr[row][col]=arr[row-1][col-1];
                }else if(c==s.charAt(col-1)&&arr[row-1][col-1]){
                    arr[row][col]=true;
                }
            }
        }
        return arr[y-1][x-1];
    }
}
