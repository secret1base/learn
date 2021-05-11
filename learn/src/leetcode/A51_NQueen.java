package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * @author: wyj
 * @date: 2021/05/10
 */
public class A51_NQueen {
    /**
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * 示例 1：
     * 51.jpg
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     * 示例 2：
     * 输入：n = 1
     * 输出：[["Q"]]
     * 提示：
     * 1 <= n <= 9
     * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
     */
    /**存储皇后的所有解法*/
    public List<List<String>> resultList=new ArrayList<>();

    /**
     * 思路:
     * 通过queen记录皇后位置
     * 通过attack记录皇后位置更新后的攻击范围
     * 从第0行开始进行检查:举例第一行为0,1,2,3，先检查(0,0)位置是否可以放皇后，如果可以则放置皇后，更新皇后位置及攻击范围
     * 接着进行下一行的检测
     * 具体思路见  n皇后问题.xls
     *
     * 执行耗时:11 ms,击败了10.84% 的Java用户
     * 内存消耗:38.7 MB,击败了56.83% 的Java用户
     */
    public static void main(String[] args) {
        List<List<String>> lists = new A51_NQueen().solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
        }

    }

    /**
     * 测试更新攻击范围是否准确
     *         int n=4;
     *         for (int i = 0; i < n; i++) {
     *             for (int j = 0; j < n; j++) {
     *                 int[][] attack=new int[n][n];
     *                 new Fail51NQueen().putQueen(i,j,attack);
     *                 for (int[] ints : attack) {
     *                     System.out.println(Arrays.toString(ints));
     *                 }
     *                 System.out.println("----------------------------");
     *             }
     *         }
     */

    public List<List<String>> solveNQueens(int n) {
        //存储皇后位置Q为皇后,.为空
        List<String> queen = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder s=new StringBuilder();
            for (int j = 0; j < n; j++){
                s.append(".");
            }
            queen.add(s.toString());
        }
        //存储皇后的攻击位置,0可放，1会被攻击
        int[][] attack=new int[n][n];
        //进行n皇后求解
        backTrack(0,n,queen,attack);
        return resultList;
    }

    /**
     * 放置皇后，并对攻击范围赋值
     * @param x
     * @param y
     * @param attack
     */
    public void putQueen(int x,int y,int[][] attack){
        //方向数组(也是攻击范围)
        int[] a=new int[]{-1,0,1,-1,1,-1,0,1};
        int[] b=new int[]{-1,-1,-1,0,0,1,1,1};
        attack[x][y]=1;
        //执行次数n,意思是向单个方向沿伸的最大值为n，比如皇后在(0,0)时，向右攻击的最远点是(0,8)，向右下攻击的最远点是(8,8)
        for (int i = 0; i < attack.length; i++) {
            //根据8个方向决定
            for (int j = 0; j < 8; j++) {
                int nx=x+i*a[j];
                int ny=y+i*b[j];
                //检查是否在边界范围内
                if(nx>=0&&nx<attack.length&&ny>=0&&ny<attack.length){
                    attack[nx][ny]=1;
                }
            }
        }
    }

    /**
     *
     * @param k 当前行
     * @param n n皇后的n
     * @param queen 存储皇后的位置
     * @param attack 标记皇后的攻击位置
     */
    public void backTrack(int k,int n,List<String> queen,int[][] attack){
        if(k==n){
            List<String> list=new ArrayList<>();
            for (String s : queen) {
                list.add(s);
            }
            resultList.add(list);
            return;
        }
        for (int i = 0; i < n;i++){
            if(attack[k][i]==0){//判断当前位置是否可以放置皇后
                //如果可以，则克隆攻击数组,用于递归结束后的恢复
                int[][] tmp = new int[n][n];
                for (int c = 0; c < n; c++){
                    for (int z = 0; z < n; z++){
                        tmp[c][z]=attack[c][z];
                    }
                }
                String s = queen.get(k);
                //标记皇后位置
                StringBuilder ss=new StringBuilder(s);
                String tmpQueen = ss.replace(i, i + 1, "Q").toString();
                queen.set(k,tmpQueen);
                //更新攻击数组
                putQueen(k,i,attack);
                //查看queen和attack
//                for (String sb : queen) {
//                    System.out.println(sb);
//                }
//                for (int[] ints : attack) {
//                    System.out.println(Arrays.toString(ints));
//                }
//                System.out.println("-----------------------");
                //递归试探下一行的皇后位置
                backTrack(k+1,n,queen,attack);
                //恢复攻击数组
                attack=tmp;
                //恢复queen数组
                String s1 = queen.get(k);
                StringBuilder s2 = new StringBuilder(s1);
                String s3 = s2.replace(i, i + 1, ".").toString();
                queen.set(k,s3);

            }
        }


    }


}
