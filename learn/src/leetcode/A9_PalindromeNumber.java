package leetcode;

/**
 * 9. 回文数
 * @author: wyj
 * @date: 2021/04/21
 */
public class A9_PalindromeNumber {
    /**
     * 9. 回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     * 示例 4：
     * 输入：x = -101
     * 输出：false
     * 提示：
     * -231 <= x <= 231 - 1
     */
    public static void main(String[] args) {
//        boolean palindrome = new A9_PalindromeNumber().isPalindrome(121);
        boolean palindrome = new A9_PalindromeNumber().isPalindrome(21);
//        boolean palindrome = new A9_PalindromeNumber().isPalindrome(311);
        System.out.println(palindrome);
    }

    /**
     * 说明：通过双指针left和right向左向右进行检查，指针的初始值根据输入值的长度为奇偶数分别进行赋值
     * 执行用时：11 ms, 在所有 Java 提交中击败了46.49%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了61.08%的用户
     */
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String str = Integer.toString(x);
        int length = str.length();
        if(length==1){
            return true;
        }
        int i = str.length() % 2;
        int left=0;
        int right=0;
        int mid = length / 2;
        if(i==1){
            //0 1 2 length=3 3/2=1 left=0 right=2
            left=mid-1;
            right=mid+1;
        }else{
            //0 1 length=2 2/2=1 left=0 right=1
            left=mid-1;
            right=mid;
        }
        while (left>=0&&right<length){
            if(str.charAt(left--)!=str.charAt(right++)){
                return false;
            }
        }
        return true;
    }
    /**
     * 通过双指针进行判断是上面方法的优化，从左右段点开始进行判断，而不是上面的先寻找中间位置
     */
//    public boolean isPalindrome(int a) {
//        if(a<0){
//            return false;
//        }
//        String s = Integer.toString(a);
//        int begin=0;
//        int end=s.length()-1;
//        while(begin<end){
//            if(s.charAt(begin)!=s.charAt(end)){
//                return false;
//            }
//            begin++;
//            end--;
//        }
//        return true;
//    }
}
