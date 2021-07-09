package leetcode;

/**
 * 329. 矩阵中的最长递增路径
 * @author: wyj
 * @date: 2021/07/09
 */
public class Fail329_LongestIncreasingPathInMatrix {
    /**
     * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
     *  对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
     *  示例 1：
     * 输入：matrix =
     * [
     * [9,9,4],
     * [6,6,8],
     * [2,1,1]]
     * 输出：4
     * 解释：最长递增路径为 [1, 2, 6, 9]。
     *  示例 2：
     * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
     * 输出：4
     * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
     *  示例 3：
     * 输入：matrix = [[1]]
     * 输出：1
     */
    /**
     * 回溯算法超时 TODO 记忆化深度优先搜索
     */
    int max=1;
    public int longestIncreasingPath(int[][] matrix) {
        //回溯算法
        //像上下左右移动找到能够递增的值
        //used为记录走过的路
        boolean[][] used=new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                //起点
                walk(row,col,used,matrix,1);
            }
        }
        return max;
    }

    private void walk(int row, int col, boolean[][] used, int[][] matrix,int count) {
        max=Math.max(max,count);
        used[row][col]=true;
        /**
         * 上下左右移动 y-1,y+1,x-1,x+1
         */
        //未到达边界，未走过，且比当前值大(递增)
        if(row-1>=0&&!used[row-1][col]&&matrix[row-1][col]>matrix[row][col]){
            walk(row-1, col, used, matrix, count+1);
        }
        if(col-1>=0&&!used[row][col-1]&&matrix[row][col-1]>matrix[row][col]){
            walk(row, col-1, used, matrix, count+1);
        }
        if(row+1<matrix.length&&!used[row+1][col]&&matrix[row+1][col]>matrix[row][col]){
            walk(row+1, col, used, matrix, count+1);
        }
        if(col+1<matrix[row].length&&!used[row][col+1]&&matrix[row][col+1]>matrix[row][col]){
            walk(row, col+1, used, matrix, count+1);
        }
        //撤销走过的路
        used[row][col]=false;
    }

    public static void main(String[] args) {
        int i = new Fail329_LongestIncreasingPathInMatrix().longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}});
        System.out.println(i);
    }
}
