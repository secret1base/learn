package leetcode;

/**
 * 63. 不同路径 II
 * @author: wyj
 * @date: 2021/07/09
 */
public class Fail63_DifferentRoutesII {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *  现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *  网格中的障碍物和空位置分别用 1 和 0 来表示。
     *  示例 1：
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *  示例 2：
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     */
    /**
     * 回溯算法又超时了....
     */
    int count=0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //每次只能向右、向下走，并且存在障碍物，但是对于我来说每次走到低都是一条路径
        if(obstacleGrid[0][0]==1){
            //起始位置就有障碍物，无路可走
            return count;
        }
        walk(0,0,obstacleGrid);
        return count;
    }

    private void walk(int row, int col, int[][] obstacleGrid) {
        if(row==obstacleGrid.length||row<0||col<0||obstacleGrid[row].length==col){
            //边界不能走
            return;
        }
        if(obstacleGrid[row][col]==1){
            //有石头不能走
            return;
        }
        if(row==obstacleGrid.length-1&&col==obstacleGrid[row].length-1){
            //到达终点
            count++;
            return;
        }
        //向右、向下走
        walk(row,col+1,obstacleGrid);
        walk(row+1,col,obstacleGrid);
    }
}
