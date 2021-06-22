package leetcode;

import java.util.Arrays;

/**
 * 221. 最大正方形
 * @author: wyj
 * @date: 2021/06/18
 */
public class A221_LargestSquare {
    /**
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     *  示例 1：
     * 输入：matrix = [
     * ["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]]
     * 输出：4
     *  示例 2：
     * 输入：matrix = [
     * ["0","1"],
     * ["1","0"]]
     * 输出：1
     *  示例 3：
     * 输入：matrix = [["0"]]
     * 输出：0
     * 			执行耗时:13 ms,击败了7.92% 的Java用户
     * 			内存消耗:40.4 MB,击败了99.70% 的Java用户
     */
    public int maximalSquare(char[][] matrix) {
        /**
         * 动态规划
         * 0 1 1 1 0
         * 1 1 1 1 0
         * 0 1 1 1 1
         * 0 1 1 1 1
         * 0 0 1 1 1
         *
         *
         * 0 1 1 1 0
         * 1 1 2 2 0
         * 0 1 2 3 1
         * 0 1 2 3 2
         * 0 0 1 2 3
         */
        if(matrix.length==0){
            return 0;
        }
        int[][] arr=new int[matrix.length][matrix[0].length];
        //初始化
        int max=0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char c = matrix[row][col];
                if(c=='1'){
                    if(col==0||row==0){
                        arr[row][col]=1;
                        max=1;
                    }
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                char c = matrix[row][col];
                if(c=='1'){
                    arr[row][col]=Math.min(Math.min(arr[row-1][col],arr[row][col-1]),arr[row-1][col - 1])+1;
                    max=Math.max(arr[row][col],max);
                }
            }
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        return max*max;
    }

    public static void main(String[] args) {
//        int i = new A221_LargestSquare().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        int i = new A221_LargestSquare().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        System.out.println(i);
    }
}
