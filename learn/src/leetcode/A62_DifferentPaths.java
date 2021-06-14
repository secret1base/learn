package leetcode;

import java.util.Arrays;

/**
 * @author: wyj
 * @date: 2021/06/11
 */
public class A62_DifferentPaths {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *  问总共有多少条不同的路径？
     *  示例 1：
     * 输入：m = 3, n = 7
     * 输出：28
     *  示例 2：
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     *  示例 3：
     * 输入：m = 7, n = 3
     * 输出：28
     *  示例 4：
     * 输入：m = 3, n = 3
     * 输出：6
     */
    int count;
    public int oldUniquePaths(int m, int n) {
        boolean[][] used=new boolean[m][n];
        used[0][0]=true;
        walk(0,0,used);
        return count;
    }

    private void walk(int row, int col, boolean[][] used) {
        if(row==used.length-1&&col==used[row].length-1){
            count++;
            return;
        }
        //1,0 0,-1
        if(col+1<used[row].length&&!used[row][col+1]){
            used[row][col+1] = true;
            walk(row,col+1,used);
            used[row][col+1] = false;
        }
        if(row+1<used.length&&!used[row+1][col]){
            used[row+1][col] = true;
            walk(row+1,col,used);
            used[row+1][col] = false;
        }
    }

    public static void main(String[] args) {
        //解题结果超时，但是答案肯定正确，接下来需要去找答案的规律
        for (int i=1;i<10;i++){
            for (int j = 1; j < 10; j++) {
                System.out.print(new A62_DifferentPaths().oldUniquePaths(i,j)+",");
            }
            System.out.println("");
        }
        /**
         * 规律如下：发现可以通过动态规划进行解题，每个值为上面一格和左边一格的和
         * 1,1,1,1,1,1,1,1,1,
         * 1,2,3,4,5,6,7,8,9,
         * 1,3,6,10,15,21,28,36,45,
         * 1,4,10,20,35,56,84,120,165,
         * 1,5,15,35,70,126,210,330,495,
         * 1,6,21,56,126,252,462,792,1287,
         * 1,7,28,84,210,462,924,1716,3003,
         * 1,8,36,120,330,792,1716,3432,6435,
         * 1,9,45,165,495,1287,3003,6435,12870,
         */
        new A62_DifferentPaths().uniquePaths(3,7);
    }


    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.1 MB,击败了79.20% 的Java用户
     */
    public int uniquePaths(int m, int n) {
        int[][] store=new int[n][m];
        for (int[] ints : store) {
            Arrays.fill(ints,1);
        }
        for (int row=1;row<n;row++){
            for (int col = 1; col <m;col++ ){
                store[row][col]=store[row-1][col]+store[row][col - 1];
            }
        }
        return store[n-1][m-1];
    }
}
