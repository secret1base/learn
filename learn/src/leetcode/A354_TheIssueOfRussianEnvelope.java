package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 * @author: wyj
 * @date: 2021/07/14
 */
public class A354_TheIssueOfRussianEnvelope {
    /**
     * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
     *  当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     *  请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     *  注意：不允许旋转信封。
     *  示例 1：
     * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出：3
     * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     *  示例 2：
     * 输入：envelopes = [[1,1],[1,1],[1,1]]
     * 输出：1
     */

    /**
     * 解法二
     * 在解法一的基础上再进一步，使用动态规划，从左向右，初始值都为1
     * 第一次有成就感的自己实现了动态规划
     * 			执行耗时:232 ms,击败了59.70% 的Java用户
     * 			内存消耗:39.3 MB,击败了57.16% 的Java用户
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0]>o2[0]){
                return 1;
            }else if(o1[0]<o2[0]){
                return -1;
            }else{
                if(o1[1]>o2[1]){
                    return 1;
                }else if(o1[1]<o2[1]){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        int[] store=new int[envelopes.length];
        Arrays.fill(store,1);
        //进行套娃
        int max=1;
        for (int i = 1; i < envelopes.length; i++) {
            int left = envelopes[i][0];
            int right = envelopes[i][1];
            for (int j = i-1; j >=0; j--) {
                //从i-1位开始向前找，找能够被i套的信封数量的最大值
                int left2 = envelopes[j][0];
                int right2 = envelopes[j][1];
                if(left2<left&&right2<right){
                    //能被i信封套
                    store[i]=Math.max(store[i],store[j]+1);
                    max=Math.max(max,store[i]);
                }
            }
        }
        return max;
    }


//    /**
//     * 解法一
//     * 合并区间的思维+回溯算法结果超时
//     */
//    int max=1;
//    public int maxEnvelopes(int[][] envelopes) {
//        //和一道合并区间的题目有点类似
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0]>o2[0]){
//                    return 1;
//                }else if(o1[0]<o2[0]){
//                    return -1;
//                }else{
//                    if(o1[1]>o2[1]){
//                        return 1;
//                    }else if(o1[1]<o2[1]){
//                        return -1;
//                    }else{
//                        return 0;
//                    }
//                }
//            }
//        });
//        //需要加一个回溯算法，因为后面可能有更合适的,并不是只要找到就可以
//        for (int i = 0; i < envelopes.length; i++) {
//            int left = envelopes[i][0];
//            int right = envelopes[i][1];
//            getBetter(left,right,i,envelopes,1);
//        }
//        return max;
//    }
//
//    private void getBetter(int left, int right, int i, int[][] envelopes, int level) {
//        max=Math.max(max,level);
//        for(int j=i+1;j<envelopes.length;j++){
//            int left2 = envelopes[j][0];
//            int right2 = envelopes[j][1];
//            if(left<left2&&right<right2){
//                getBetter(left2, right2, j, envelopes, level+1);
//            }
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(new A354_TheIssueOfRussianEnvelope().maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(new A354_TheIssueOfRussianEnvelope().maxEnvelopes(new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));
    }
}
