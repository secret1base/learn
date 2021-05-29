package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/26
 */
public class R151_3 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder a=new StringBuilder();
        for (int i = arr.length-1; i >=0; i--) {
            if(arr[i].length()>0){
                a.append(arr[i]).append(" ");
            }
        }
        if(a.length() > 0){
            return a.substring(0,a.length()-1);
        }else{
            return a.toString();
        }
    }
}
