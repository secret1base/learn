package leetcode;

/**
 * 231. 2的幂
 * @author: wyj
 * @date: 2021/07/15
 */
public class A231_ThePowerOf2 {
    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     *  如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     *  示例 1：
     * 输入：n = 1
     * 输出：true
     * 解释：20 = 1
     *  示例 2：
     * 输入：n = 16
     * 输出：true
     * 解释：24 = 16
     *  示例 3：
     * 输入：n = 3
     * 输出：false
     *  示例 4：
     * 输入：n = 4
     * 输出：true
     *  示例 5：
     * 输入：n = 5
     * 输出：false
     */
    /**
     * 			执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.4 MB,击败了81.56% 的Java用户
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        while (n!=1){
            if(n%2==0){
                n/=2;
            }else{
                //在循环内说明不是1
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A231_ThePowerOf2().isPowerOfTwo(1));
    }
}
