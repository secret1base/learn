package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/03
 */
public class R70_5 {
    public int climbStairs(int n) {
        if(n==0){
            return 0;
        }
        int[] store=new int[n<2?2:n];
        store[0]=1;
        store[1]=2;
        for (int i = 2; i < n; i++) {
            store[i]=store[i-1]+store[i-2];
        }
        return store[n-1];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(new R70_5().climbStairs(i));
        }
    }
}
