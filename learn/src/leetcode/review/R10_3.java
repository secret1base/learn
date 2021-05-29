package leetcode.review;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R10_3 {
    public boolean isMatch(String s, String p) {
        int x=s.length()+1;
        int y=p.length()+1;
        boolean[][] arr=new boolean[y][x];
        //初始化
        for (int col=0;col<x;col++){
            for (int row=0;row<y;row++){
                if(row==0&&col==0){
                    arr[row][col]=true;
                }else if(col==0){
                    char c = p.charAt(row - 1);
                    if(c=='*'){
                        if(row>1){
                            arr[row][col]=arr[row-1][col]||arr[row-2][col];
                        }else if(row>0){
                            arr[row][col]=arr[row-1][col];
                        }
                    }
                }
            }
        }
        //进行遍历
        for(int col=1;col<x;col++){
            for (int row = 1; row < y; row++) {
                char c = p.charAt(row - 1);
                if(c=='*'){
                    if(row>1){
                        arr[row][col]=arr[row-1][col]||arr[row-2][col];
                    }else{
                        arr[row][col]=arr[row-1][col];
                    }
                    if(!arr[row][col]){
                        if(arr[row][col-1]&&(s.charAt(col-1)==p.charAt(row-2)||p.charAt(row-2)=='.')){
                            arr[row][col] = true;
                        }
                    }
                }else if(c=='.'){
                    arr[row][col]=arr[row - 1][col-1];
                }else{
                    if(c==s.charAt(col-1)&&arr[row-1][col-1]){
                        arr[row][col]=true;
                    }
                }
            }
        }
        for (boolean[] booleans : arr) {
            System.out.println(Arrays.toString(booleans));
        }
        return arr[y-1][x-1];
    }

    public static void main(String[] args) {
        boolean aab = new R10_3().isMatch("aab", "b.*");
    }
}
