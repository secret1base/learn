package leetcode;

import java.util.*;

/**
 * 93. 复原IP地址
 * @author: wyj
 * @date: 2021/05/31
 */
public class A93_RecoverIPAddress {
    /**
     * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
     *  有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *  例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
     * 和 "192.168@1.1" 是 无效 IP 地址。
     *  示例 1：
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     *  示例 2：
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     *  示例 3：
     * 输入：s = "1111"
     * 输出：["1.1.1.1"]
     *  示例 4：
     * 输入：s = "010010"
     * 输出：["0.10.0.10","0.100.1.0"]
     *  示例 5：
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     *  提示：
     *  0 <= s.length <= 3000
     *  s 仅由数字组成
     */
    public static void main(String[] args) {
        List<String> list = new A93_RecoverIPAddress().restoreIpAddresses("101023");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 			执行耗时:2 ms,击败了80.00% 的Java用户
     * 			内存消耗:38.5 MB,击败了55.67% 的Java用户
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        Deque<String> path=new LinkedList<>();
        doRecord(0,s,path,list);
        return list;
    }

    private void doRecord(int left, String s, Deque<String> path, List<String> list) {
        if(left==s.length()&&path.size()==4){
            List<String> tmp=new ArrayList<>(path);
            StringBuilder b=new StringBuilder();
            for (String s1 : tmp) {
                b.append(s1).append(".");
            }
            list.add(b.substring(0,b.length()-1));
            return;
        }else if(path.size() ==4){
            return;
        }
        int index=left;
        while (index<left+3&&index<s.length()){
            String tmp = s.substring(left, index + 1);
            if((tmp.length()>1&&tmp.charAt(0)=='0')||(Integer.parseInt(tmp)>255)){
                //长度大于1位不能以0开头并且数值范围不能大于255
                break;
            }
            path.offerLast(tmp);
            doRecord(index+1,s,path,list);
            path.pollLast();
            index++;
        }
    }

}
