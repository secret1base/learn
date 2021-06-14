package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R240_1 {
    public static void main(String[] args) {
        boolean b = new R240_1().searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20);
    }
    //			执行耗时:21 ms,击败了5.15% 的Java用户
    //			内存消耗:43.4 MB,击败了97.44% 的Java用户
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int row=0;row<matrix.length;row++){
            for (int col = 0; col < matrix[row].length;col++){
                if(matrix[row][col]==target){
                    return true;
                }else if(matrix[row][col]<target){
                    continue;
                }else{
                    //col-1 row+1
                    int x=col;
                    int y=row;
                    while (x-1>=0&&y+1<matrix.length){
                        x--;
                        y++;
                        while (y<matrix.length&&matrix[y][x]<=target){
                            if(matrix[y][x]==target){
                                return true;
                            }
                            y++;
                        }
                        y=row;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
