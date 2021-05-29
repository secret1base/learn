package leetcode;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * @author: wyj
 * @date: 2021/05/28
 */
public class A48_RotateTheImage {
    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *  你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     *  示例 1：
     * 输入：matrix = [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]]
     * 输出：[
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]]
     *  示例 2：
     * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     *  示例 3：
     * 输入：matrix = [[1]]
     * 输出：[[1]]
     *  示例 4：
     * 输入：matrix = [[1,2],[3,4]]
     * 输出：[[3,1],[4,2]]
     * @param matrix
     */
    /**
     * 解题思路:48.xls
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * 水平反转
     * 7 8 9
     * 4 5 6
     * 1 2 3 1=>0,3=>3,0
     * 对角线反转
     * 7 4 1
     * 8 5 2
     * 9 6 3
     * @param matrix
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.6 MB,击败了40.37% 的Java用户
     */
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //水平反转，反转过的不再进行反转因此row的最大值/2
        for(int col=0;col<n;col++){
            for (int row=0;row<n/2;row++){
                int t= matrix[row][col];
                matrix[row][col]=matrix[n-row-1][col];
                matrix[n-row-1][col]=t;
            }
        }
//        for (int[] anInt : matrix) {
//            System.out.println(Arrays.toString(anInt));
//        }
        /**
         * 对角线反转
         * *
         *   *
         *     *
         */
        //反转过的不再进行反转row<col
        for(int col=0;col<n;col++){
            for (int row=0;row<col;row++){
                int t= matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new A48_RotateTheImage().rotate(ints);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
