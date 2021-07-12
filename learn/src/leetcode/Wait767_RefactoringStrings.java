//package leetcode;
//
///**
// * 767. 重构字符串
// * @author: wyj
// * @date: 2021/07/12
// */
//public class Wait767_RefactoringStrings {
//    /**
//     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//     *  若可行，输出任意可行的结果。若不可行，返回空字符串。
//     *  示例 1:
//     * 输入: S = "aab"
//     * 输出: "aba"
//     *  示例 2:
//     * 输入: S = "aaab"
//     * 输出: ""
//     *  注意:
//     *  S 只包含小写字母并且长度在[1, 500]区间内。
//     *  Related Topics 贪心 哈希表 字符串 计数 排序 堆（优先队列）
//     */
//    /**
//     * 回溯算法+暴力破解：超时且可能存在问题，对于"bbbbaaaaababaababab"迟迟无法返回结果
//     */
////    public String reorganizeString(String s) {
////        boolean[] used=new boolean[s.length()];
////        Deque<Character> path=new LinkedList<>();
////        StringBuilder sb=new StringBuilder();
////        if(record(used,path,s)){
////            for (Character character : path) {
////                sb.append(character);
////            }
////        }
////        return sb.toString();
////    }
////
////    private boolean record(boolean[] used, Deque<Character> path, String s) {
////        if(path.size()==s.length()){
////            return true;
////        }
////        for (int i = 0; i < s.length(); i++) {
////            //没有使用过且与前一个不相同
////            if(used[i]){
////                continue;
////            }
////            char c = s.charAt(i);
////            if(path.isEmpty()||c!=path.peekLast()){
////                path.offerLast(c);
////                used[i] = true;
////                if(record(used,path,s)){
////                    return true;
////                }
////                path.pollLast();
////                used[i]=false;
////            }
////        }
////        return false;
////    }
//
//    public static void main(String[] args) {
////        System.out.println(new A767_RefactoringStrings().reorganizeString("aab"));
////        System.out.println(new A767_RefactoringStrings().reorganizeString("aaab"));
//        System.out.println(new Wait767_RefactoringStrings().reorganizeString("bbbbaaaaababaababab"));
//    }
//}
