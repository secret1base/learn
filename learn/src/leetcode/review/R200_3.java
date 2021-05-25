package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R200_3 {
    int count=0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        boolean[][] used=new boolean[grid.length][grid[0].length];
        doUse(0,0,used,grid);
        return count;
    }

    private void doUse(int col, int row, boolean[][] used, char[][] grid) {
        if(col==grid[row].length){
            col=0;
            row++;
            if(row == grid.length){
                return;
            }
        }
        if(grid[row][col]=='1'&&!used[row][col]){
            count++;
            updateUsed(col,row,used,grid);
        }
        doUse(col+1,row,used,grid);
    }

    private void updateUsed(int col, int row, boolean[][] used, char[][] grid) {
        //上下左右
        if(used[row][col]){
            return;
        }
        used[row][col]=true;
        if(row+1<grid.length&&grid[row+1][col]=='1'){
            updateUsed(col,row+1,used,grid);
        }
        if(row-1>=0&&grid[row-1][col]=='1'){
            updateUsed(col,row-1,used,grid);
        }
        if(col-1>=0&&grid[row][col-1]=='1'){
            updateUsed(col-1,row,used,grid);
        }
        if(col+1<grid[row].length&&grid[row][col+1]=='1'){
            updateUsed(col+1,row,used,grid);
        }
    }
}
