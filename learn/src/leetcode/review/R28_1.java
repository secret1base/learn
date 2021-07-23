package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/07/21
 */
public class R28_1 {
    /**
     * 			执行耗时:370 ms,击败了8.34% 的Java用户
     * 			内存消耗:39.2 MB,击败了5.10% 的Java用户
     */
    public int strStr(String haystack, String needle) {
        //不用indexOf
        if(needle.length()==0){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.length()-i<needle.length()){
                return -1;
            }
            char c = haystack.charAt(i);
            if(c==needle.charAt(0)){
                String substring = haystack.substring(i, i+needle.length());
                if(substring.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new R28_1().strStr("hello", "ll");
        System.out.println(i);
    }
}
