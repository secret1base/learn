package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R10_4 {
    public boolean isMatch(String s, String p) {
        int x=s.length()+1;
        int y=p.length()+1;
        boolean[][] arr=new boolean[y][x];
        for (int col = 0; col < x; col++) {
            for(int row=0;row<y;row++){
                if(row==0&&col==0){
                    arr[row][col]=true;
                }else if(col==0){
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
        for (int col = 1; col < x; col++) {
            for (int row = 1; row < y; row++) {
                char c = p.charAt(row - 1);
                if(c=='*'){
                    if(row>1){
                        arr[row][col]=arr[row-1][col]||arr[row-2][col];
                    }else{
                        arr[row][col]=arr[row-1][col];
                    }
                    if(!arr[row][col]){
                        if(row>1&&arr[row][col-1]&&(p.charAt(row - 2) ==s.charAt(col - 1)||p.charAt(row-2)=='.')){
                            arr[row][col]=true;
                        }
                    }
                }else if(c=='.'){
                    arr[row][col]=arr[row-1][col - 1];
                }else{
                    if(p.charAt(row-1)==s.charAt(col-1)&&arr[row-1][col-1]){
                        arr[row][col]=true;
                    }
                }
            }
        }
        return arr[y-1][x-1];
    }
}
