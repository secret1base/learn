package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/28
 */
public class R1143_2 {
//输入：text1 = "abc", text2 = "def"
//输出：0
    public int longestCommonSubsequence(String text1, String text2) {
        int x=text1.length()+1;
        int y=text2.length()+1;
        int[][] arr=new int[y][x];
        for(int col=1;col<x;col++){
            for (int row=1;row<y;row++){
                if(text1.charAt(col-1)==text2.charAt(row-1)){
                    arr[row][col]=arr[row-1][col - 1]+1;
                }else{
                    arr[row][col]=Math.max(arr[row-1][col],arr[row][col-1]);
                }
            }
        }
        return arr[y-1][x-1];
    }
}
