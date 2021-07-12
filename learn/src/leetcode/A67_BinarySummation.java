package leetcode;

/**
 * 67. 二进制求和
 * @author: wyj
 * @date: 2021/07/12
 */
public class A67_BinarySummation {
    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *  输入为 非空 字符串且只包含数字 1 和 0。
     *  示例 1:
     *  输入: a = "11", b = "1"
     * 输出: "100"
     *  示例 2:
     *  输入: a = "1010", b = "1011"
     * 输出: "10101"
     *  提示：
     *  每个字符串仅由字符 '0' 或 '1' 组成。
     *  1 <= a.length, b.length <= 10^4
     *  字符串如果不是 "0" ，就都不含前导零。
     *
     *  解题思路，类似字符串相加
     *  执行耗时:2 ms,击败了98.52% 的Java用户
     * 	内存消耗:38.5 MB,击败了39.92% 的Java用户
     */
    public String addBinary(String a, String b) {
        int left=a.length()-1;
        int right=b.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while (left>=0||right>=0||carry!=0){
            int x=left>=0?a.charAt(left)-'0':0;
            int y=right>=0?b.charAt(right)-'0':0;
            int i = x + y+carry;
            if(i>1){
                carry=1;
                if(i==3){
                    i=1;
                }else{
                    i=0;
                }
            }else{
                carry=0;
            }
            left--;
            right--;
            sb.append(i);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new A67_BinarySummation().addBinary("11","1"));
//        System.out.println(new A67_BinarySummation().addBinary("1010","1011"));
        System.out.println(new A67_BinarySummation().addBinary("1111","1111"));
    }
}
