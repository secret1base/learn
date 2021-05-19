package leetcode;

/**
 * 70.爬楼梯
 * @author: wyj
 * @date: 2021/05/18
 */
public class A70_ClimbStairs {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *  注意：给定 n 是一个正整数。
     *  示例 1：
     *  输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     *  示例 2：
     *  输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * @param n
     * @return
     */
    public static void main(String[] args) {
        //由于解法超时了，那么查看输出结果来进行倒推公式
        for (int i = 1; i < 10; i++) {
            count=0;
            System.out.println(new A70_ClimbStairs().preClimbStairs(i));
        }
        /**
         * 输出结果如下，每次的结果都为前两次的和
         * 1
         * 2
         * 3
         * 5
         * 8
         * 13
         * 21
         * 34
         * 55
         */


    }

    /**
     * 分析结果规律后的第二次解题
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35 MB,击败了81.10% 的Java用户
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        /**
         * 输出结果如下，每次的结果都为前两次的和
         * 1
         * 2
         * 3
         * 5
         * 8
         * 13
         * 21
         * 34
         * 55
         */
        int[] result=new int[n+1];
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else{
            result[1]=1;
            result[2]=2;
            for (int i = 3; i < n+1; i++) {
                if(result[i]==0){
                    result[i] = result[i-2]+result[i-1];
                }
            }
            return result[n];
        }
    }
    //代码精简后的
//    public int climbStairs(int n) {
//        //兔子序列
//        int[] store=new int[n<2?2:n];
//        store[0]=1;
//        store[1]=2;
//        for (int i = 2; i < n; i++) {
//            store[i]=store[i-2]+store[i-1];
//        }
//        return store[n-1];
//    }

    public static int count=0;
    public int preClimbStairs(int n) {
        //从0开始爬楼梯
        climb(0,n);
        return count;
    }

    /**
     * 第一次解题:结果正确，但是超时
     * @param cur 当前爬的楼梯数
     * @param n   需要爬的楼梯数
     */
    private void climb(int cur, int n) {
        if(cur==n){
            //正好
            count++;
        }else if(cur>n){
            return;
        }else{
            //分别爬一阶和二阶
            climb(cur+1,n);
            climb(cur+2,n);
        }
    }




}
