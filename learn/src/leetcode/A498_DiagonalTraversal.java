package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 498. 对角线遍历
 * @author: wyj
 * @date: 2021/06/02
 */
public class A498_DiagonalTraversal {
    /**
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，
     * 对角线遍历如下图所示。
     *  示例:
     *  输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出:  [1,2,4,7,5,3,6,8,9]
     * @param mat
     * @return
     */
    /**
     * 解题思路：498.png
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] arr=new int[m*n];
        int row=0;
        int col=0;
        int f=1;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=mat[row][col];
            //到达右边界的优先级比到达顶点的优先级高
            //右边界
            if(col==n-1&&f==1){
                row++;
                f=-1;
                continue;
            }
            //顶点
            if(row==0&&f==1){
                col++;
                f=-1;
                continue;
            }
            //到达左边界的优先级比到达底部高
            //左边界
            if(col==0&&f==-1){
                row++;
                f=1;
                continue;
            }
            //底部
            if(row==m-1&&f==-1){
                col++;
                f=1;
                continue;
            }
            if(f==1){
                row--;
                col++;
            }else{
                row++;
                col--;
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] diagonalOrder = new A498_DiagonalTraversal().findDiagonalOrder(new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
