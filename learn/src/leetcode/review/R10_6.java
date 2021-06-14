package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R10_6 {
    //		执行耗时:5 ms,击败了62.68% 的Java用户
    //		内存消耗:38.5 MB,击败了29.73% 的Java用户
    public boolean isMatch(String s, String p) {
        int x=s.length()+1;
        int y=p.length()+1;
        boolean[][] arr=new boolean[y][x];
        for(int row=0;row<y;row++){
            for (int col = 0; col < x; col++) {
                if(row==0&&col==0){
                    arr[row][col]=true;
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
        for(int row=1;row<y;row++) {
            for (int col = 1; col < x; col++) {
                char c = p.charAt(row - 1);
                if(c=='*'){
                    if(row>1){
                        arr[row][col]=arr[row-1][col]||arr[row-2][col];
                    }else{
                        arr[row][col]=arr[row-1][col];
                    }
                    if(!arr[row][col]){
                        if(arr[row][col-1]&&(p.charAt(row-2)==s.charAt(col-1)||p.charAt(row-2)=='.')){
                            arr[row][col]=true;
                        }
                    }
                }else if(c=='.'){
                    arr[row][col]=arr[row-1][col-1];
                }else{
                    if(p.charAt(row-1)==s.charAt(col-1)){
                        arr[row][col]=arr[row-1][col-1];
                    }
                }
            }
        }
        return arr[y-1][x-1];
    }

    public static void main(String[] args) {
        boolean match = new R10_6().isMatch("ab", ".*c");
        System.out.println(match);
    }
}
