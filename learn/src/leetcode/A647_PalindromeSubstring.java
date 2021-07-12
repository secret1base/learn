package leetcode;

/**
 * 647. 回文子串
 * @author: wyj
 * @date: 2021/07/12
 */
public class A647_PalindromeSubstring {
    /**
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     *  具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *  示例 1：
     *  输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     *  示例 2：
     *  输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     * 输入的字符串长度不会超过 1000 。
     *
     * 一次过
     * 执行耗时:3 ms,击败了93.77% 的Java用户
     * 内存消耗:36.5 MB,击败了80.98% 的Java用户
     *
     */
    public int countSubstrings(String s) {
        //aba 012 从1开始找mid-1,mid+1
        //aa 01  从0开始找mid,mid+1，因此下次循环没有
        //每个字符都是一个回文子串
        int sum=s.length();
        //i作为mid
        for (int i = 0; i < s.length(); i++) {
            int left=i-1;
            int right=i+1;
            while (left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    sum++;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            left=i;
            right=i+1;
            while (left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    sum++;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new A647_PalindromeSubstring().countSubstrings("aaa"));
    }
}
