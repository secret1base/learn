//package leetcode;
//
//import java.util.*;
//
///**
// * 1363. 形成三的最大倍数
// * @author: wyj
// * @date: 2021/07/27
// */
//public class Fail1363_FormTheMaximumMultipleOfThree {
//    /**
//     * 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
//     *  由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
//     *  如果无法得到答案，请返回一个空字符串。
//     *  示例 1：
//     *  输入：digits = [8,1,9]
//     * 输出："981"
//     *  示例 2：
//     *  输入：digits = [8,6,7,1,0]
//     * 输出："8760"
//     *  示例 3：
//     *  输入：digits = [1]
//     * 输出：""
//     *  示例 4：
//     *  输入：digits = [0,0,0,0,0,0]
//     * 输出："0"
//     *  提示：
//     *  1 <= digits.length <= 10^4
//     *  0 <= digits[i] <= 9
//     *  返回的结果不应包含不必要的前导零。
//     *
//     *
//     */
//    /**
//     * 又又又超时了
//     */
//    int maxLength=0;
//    List<Integer> maxList=new ArrayList<>();
//    public String largestMultipleOfThree(int[] digits) {
//        Arrays.sort(digits);
//        //能不能被三整除，要看他们的和是不是三的整数倍
//        //获取所有子数组
//        Deque<Integer> path=new LinkedList<>();
//        for(int i=0;i<digits.length;i++){
//            path.offerLast(digits[i]);
//            record(i,path,digits,digits[i]);
//            path.pollLast();
//        }
//        StringBuilder sb=new StringBuilder();
//        for (Integer integer : maxList) {
//            sb.append(integer);
//        }
//        String s = sb.reverse().toString();
//        if(s.length()>0&&s.charAt(0)=='0'){
//            return "0";
//        }
//        return s;
//    }
//
//    private void record(int index, Deque<Integer> path, int[] digits, int sum) {
//        if(sum%3==0){
//            if(path.size()>maxLength){
//                maxLength=path.size();
//                maxList=new ArrayList<>(path);
//            }else if(path.size()==maxLength){
//                boolean success=false;
//                ArrayList<Integer> tmp = new ArrayList<>(path);
//                for (int i = 0; i < maxLength; i++) {
//                    if(tmp.get(i)>maxList.get(i)){
//                        success=true;
//                        break;
//                    }
//                }
//                if(success){
//                    maxList=tmp;
//                }
//            }
//        }
//        for (int i = index+1; i < digits.length; i++) {
//            path.offerLast(digits[i]);
//            record(i,path,digits, digits[i]+sum);
//            path.pollLast();
//        }
//    }
//
//    public static void main(String[] args) {
//        String s = new Fail1363_FormTheMaximumMultipleOfThree().largestMultipleOfThree(new int[]{8, 6, 7, 1, 0});
//        System.out.println(s);
//    }
//}
