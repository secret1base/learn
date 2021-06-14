package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R200_4 {
    //			执行耗时:2 ms,击败了95.03% 的Java用户
    //			内存消耗:40.9 MB,击败了49.94% 的Java用户
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int count=0;
        boolean[][] used=new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                char c = grid[row][col];
                if(c=='1'&&!used[row][col]){
                    count++;
                    //更新使用范围
                    updateUsed(row,col,used,grid);
                }
            }
        }
        return count;
    }

    private void updateUsed(int row, int col, boolean[][] used, char[][] grid) {
        if(row>=0&&row<grid.length&&col>=0&&col<grid[row].length&&grid[row][col]=='1'&&!used[row][col]){
            used[row][col]=true;
        }else{
            return;
        }
        /**
         *         x,y-1
         * x-1,y   x,y   x+1,y
         *         x,y+1
         */
        updateUsed(row-1,col,used,grid);
        updateUsed(row+1,col,used,grid);
        updateUsed(row,col-1,used,grid);
        updateUsed(row,col+1,used,grid);
    }
}
