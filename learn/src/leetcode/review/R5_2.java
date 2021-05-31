package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R5_2 {
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。

//    /**
//     * 超时
//     * @param s
//     * @return
//     */
//    public String longestPalindrome(String s) {
//        int max=1;
//        String ss=s.charAt(0)+"";
//        for (int i = 0; i < s.length(); i++){
//            for (int j = s.length()-1; j >i; j--) {
//                int left=i;
//                int right=j;
//                boolean flag=true;
//                while (left<=right){
//                    if(s.charAt(left)==s.charAt(right)){
//                        left++;
//                        right--;
//                    }else{
//                        flag=false;
//                        break;
//                    }
//                }
//                if(flag&&j-i+1>max){
//                    ss=s.substring(i,j+1);
//                    max=ss.length();
//                }
//            }
//        }
//        return ss;
//    }
    int max=0;
    String maxLength=null;

    /**
     * 			执行耗时:39 ms,击败了73.54% 的Java用户
     * 			内存消耗:39 MB,击败了56.61% 的Java用户
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length() > 0){
            max=1;
            maxLength=s.substring(0,1);
        }
        for (int i = 0; i < s.length(); i++){
            getMax(i,i+1,s);
            getMax(i-1,i+1,s);
        }
        return maxLength;
    }

    private void getMax(int left, int right, String s) {
        while (left>=0&&right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                if(right-left+1>max){
                    maxLength=s.substring(left,right+1);
                    max=maxLength.length();
                }
                left--;
                right++;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        String abad = new R5_2().longestPalindrome("ccc");
        System.out.println(abad);
    }
}
