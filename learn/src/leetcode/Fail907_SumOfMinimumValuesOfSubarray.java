//package leetcode;
//
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * 907. 子数组的最小值之和
// * @author: wyj
// * @date: 2021/07/21
// */
//public class Fail907_SumOfMinimumValuesOfSubarray {
//    /**
//     * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
//     *  由于答案可能很大，因此 返回答案模 10^9 + 7 。
//     *  示例 1：
//     * 输入：arr = [3,1,2,4]
//     * 输出：17
//     * 解释：
//     * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
//     * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
//     *  示例 2：
//     * 输入：arr = [11,81,94,43,3]
//     * 输出：444
//     *  提示：
//     *  1 <= arr.length <= 3 * 104
//     *  1 <= arr[i] <= 3 * 104
//     */
//    /**
//     * 又又又超时了
//     * @param arr
//     * @return
//     */
//    public int sumSubarrayMins(int[] arr) {
//        //求出所有连续子数组
//        List<Integer> list=new ArrayList<>();
//        Deque<Integer> path=new LinkedList<>();
//        for (int i = 0; i < arr.length; i++) {
//            path.offerLast(arr[i]);
//            record(i,path,arr,list);
//            path.pollLast();
//        }
//        long sum=0;
//        for (Integer integer : list) {
//            sum+=integer;
//        }
//        return (int)(sum%1000000007);
//    }
//
//    private void record(int index, Deque<Integer> path, int[] arr, List<Integer> list) {
//        if(index==arr.length){
//            return;
//        }
//        Integer min=null;
//        for (Integer integer : path) {
//            if(min==null){
//                min=integer;
//            }else{
//                min=Math.min(min,integer);
//            }
//        }
//        if(min!=null){
//            list.add(min);
//        }
//        if(index+1<arr.length){
//            path.offerLast(arr[index+1]);
//            record(index+1,path,arr,list);
//            path.pollLast();
//        }
//    }
//    //第一步求出所有连续子数组
////    public int sumSubarrayMins(int[] arr) {
////        //求出所有连续子数组
////        List<List<Integer>> list=new ArrayList<>();
////        Deque<Integer> path=new LinkedList<>();
////        for (int i = 0; i < arr.length; i++) {
////            path.offerLast(arr[i]);
////            record(i,path,arr,list);
////            path.pollLast();
////        }
////        for (List<Integer> integers : list) {
////            System.out.println(integers);
////        }
////        return 0;
////    }
////
////    private void record(int index, Deque<Integer> path, int[] arr, List<List<Integer>> list) {
////        if(index==arr.length){
////            return;
////        }
////        list.add(new ArrayList<>(path));
////        if(index+1<arr.length){
////            path.offerLast(arr[index+1]);
////            record(index+1,path,arr,list);
////            path.pollLast();
////        }
////    }
//
//    public static void main(String[] args) {
//        int i = new Fail907_SumOfMinimumValuesOfSubarray().sumSubarrayMins(new int[]{11,81,94,43,3});
//        System.out.println(i);
//    }
//}
