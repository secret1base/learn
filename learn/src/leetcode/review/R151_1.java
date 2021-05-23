package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R151_1 {
    public static void main(String[] args) {
        String z = new R151_1().reverseWords("ab cd dd fg ");
        System.out.println(z);
    }
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder str=new StringBuilder();
        for (int i = arr.length - 1; i >=0 ; i--) {
            if(arr[i].length() > 0){
                str.append(arr[i]).append(" ");
            }
        }
        if(str.length() > 0){
            return str.substring(0,str.length() - 1);
        }
        return str.toString();
    }
}
