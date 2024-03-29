package leetcode;

/**
 * 796. 旋转字符串
 * @author: wyj
 * @date: 2021/07/26
 */
public class A796_RotateString {
    /**
     * 给定两个字符串, A 和 B。
     *  A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后
     * ，A 能变成B，那么返回True。
     * 示例 1:
     * 输入: A = 'abcde', B = 'cdeab'
     * 输出: true
     * 示例 2:
     * 输入: A = 'abcde', B = 'abced'
     * 输出: false
     *  注意：
     *  A 和 B 长度不超过 100。
     *  	执行耗时:5 ms,击败了5.82% 的Java用户
     * 		内存消耗:38.5 MB,击败了5.02% 的Java用户
     */
    public boolean rotateString(String s, String goal) {
        for(int i=0;i<s.length();i++){
            if(s.equals(goal)){
                return true;
            }
            s=s.substring(1)+s.charAt(0);
        }
        return false;
    }
}
