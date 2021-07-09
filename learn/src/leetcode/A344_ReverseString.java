package leetcode;

/**
 * @author: wyj
 * @date: 2021/06/29
 */
public class A344_ReverseString {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     *  不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *  你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *  示例 1：
     *  输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *  示例 2：
     *  输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     * 			执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:44.8 MB,击败了86.44% 的Java用户
     */
    public void reverseString(char[] s) {
        int length = s.length;//0123 /2 =2
        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            char tmp = s[i];
            s[i]=s[length-1-i];
            s[length-1-i]=tmp;
        }
    }
}
