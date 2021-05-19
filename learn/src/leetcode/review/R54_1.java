package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R54_1 {
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
    public static void main(String[] args) {
        List<Integer> list = new R54_1().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(list);
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.5 MB,击败了74.91% 的Java用户
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        boolean[][] attack=new boolean[matrix.length][matrix[0].length];
        int x=1;//水平方向 1向右 -1向左
        int y=0;//垂直方向 1向下 -1向上
        int col=0;
        int row=0;
        int count=matrix.length*matrix[0].length;
        for (int i=0;i<count;i++){
            list.add(matrix[row][col]);
            attack[row][col]=true;
            if(row+y==matrix.length||row+y<0||col+x<0||col+x==matrix[row].length||attack[row+y][col+x]){
                //到达边界
                if(x==1){
                    //右->下
                    x=0;
                    y=1;
                }else if(y==1){
                    //下->左
                    x=-1;
                    y=0;
                }else if(x==-1){
                    //左->上
                    x=0;
                    y=-1;
                }else if(y==-1){
                    //上->右
                    x=1;
                    y=0;
                }
            }
            row+=y;
            col+=x;
        }
        return list;
    }

}
