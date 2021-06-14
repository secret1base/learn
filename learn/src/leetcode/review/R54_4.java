package leetcode.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R54_4 {
//输入：matrix = [
// [1,2,3],
// [4,5,6],
// [7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//			执行耗时:0 ms,击败了100.00% 的Java用户
//			内存消耗:36.4 MB,击败了83.18% 的Java用户
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        boolean[][] used=new boolean[matrix.length][matrix[0].length];
        //右下左上右
        int total=matrix.length*matrix[0].length;
        int x=1;
        int y=0;
        int row=0;
        int col=0;
        for (int i = 0; i < total; i++) {
            if(!used[row][col]){
                used[row][col]=true;
                list.add(matrix[row][col]);
                int b=row+y;
                int a=col+x;
                if(b<0||b==matrix.length||a<0||a==matrix[b].length||used[b][a]){
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
                row+=y;
                col+=x;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new R54_4().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(list);
    }
}
