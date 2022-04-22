package leetcode;

/**
 * 994. 腐烂的橘子
 * @author: wyj
 * @date: 2021/07/27
 */
public class A994_RottenOranges {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     *  值 0 代表空单元格；
     *  值 1 代表新鲜橘子；
     *  值 2 代表腐烂的橘子。
     *  每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *  返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *  示例 1：
     *  输入：[
     *  [2,1,1],
     *  [1,1,0],
     *  [0,1,1]]
     * 输出：4
     *  示例 2：
     *  输入：[[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     *  示例 3：
     *  输入：[[0,2]]
     * 输出：0
     * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
     *  提示：
     *  1 <= grid.length <= 10
     *  1 <= grid[0].length <= 10
     *  grid[i][j] 仅为 0、1 或 2
     *
     *  一次过，思路很流畅，只是实现步骤多了点
     *  		执行耗时:2 ms,击败了85.01% 的Java用户
     * 			内存消耗:37.4 MB,击败了95.55% 的Java用户
     */
    int minute=0;
    public int orangesRotting(int[][] grid) {
        //1、找到所有腐烂的橘子进行记录
        //2、根据记录的橘子向四周扩散
        int[][] recordRotting=new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            recordRotting[i]=grid[i].clone();
        }
        if(rotting(grid, recordRotting)){
            //腐烂成功继续腐烂
            return orangesRotting(grid);
        }
        //腐烂失败，检查是否存在新鲜橘子
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] ==1){
                    return -1;
                }
            }
        }
        return minute;
    }

    private boolean rotting(int[][] grid, int[][] recordRotting) {
        //四个方向
        /**
         *       x,y-1
         * x-1,y x,y   x+1,y
         *       x,y+1
         */
        int[] colp=new int[]{0,-1,1,0};
        int[] rowp=new int[]{-1,0,0,1};
        //开始腐烂
        //腐烂成功标识
        boolean rottingSucced=false;
        for (int row = 0; row < recordRotting.length; row++) {
            for (int col = 0; col < recordRotting[row].length; col++) {
                if(recordRotting[row][col]==2){
                    for (int i=0;i<4;i++){
                        int x = colp[i] + col;
                        int y = rowp[i] + row;
                        if(y>=0&&y<grid.length&&x>=0&&x<grid[y].length){
                            if(grid[y][x]==1){
                                grid[y][x]=2;
                                rottingSucced=true;
                            }
                        }
                    }
                }
            }
        }
        if(rottingSucced){
            minute++;
        }
        return rottingSucced;
    }

    public static void main(String[] args) {
        int i = new A994_RottenOranges().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println(i);
    }
}
