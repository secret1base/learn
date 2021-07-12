package leetcode;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * @author: wyj
 * @date: 2021/07/12
 */
public class A73_MatrixZeroing {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     *  进阶：
     *  一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
     *  一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     *  你能想出一个仅使用常量空间的解决方案吗？
     *  示例 1：
     * 输入：matrix = [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]]
     * 输出：[
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]]
     *  示例 2：
     * 输入：matrix = [
     * [0,1,2,0],
     * [3,4,5,2],
     * [1,3,1,5]]
     * 输出：[
     * [0,0,0,0],
     * [0,4,5,0],
     * [0,3,1,0]]
     *
     * 使用了额外空间，没有在原地进行处理
     * 执行耗时:1 ms,击败了99.84% 的Java用户
     * 内存消耗:39.9 MB,击败了63.67% 的Java用户
     *
     */
    public void setZeroes(int[][] matrix) {
        //和八皇后差不多，但是比八皇后简单，需要注意的是原来不为0的被更新过的不允许再进行更新
        boolean[][] used=new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]==0&&!used[row][col]){
                    update(row,col,matrix,used);
                }
            }
        }
    }

    private void update(int row, int col, int[][] matrix, boolean[][] used) {
        /**
         * 当前点的上下左右更新为0
         */
        for(int i=0;i<matrix.length;i++){
            //更新上下方向的值为0
            if(matrix[i][col]!=0){
                //原来不为0的，被更新过后，不再更新
                used[i][col]=true;
            }
            matrix[i][col]=0;

        }
        for(int i=0;i<matrix[row].length;i++){
            //更新左右方向的值为0
            if(matrix[row][i]!=0){
                //原来不为0的，被更新过后，不再更新
                used[row][i]=true;
            }
            matrix[row][i]=0;

        }
    }

    public static void main(String[] args) {
//        int[][] ints = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        new A73_MatrixZeroing().setZeroes(ints);
//        for (int[] anInt : ints) {
//            System.out.println(Arrays.toString(anInt));
//        }
//        int[][] ints = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//        new A73_MatrixZeroing().setZeroes(ints);
//        for (int[] anInt : ints) {
//            System.out.println(Arrays.toString(anInt));
//        }
        int[][] ints = {{0,1}};
        new A73_MatrixZeroing().setZeroes(ints);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }


    }
}
