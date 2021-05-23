package leetcode.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R54_2 {
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//[[1,2,3],
// [4,5,6],
// [7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }
        //起始点(0,0)，到达边界或者是已经使用过的点就变更方向
        boolean[][] used=new boolean[matrix.length][matrix[0].length];
        //右->下->左->上->右 1,0| 0,1| -1,0 | 0,-1|1,0
        int x=1;
        int y=0;
        int row=0;
        int col=0;
        //总次数
        int total=matrix.length*matrix[0].length;
        for (int i = 0; i < total; i++) {
            list.add(matrix[row][col]);
            used[row][col]=true;
            if(row+y<0||row+y==matrix.length||col+x<0||col+x==matrix[row+y].length||used[row+y][col+x]){
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
            //记录当前节点并预测下一个节点
        }
        return list;
    }
}
