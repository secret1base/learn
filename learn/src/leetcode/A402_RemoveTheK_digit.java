package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 402. 移掉K位数字
 * @author: wyj
 * @date: 2021/06/30
 */
public class A402_RemoveTheK_digit {
    /**
     * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
     *  示例 1 ：
     * 输入：num = "1432219", k = 3
     * 输出："1219"
     * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
     *  示例 2 ：
     * 输入：num = "10200", k = 1
     * 输出："200"
     * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
     *  示例 3 ：
     * 输入：num = "10", k = 2
     * 输出："0"
     * 解释：从原数字移除所有的数字，剩余为空就是 0 。
     *
     * 			执行耗时:37 ms,击败了11.23% 的Java用户
     * 			内存消耗:39 MB,击败了30.77% 的Java用户
     */
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        List<Character> list=new ArrayList<>();
        for (char c : chars) {
            list.add(c);
        }
        for (int i = 0; i < k; i++) {
            //每次剔除一个破坏升序排列的数
            boolean flag=false;
            for (int j = 0; j < list.size(); j++) {
                if(j+1<list.size()&&list.get(j)>list.get(j+1)){
                    list.remove(j);
                    flag=true;
                    break;
                }
            }
            //如果能执行到这说明前面没有进行移除，则移除最后一位
            if(flag==false){
                list.remove(list.size()-1);
            }
        }
        //去除0
        while (list.size() > 1&&list.get(0)=='0'){
            list.remove(0);
        }
        StringBuilder sb=new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        //如果sb长度为0，则补零
        return sb.length()==0?"0":sb.toString();
    }
//    /**
//     * 解题与题目要求不符
//     * 		测试用例:"10001"
//     * 		4
//     * 		测试结果:"1"
//     * 		期望结果:"0"
//     * 题目要求竟然是任意的字符，而不是连续的
//     * @param args
//     */
//    public String removeKdigits(String num, int k) {
//        /**
//         * 找规律
//         * 移除三位
//         * 12345 12 升序排列移除后三位
//         * 14567 14 升序排列移除后三位
//         * 54321 21 从破坏升序排列前一位开始移除
//         * 15432 12 从破坏升序排列前一位开始移除
//         *
//         */
//        for (int i = 0; i < num.length(); i++) {
//            if(i+1<num.length()&&num.charAt(i) >num.charAt(i+1)){
//                //如果i>i+1，则从i开始进行移除，移除前需要判断下剩余长度
//                int begin=i;
//                int len = num.length() - begin;
//                if(len<k){
//                    begin=num.length()-k;
//                }
//                String s = num.substring(0, begin) + num.substring(begin + k);
//                //去除前面的0
//                while (s.length()>1&&s.indexOf("0")==0){
//                    s=s.substring(1);
//                }
//                return s.length()==0?"0":s;
//            }
//        }
//        //没有破坏升序的移除后面k位
//        String s = num.substring(0, num.length() - k);
//        return s.length()==0?"0":s;
//    }

    public static void main(String[] args) {
        System.out.println(new A402_RemoveTheK_digit().removeKdigits("12345", 3));
        System.out.println(new A402_RemoveTheK_digit().removeKdigits("14567", 3));
        System.out.println(new A402_RemoveTheK_digit().removeKdigits("54321", 3));
        System.out.println(new A402_RemoveTheK_digit().removeKdigits("15432", 3));
        System.out.println(new A402_RemoveTheK_digit().removeKdigits("10200", 1));
        System.out.println(new A402_RemoveTheK_digit().removeKdigits("10", 2));
        System.out.println(new A402_RemoveTheK_digit().removeKdigits("10001", 4));
    }
}
