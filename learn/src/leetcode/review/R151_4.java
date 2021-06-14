package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R151_4 {
    //输入：s = "the sky is blue"
    //			执行耗时:6 ms,击败了77.91% 的Java用户
    //			内存消耗:38.6 MB,击败了44.39% 的Java用户
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = arr.length-1; i >=0; i--) {
            if(arr[i].length()>0){
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = new R151_4().reverseWords(" hello world  ");
        System.out.println(s);
    }
}
