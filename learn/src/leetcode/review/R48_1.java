package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R48_1 {
//输入：matrix = [
// [5,1,9,11],
// [2,4,8,10],
// [13,3,6,7],
// [15,14,12,16]
// ]
//输出：[
// [15,13,2,5],
// [14,3,4,1],
// [12,6,8,9],
// [16,7,10,11]
// ]

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.5 MB,击败了56.17% 的Java用户
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        /**
         * 水平反转
         * --------------
         *
         * 对角线反转
         * \
         *  \
         *   \
         */
        int length = matrix.length;
        for (int row = 0; row < length/2; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int tmp = matrix[row][col];
                matrix[row][col]=matrix[length-row-1][col];
                matrix[length-row-1][col]=tmp;
            }
        }
        for (int row = 0; row < length; row++) {
            for (int col = row; col < matrix[row].length; col++) {
                int tmp = matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=tmp;
            }
        }
    }
}
