package leetcode;

/**
 * @author: wyj
 * @date: 2021/04/21
 */
public class A7_IntegerInversion {
    /**
     * 7. 整数反转
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * 示例 1：
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     * 输入：x = 0
     * 输出：0
     * 提示：
     * -231 <= x <= 231 - 1
     */
    public static void main(String[] args) {
        int reverse = new A7_IntegerInversion().reverse(1534236469);
        System.out.println(reverse);
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了29.03%的用户
     * 内存消耗：35.6 MB, 在所有 Java 提交中击败了42.09%的用户
     * @param x
     * @return
     */
    public int reverse(int x) {
        String prefix="";
        if(x<0){
            prefix="-";
            x=-x;
        }
        String s = Integer.toString(x);
        StringBuilder sb=new StringBuilder();
        sb.append(prefix);
        for (int i = s.length() - 1; i >=0; i--) {
            sb.append(s.charAt(i));
        }
        try {
            return Integer.parseInt(sb.toString());
        }catch (Exception e){
            return 0;
        }
    }
}
