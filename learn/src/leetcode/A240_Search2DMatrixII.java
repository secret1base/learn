package leetcode;

/**
 * 240.搜索二维矩阵 II
 * @author: wyj
 * @date: 2021/06/02
 */
public class A240_Search2DMatrixII {
    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *  每行的元素从左到右升序排列。
     *  每列的元素从上到下升序排列。
     *  示例 1：
     * 输入：matrix = [
     * [1,4,7,11,15],
     * [2,5,8,12,19],
     * [3,6,9,16,22],
     * [10,13,14,17,24],
     * [18,21,23,26,30]
     * ], target = 5
     * 输出：true
     *  示例 2：
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
     * ,23,26,30]], target = 20
     * 输出：false
     *  提示：
     *  m == matrix.length
     *  n == matrix[i].length
     *  1 <= n, m <= 300
     *  -109 <= matix[i][j] <= 109
     *  每行的所有元素从左到右升序排列
     *  每列的所有元素从上到下升序排列
     *  -109 <= target <= 109
     */
    /**
     *
     * 			执行耗时:10 ms,击败了20.24% 的Java用户
     * 			内存消耗:44.2 MB,击败了31.09% 的Java用户
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //先分别向右找到比target大的值确定边界，然后col-1开始向下找，没找到col继续-1,然后向下
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] ==target){
                    return true;
                }else if(matrix[row][col] >target||col==matrix[row].length-1){
                    int x=col==matrix[row].length-1?col:col-1;
                    int y=row+1;
                    while (x>=0){
                        while (x>=0&&y<matrix.length&&matrix[y][x]<=target){
                            if(matrix[y][x]==target){
                                return true;
                            }else{
                                y++;
                            }
                        }
                        x--;
                        y=row+1;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new A240_Search2DMatrixII().searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 12);
        System.out.println(b);
    }
}
