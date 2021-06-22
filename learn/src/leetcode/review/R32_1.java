package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/16
 */
public class R32_1 {
    /**
     * 			执行耗时:2 ms,击败了69.08% 的Java用户
     * 			内存消耗:38.3 MB,击败了83.14% 的Java用户
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int left=0;
        int ritht=0;
        int max=0;
        //从左边开始：每个)的出现都需要有一个(进行抵消，一旦出现)数量比(多，
        //则需要清零重新计数，每次()出现次数相等时进行最大值赋值
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                left++;
            }else{
                ritht++;
            }
            if(left<ritht){
                left=0;
                ritht=0;
            }else if(left==ritht){
                max=Math.max(left+ritht,max);
            }
        }
        //反向检查
        ritht=0;
        left=0;
        for (int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            if(c==')'){
                ritht++;
            }else{
                left++;
            }
            if(left>ritht){
                left=0;
                ritht=0;
            }else if(left==ritht){
                max=Math.max(left+ritht,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new R32_1().longestValidParentheses("(()");
        System.out.println(i);
    }
}
