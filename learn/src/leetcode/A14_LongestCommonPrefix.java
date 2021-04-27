package leetcode;

/**
 * 14. 最长公共前缀
 * @author: wyj
 * @date: 2021/04/22
 */
public class A14_LongestCommonPrefix {
    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * 提示：
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     */
    public static void main(String[] args) {
        String s = new A14_LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(s);
    }

    /**
     * 说明：通过索引index记录满足条件的最大索引+1
     * 执行用时：1 ms, 在所有 Java 提交中击败了84.44%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了33.00%的用户
     */
    public String longestCommonPrefix(String[] strs) {
        //记录最大满足条件的索引位置
        int index=0;
        while (true){
            boolean runcontinue=true;
            Character character=null;
            for (String str : strs) {
                if(index==str.length()){
                    //没有遍历完index的长度就已经超出str下标，说明不满足，不需要继续执行
                    runcontinue=false;
                    break;
                }
                if(character==null){
                    //初始化
                    character=str.charAt(index);
                }else if(character!=str.charAt(index)){
                    //数组str中相同索引位置的字符不相等说明不满足，不需要继续执行
                    runcontinue=false;
                    break;
                }
            }
            if(!runcontinue){
                break;
            }else{
                index++;
            }
        }
        if(index==0){
            return "";
        }else{
            //截取出从0开始到满足索引对应位置相等的最大字符串(最长公共前缀)
            return strs[0].substring(0,index);
        }

    }
}
