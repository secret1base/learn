package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R151_2 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder a=new StringBuilder();
        for (int i = arr.length - 1; i >=0; i--){
            if(arr[i].length()>0){
                a.append(arr[i]).append(" ");
            }
        }
        return a.length()>0?a.substring(0,a.length()-1):a.toString();
    }
}
