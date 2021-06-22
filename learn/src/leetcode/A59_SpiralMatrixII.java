package leetcode;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * @author: wyj
 * @date: 2021/06/16
 */
public class A59_SpiralMatrixII {
    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *  示例 1：
     * 输入：n = 3
     * 输出：[
     * [1,2,3],
     * [8,9,4],
     * [7,6,5]]
     *  示例 2：
     * 输入：n = 1
     * 输出：[[1]]
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.5 MB,击败了51.41% 的Java用户
     */
    public int[][] generateMatrix(int n) {
        int[][] arr=new int[n][n];
        boolean[][] used=new boolean[n][n];
        //右下左上右
        int total=n*n;
        /**
         * (1,0)(0,1)(-1,0)(0,-1)(1.0)
         */
        int x=1;
        int y=0;
        int row=0;
        int col=-1;
        for (int i = 1; i <= total; i++){
            int b=row+y;
            int a=col+x;
            if((a<0||a==n||b<0||b==n)||(used[b][a])){
                //到达边界
                if(x==1){
                    x=0;
                    y=1;
                }else if(y==1){
                    x=-1;
                    y=0;
                }else if(x==-1){
                    x=0;
                    y=-1;
                }else if(y==-1){
                    x=1;
                    y=0;
                }
                row+=y;
                col+=x;
            }else{
                row=b;
                col=a;
            }
            arr[row][col]=i;
            used[row][col]=true;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] ints = new A59_SpiralMatrixII().generateMatrix(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
