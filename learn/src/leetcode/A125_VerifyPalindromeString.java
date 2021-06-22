package leetcode;

/**
 * 125. 验证回文串
 * @author: wyj
 * @date: 2021/06/22
 */
public class A125_VerifyPalindromeString {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *  说明：本题中，我们将空字符串定义为有效的回文串。
     *  示例 1:
     *  输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *  示例 2:
     *  输入: "race a car"
     * 输出: false
     *
     * 题目描述有问题搞得人看不懂了都，注意空格不要考虑
     * 			执行耗时:7 ms,击败了20.20% 的Java用户
     * 			内存消耗:38.4 MB,击败了78.65% 的Java用户
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)||Character.isAlphabetic(c)){
                sb.append(c);
            }
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        if(sb.toString().equals(reverse.toString())){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        boolean palindrome = new A125_VerifyPalindromeString().isPalindrome("race a car");
        System.out.println(palindrome);
        boolean palindrome1 = new A125_VerifyPalindromeString().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome1);
    }
}
