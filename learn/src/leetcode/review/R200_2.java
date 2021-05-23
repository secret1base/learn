package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R200_2 {
    //输入：grid = [
    //  ["1","1","0","0","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","1","0","0"],
    //  ["0","0","0","1","1"]
    //]
    //输出：3
    int count=0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        boolean[][] used=new boolean[grid.length][grid[0].length];
        doCount(0,0,grid,used);
        return count;
    }

    private void doCount(int col, int row, char[][] grid, boolean[][] used) {
        if(col==grid[row].length){
            col=0;
            row++;
            if(row==grid.length){
                return;
            }
        }
        if(grid[row][col]=='1'&&!used[row][col]){
            updateUsed(row,col,used,grid);
            count++;
        }
        doCount(col+1,row,grid,used);
    }

    /**
     * 更新当前节点为被使用过，并且向四个方向扩展
     * @param row
     * @param col
     * @param used
     * @param grid
     */
    private void updateUsed(int row, int col, boolean[][] used, char[][] grid) {
        used[row][col] = true;
        //上下左右
        if(row-1>=0&&grid[row-1][col]=='1'&&!used[row - 1][col]){
            //1、没有超出边界 2、有土地 3、没有被标记过
            updateUsed(row-1,col,used,grid);
        }
        if(row+1<grid.length&&grid[row+1][col]=='1'&&!used[row+1][col]){
            //1、没有超出边界 2、有土地 3、没有被标记过
            updateUsed(row+1,col,used,grid);
        }
        if(col+1<grid[row].length&&grid[row][col+1]=='1'&&!used[row][col+1]){
            //1、没有超出边界 2、有土地 3、没有被标记过
            updateUsed(row,col+1,used,grid);
        }
        if(col-1>=0&&grid[row][col-1]=='1'&&!used[row][col-1]){
            //1、没有超出边界 2、有土地 3、没有被标记过
            updateUsed(row,col-1,used,grid);
        }
    }

}
