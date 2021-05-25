package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R70_3 {
    public static void main(String[] args) {
        for (int i = 0; i < 10;i++){
            System.out.println(new R70_3().climbStairs(i));
        }
    }
    public int climbStairs(int n) {
        if(n==0){
            return 0;
        }
        //兔子序列
        int[] store=new int[n<3?2:n];
        store[0]=1;
        store[1]=2;
        for (int i = 2; i < n; i++){
            store[i]=store[i-2]+store[i-1];
        }
        return store[n-1];
    }
}
