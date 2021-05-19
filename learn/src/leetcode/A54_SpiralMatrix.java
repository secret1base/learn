package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54.螺旋矩阵
 * @author: wyj
 * @date: 2021/05/17
 */
public class A54_SpiralMatrix {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *  示例 1：
     *  54.jpg
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *  示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * @return
     */
    public static void main(String[] args) {
        List<Integer> list = new A54_SpiralMatrix().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(list);
    }
    /**
     * 在有了处理多次类似n皇后题目的经验后，这道题很简单
     * 1、注意有四个方向,并且根据右->下->左->上->右这样的顺序循环
     * 2、通过attack记录已经被使用的位置
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.8 MB,击败了14.06% 的Java用户
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix.length == 0){
            return result;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[][] attack=new boolean[r][c];
        //方向右->下->左->上 ==> (1,0)(0,1)(-1,0)(0,-1)
        //初始方向右
        int x=1;
        int y=0;
        //能够执行的次数
        int total=r*c;
        int col=0;
        int row=0;
        for (int i = 0; i < total; i++) {
            //记录当前格
            result.add(matrix[row][col]);
            attack[row][col]=true;
            //预测下一格是否到达边界
            int ny = row + y;
            int nx = col + x;
            if(ny<0||ny>=r||nx<0||nx>=c||attack[ny][nx]){
                //到达边界，分别为不存在的位置和已经使用过
                //变更方向
                //右->下->左->上
                if(x==1&&y==0){
                    //下
                    x=0;
                    y=1;
                }else if(x==0&&y==1){
                    //左
                    x=-1;
                    y=0;
                }else if(x==-1&&y==0){
                    //上
                    x=0;
                    y=-1;
                }else if(x==0&&y==-1){
                    x=1;
                    y=0;
                }
            }
            //进行下一格
            row+=y;
            col+=x;
        }
        return result;
    }
}
