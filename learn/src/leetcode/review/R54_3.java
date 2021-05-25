package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R54_3 {
    public static void main(String[] args) {
        List<Integer> list = new R54_3().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.6 MB,击败了44.69% 的Java用户
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        boolean[][] used=new boolean[matrix.length+2][matrix[0].length+2];
        //初始化边界
        for (int row = 0; row < used.length; row++) {
            for (int col = 0; col < used[row].length; col++) {
                if(row==0||row==used.length-1||col==0||col==used[row].length-1){
                    used[row][col]=true;
                }
            }
        }
        int total=matrix.length*matrix[0].length;
        int row=0;
        int col=0;
        //右下左上右1,0 0,1 -1,0 0,-1
        int x=1;
        int y=0;
        for (int i=0;i<total;i++){
            used[row+1][col+1] = true;
            list.add(matrix[row][col]);
            int xx = col + x;
            int yy = row + y;
            if(used[yy+1][xx+1]){
                if(x==1){
                    x=0;
                    y=1;
                }else if(y==1){
                    x=-1;
                    y=0;
                }else if(x==-1){
                    x=0;
                    y=-1;
                }else if(y==-1){
                    x=1;
                    y=0;
                }
            }
            col+=x;
            row+=y;
            for (boolean[] booleans : used) {
                System.out.println(Arrays.toString(booleans));
            }
        }
        return list;
    }
}
