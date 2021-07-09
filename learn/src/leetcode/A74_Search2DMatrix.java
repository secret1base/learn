package leetcode;

/**
 * 74. 搜索二维矩阵
 * @author: wyj
 * @date: 2021/06/24
 */
public class A74_Search2DMatrix {
    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *  每行中的整数从左到右按升序排列。
     *  每行的第一个整数大于前一行的最后一个整数。
     *  示例 1：
     * 输入：matrix = [
     * [1,3,5,7],
     * [10,11,16,20],
     * [23,30,34,60]
     * ], target = 3
     * 输出：true
     *  示例 2：
     * 输入：matrix = [
     * [1,3,5,7],
     * [10,11,16,20],
     * [23,30,34,60]],
     * target = 13
     * 输出：false
     *
     * 从左到右找，当比target大时return false
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:37.9 MB,击败了57.52% 的Java用户
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            //进行跳行的优化
            if(matrix[row][matrix[row].length-1]<target){
                //如果当前行的最后一个数比target小就直接去下一行
                continue;
            }
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] ==target){
                    return true;
                }else if(matrix[row][col]>target){
                    return false;
                }
            }
        }
        return false;
    }
}
