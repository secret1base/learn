//package leetcode;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
///**
// * 877. 石子游戏
// * @author: wyj
// * @date: 2021/07/16
// */
//public class Fail877_StoneGame {
//    /**
//     * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
//     *  游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
//     *  亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
//     *  假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
//     *  示例：
//     * 输入：[5,3,4,5]
//     * 输出：true
//     * 解释：
//     * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
//     * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
//     * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
//     * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
//     * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
//     *  提示：
//     *  2 <= piles.length <= 500
//     *  piles.length 是偶数。
//     *  1 <= piles[i] <= 500
//     *  sum(piles) 是奇数。
//     */
//    每次只取最优解是难点
//    public boolean stoneGame(int[] piles) {
//        //最佳水平，也就是每次只取最大的，如果两边一样大就开分支
//        Deque<Integer> leftPath=new LinkedList<>();
//        Deque<Integer> rightPath=new LinkedList<>();
//        int left=0;
//        int right=piles.length-1;
//        return catchStone(leftPath,rightPath,left,right,piles,true);
//    }
//
//    private boolean catchStone(Deque<Integer> leftPath, Deque<Integer> rightPath, int left, int right, int[] piles,boolean leftCatch) {
//        if(left==right){
//            int leftSum=0;
//            for (Integer integer : leftPath) {
//                leftSum+=integer;
//            }
//            int rightSum=0;
//            for (Integer integer : rightPath) {
//                rightSum+=integer;
//            }
//            return leftSum>rightSum;
//        }
//        //找到当前的最大值
//        int p1 = piles[left];
//        int p2 = piles[right];
//        if(leftCatch){
//            //亚历克斯抓
//            leftPath.offerLast(p1);
//        }else{
//            rightPath.offerLast(p1);
//        }
//        boolean a = catchStone(leftPath, rightPath, left + 1, right, piles, !leftCatch);
//        if(leftCatch){
//            //亚历克斯抓
//            leftPath.pollLast();
//        }else{
//            rightPath.pollLast();
//        }
//        if(leftCatch){
//            //亚历克斯抓
//            leftPath.offerLast(p1);
//        }else{
//            rightPath.offerLast(p1);
//        }
//        boolean b = catchStone(leftPath, rightPath, left, right-1, piles, !leftCatch);
//        if(leftCatch){
//            //亚历克斯抓
//            leftPath.pollLast();
//        }else{
//            rightPath.pollLast();
//        }
//        return a||b;
//    }
//
//    public static void main(String[] args) {
//        boolean b = new Fail877_StoneGame().stoneGame(new int[]{4,5,7,1,10,6,3,5});
//        System.out.println(b);
//    }
//}
