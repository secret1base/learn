package leetcode;

import java.util.*;

/**
 * 91. 解码方法
 * @author: wyj
 * @date: 2021/06/23
 */
public class A91_DecodingMethod {
    /**
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     *  要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     *  "AAJF" ，将消息分组为 (1 1 10 6)
     *  "KJF" ，将消息分组为 (11 10 6)
     *  注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     *  给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     *  题目数据保证答案肯定是一个 32 位 的整数。
     *  示例 1：
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     *  示例 2：
     * 输入：s = "226"
     * 输出：3
     * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     *  示例 3：
     * 输入：s = "0"
     * 输出：0
     * 解释：没有字符映射到以 0 开头的数字。
     * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
     * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
     *  示例 4：
     * 输入：s = "06"
     * 输出：0
     * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
     * 动态规划
     * 			执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.7 MB,击败了37.03% 的Java用户
     */
    public int numDecodings(String s) {
        int[] store=new int[s.length()+1];
        store[0]=1;
        for (int i = 1; i <= s.length(); i++){
            if(s.charAt(i-1)!='0'){
                store[i]+=store[i-1];
            }
            if(i>1&&s.charAt(i-2)!='0'&&((s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0'))<=26){
                store[i]+=store[i-2];
            }
        }
        return store[s.length()];
    }


//
//    /**
//     * 回溯算法超时
//     * @param s
//     * @return
//     */
//    public int numDecodings(String s) {
//        List<List<String>> list=new ArrayList<>();
//        Deque<String> path=new LinkedList<>();
//        record(path,list,s);
//        return list.size();
//    }
//
//    private void record(Deque<String> path, List<List<String>> list, String s) {
//        if(s.length()==0){
//            list.add(new ArrayList<>(path));
//            return;
//        }
//        String a1 = s.substring(0, 1);
//        int a = Integer.parseInt(a1);
//        if(a>0&&a<=26){
//            path.offerLast(a1);
//            record(path,list,s.substring(1));
//            path.pollLast();
//        }
//        if(s.length()>1){
//            String a2 = s.substring(0, 2);
//            if(a2.charAt(0)=='0'){
//                return;
//            }
//            int b = Integer.parseInt(a2);
//            if(b>0&&b<=26){
//                path.offerLast(a2);
//                record(path,list,s.substring(2));
//                path.pollLast();
//            }
//        }
//
//    }

    public static void main(String[] args) {
        int i = new A91_DecodingMethod().numDecodings("1111111111111");
        System.out.println(i);//377
    }
}
