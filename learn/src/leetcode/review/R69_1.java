package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/20
 */
public class R69_1 {
    public static void main(String[] args) {
        int i = new R69_1().mySqrt(9);
        System.out.println(i);
    }
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        int mid=left+(right-left)/2;
        int r=-1;
        while (left<=right){
            if((long)mid*mid<=x){
                r=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
            mid=left+(right-left)/2;
        }
        return r;
    }
}
