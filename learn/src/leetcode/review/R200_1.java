package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R200_1 {
    //			执行耗时:4 ms,击败了25.48% 的Java用户
    //			内存消耗:46.8 MB,击败了5.03% 的Java用户
    //
    public static void main(String[] args) {
        int i = new R200_1().numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        System.out.println(i);
    }
    //计算岛屿数量，四个方向
    int count=0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        boolean[][] attack=new boolean[grid.length][grid[0].length];
        doWrite(0,0,attack,grid);
        return count;
    }

    private void doWrite(int col, int row, boolean[][] attack, char[][] grid) {
        if(col==grid[row].length){
            col=0;
            row++;
            if(row == grid.length){
                return;
            }
        }
        if(grid[row][col]=='1'&&!attack[row][col]){
            //发现新的岛屿
            count++;
            updateIsland(row,col,attack,grid);
        }
        doWrite(col+1,row,attack,grid);
    }

    private void updateIsland(int row, int col, boolean[][] attack, char[][] grid) {
        if(attack[row][col]){
           return;
        }
        attack[row][col]=true;
        //上
        if(row-1>=0){
            if(grid[row-1][col]=='1'){
                updateIsland(row-1,col,attack,grid);
            }
        }
        //下
        if(row+1<attack.length){
            if(grid[row+1][col]=='1'){
                updateIsland(row+1,col,attack,grid);
            }
        }
        //左
        if(col-1>=0){
            if(grid[row][col-1]=='1'){
                updateIsland(row,col-1,attack,grid);
            }
        }
        //右
        if(col+1<grid[row].length){
            if(grid[row][col+1]=='1'){
                updateIsland(row,col+1,attack,grid);
            }
        }
    }
}
