package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/19
 */
public class R70_1 {
    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
    public static void main(String[] args) {
        /**
         * 1
         * 2
         * 3
         * 5
         * 8
         */
        for (int i = 1; i < 10;i++){
            System.out.println(new R70_1().climbStairs(i));
        }
    }
    //执行耗时:0 ms,击败了100.00% 的Java用户
    //			内存消耗:35.2 MB,击败了41.11% 的Java用户
    //
    public int climbStairs(int n) {
        //兔子序列
        int[] store=new int[n<2?2:n];
        store[0]=1;
        store[1]=2;
        for (int i = 2; i < n; i++) {
            store[i]=store[i-2]+store[i-1];
        }
        return store[n-1];
    }

//    private void climb(int sum, int n) {
//        if(sum==n){
//            count++;
//            return;
//        }else if(sum>n){
//            return;
//        }
//        climb(sum+1,n);
//        climb(sum+2,n);
//    }
}
