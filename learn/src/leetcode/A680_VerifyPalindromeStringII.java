package leetcode;

/**
 * 680. 验证回文字符串 Ⅱ
 * @author: wyj
 * @date: 2021/07/12
 */
public class A680_VerifyPalindromeStringII {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *  示例 1:
     * 输入: "aba"
     * 输出: True
     *  示例 2:
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     *  注意:
     *  字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     *
     *  		执行耗时:8 ms,击败了76.76% 的Java用户
     * 			内存消耗:39 MB,击败了41.98% 的Java用户
     */
    public boolean validPalindrome(String s) {
        //应该和验证回文是一样的，但是可以进行一次容错(可以删除一个字母),先左边进行一次容错，再右边进行一次容错，最终取两个结果的||
        //aba left=0 right=2
        //aa
        int left=0;
        int right=s.length()-1;
        boolean flag=false;
        boolean leftFlag=true;
        //左右两边分别进行一次容错
        while (left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else if(!flag){
                flag=true;
                //删除一个字母(进行一次容错),先左边容错
                left++;
            }else{
                leftFlag=false;
                break;
            }
        }
        left=0;
        right=s.length()-1;
        flag=false;
        boolean rightFlag=true;
        while (left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else if(!flag){
                flag=true;
                //删除一个字母(进行一次容错),先左边容错
                right--;
            }else{
                rightFlag=false;
                break;
            }
        }
        return leftFlag||rightFlag;
    }

    public static void main(String[] args) {
//        System.out.println(new A680_VerifyPalindromeStringII().validPalindrome("aba"));
//        System.out.println(new A680_VerifyPalindromeStringII().validPalindrome("abca"));
        System.out.println(new A680_VerifyPalindromeStringII().validPalindrome("cbbcc"));
    }
}
