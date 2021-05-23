package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R69_2 {
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        int r=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            if((long)mid*mid<=x){
                r=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return r;
    }
}
