package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/22
 */
public class R32_2 {
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"

    /**
     * 			执行耗时:2 ms,击败了69.10% 的Java用户
     * 			内存消耗:38.6 MB,击败了20.93% 的Java用户
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        //两边指针
        int left=0;
        int right=0;
        int max=0;
        //从左开始
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c =='('){
                left++;
            }else{
                right++;
            }
            if(left<right){
                left=0;
                right=0;
            }else if(left==right){
                max=Math.max(max,left*2);
            }

        }
        left=0;
        right=0;
        //从右开始
        for (int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            if(c =='('){
                left++;
            }else{
                right++;
            }
            if(left>right){
                left=0;
                right=0;
            }else if(left==right){
                max=Math.max(max,left*2);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new R32_2().longestValidParentheses("()(()");
        System.out.println(i);
    }
}
