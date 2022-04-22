package leetcode;

/**
 * @author: wyj
 * @date: 2021/08/19
 */
public class A1314_MatrixAreasSum {
    /**
     * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
     *  i - k <= r <= i + k,
     *  j - k <= c <= j + k 且
     *  (r, c) 在矩阵内。
     *  示例 1：
     * 输入：mat = [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ], k = 1
     * 输出：[
     * [12,21,16],
     * [27,45,33],
     * [24,39,28]]
     *  示例 2：
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
     * 输出：[[45,45,45],[45,45,45],[45,45,45]]
     *  提示：
     *  m == mat.length
     *  n == mat[i].length
     *  1 <= m, n, k <= 100
     *  1 <= mat[i][j] <= 100
     *  Related Topics 数组 矩阵 前缀和
     *
     *  		执行耗时:117 ms,击败了16.82% 的Java用户
     * 			内存消耗:39.6 MB,击败了35.78% 的Java用户
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] arr=new int[mat.length][mat[0].length];
        //区域的和
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                //计算边界
                int rowBegin = row - k < 0 ? 0 : row - k;
                int rowEnd = row + k > mat.length-1 ? mat.length-1 : row + k;
                int colBegin=col-k<0?0:col-k;
                int colEnd=col+k>mat[row].length-1?mat[row].length-1:col+k;
                int sum=0;
                for (int r=rowBegin;r<=rowEnd;r++){
                    for(int c=colBegin;c<=colEnd;c++){
                        sum+=mat[r][c];
                    }
                }
                arr[row][col]=sum;
            }
        }
        return arr;
    }
}
