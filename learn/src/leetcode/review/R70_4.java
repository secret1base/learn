package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/25
 */
public class R70_4 {
    /**
     * 			执行耗时:78 ms,击败了30.18% 的Java用户
     * 			内存消耗:37.8 MB,击败了90.85% 的Java用户
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n==0){
            return 0;
        }
        int[] store=new int[n<3?2:n];
        store[0]=1;
        store[1]=2;
        for (int i = 2; i < n; i++){
            store[i]=store[i-2]+store[i-1];
        }
        return store[n-1];
    }
}
