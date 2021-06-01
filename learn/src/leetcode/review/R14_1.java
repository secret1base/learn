package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/06/01
 */
public class R14_1 {
//输入：strs = ["flower","flow","flight"]
//输出："fl"
public static void main(String[] args) {
    String s = new R14_1().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    System.out.println(s);
}

    /**
     * 		执行耗时:1 ms,击败了84.78% 的Java用户
     * 		内存消耗:36.5 MB,击败了53.64% 的Java用户
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int right=0;
        while (true){
            boolean flag=true;
            Character character=null;
            for (String str : strs) {
                if(right>=str.length()){
                    flag=false;
                    break;
                }else if (character==null){
                    character=str.charAt(right);
                }else if(character!=str.charAt(right)){
                    flag=false;
                    break;
                }
            }
            if(!flag){
                break;
            }
            right++;
        }
        return strs[0].substring(0,right);
    }
}
