//package leetcode;
//
//import java.util.*;
//
///**
// * @author: wyj
// * @date: 2021/07/19
// */
//public class Fail567_ArrangementOfStrings {
//    /**
//     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//     *  换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
//     *  示例 1：
//     * 输入: s1 = "ab" s2 = "eidbaooo"
//     * 输出: True
//     * 解释: s2 包含 s1 的排列之一 ("ba").
//     *  示例 2：
//     * 输入: s1= "ab" s2 = "eidboaoo"
//     * 输出: False
//     *  提示：
//     *  1 <= s1.length, s2.length <= 104
//     *  s1 和 s2 仅包含小写字母
//     */
//    //TODO 下面的思路不行，解到最后一步，又变成了最开始的问题
//    public boolean checkInclusion(String s1, String s2) {
//        //判断：第一个字符串的排列之一是第二个字符串的子串
//        //获取第一个中的所有字母的数量，在第二个字符串中找到对应所有字母的下标，
//        //然后将第二个字符中的所有下标进行排序，如果顺序存在连续的判断长度是否符合，取出所有长度符合的连续字符串
//        //然后判断字母数量是否对应
//        Map<Character,Integer> map1=new HashMap<>();
//        //获取第一个中的所有字母的数量
//        for (int i = 0; i < s1.length(); i++) {
//            char c = s1.charAt(i);
//            Integer count = map1.getOrDefault(c, 0);
//            map1.put(c,count+1);
//        }
//        //在第二个字符串中找到对应所有字母的下标
//        List<Integer> list=new ArrayList<>();
//        for (int i = 0; i < s2.length(); i++) {
//            char c = s2.charAt(i);
//            Integer integer = map1.get(c);
//            if(integer!=null){
//                list.add(i);
//            }
//        }
//        //排序后，找到所有长度大于等于s1长度的连续数组
//        Collections.sort(list);
//        List<int[]> listArr=new ArrayList<> ();
//        int m=1;
//        //从1开始获取连续值
//        for (int i = 1; i < list.size(); i++) {
//            if(list.get(i)==list.get(i-1)+1){
//                //此时当前值和上一个值是连续的
//                m++;
//            }else{
//                if(m>=s1.length()){
//                    //假设数组为135那么1的连续长度为[0,1)，右开区间是为了便于后面截取字符串长度
//                    listArr.add(new int[]{list.get(i-1)-m,list.get(i-1)});
//                }
//                m=1;
//            }
//        }
//        if(m>=s1.length()){
//            //假设数组为135那么1的连续长度为[0,1)，右开区间是为了便于后面截取字符串长度
//            listArr.add(new int[]{list.get(list.size()-1)+1-m,list.get(list.size()-1)+1});
//        }
//        //判断连续数组字母是否对应
//        for (int[] ints : listArr) {
//            Map<Character,Integer> tmp=new HashMap<>();
//            for (Character character : map1.keySet()) {
//                tmp.put(character,map1.get(character));
//            }
//            String substring = s2.substring(ints[0], ints[1]);
//            //判断substring的是否满足要求
//            for (int i = 0; i <substring.length();i++){
//                char c = substring.charAt(i);
//                Integer integer = tmp.get(c);
//                if(integer==null){
//                    continue;
//                }
//                if(integer==1){
//                    tmp.remove(c);
//                }else{
//                    tmp.put(c,integer-1);
//                }
//            }
//            if(tmp.keySet().size()==0){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
////        System.out.println(new A567_ArrangementOfStrings().checkInclusion("ab","eidbaooo"));
////        System.out.println(new A567_ArrangementOfStrings().checkInclusion("ab","eidboaoo"));
////        System.out.println(new A567_ArrangementOfStrings().checkInclusion("a","ab"));
////        System.out.println(new A567_ArrangementOfStrings().checkInclusion("adc","dcda"));
//        System.out.println(new Fail567_ArrangementOfStrings().checkInclusion("hello","ooolleoooleh"));
//    }
//}
