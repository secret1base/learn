package leetcode;

import java.util.Random;

/**
 * 528. 按权重随机选择
 * @author: wyj
 * @date: 2021/07/09
 */
public class A528_RandomSelectionByWeight {
    /**
     * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标
     * i 的概率与 w[i] 成正比。
     *  例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 +
     *  3) = 0.75（即，75%）。
     *  也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
     *  示例 1：
     *  输入：
     * ["Solution","pickIndex"]
     * [[[1]],[]]
     * 输出：
     * [null,0]
     * 解释：
     * Solution solution = new Solution([1]);
     * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
     *  示例 2：
     *  输入：
     * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
     * [[[1,3]],[],[],[],[],[]]
     * 输出：
     * [null,1,1,1,1,0]
     * 解释：
     * Solution solution = new Solution([1, 3]);
     * solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
     * solution.pickIndex(); // 返回 1
     * solution.pickIndex(); // 返回 1
     * solution.pickIndex(); // 返回 1
     * solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
     * 由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
     * [null,1,1,1,1,0]
     * [null,1,1,1,1,1]
     * [null,1,1,1,0,0]
     * [null,1,1,1,0,1]
     * [null,1,0,1,0,0]
     *
     * 直接解出
     * 			执行耗时:172 ms,击败了5.05% 的Java用户
     * 			内存消耗:43 MB,击败了84.44% 的Java用户
     */
    int sum=0;
    int[][] pos=null;
    public A528_RandomSelectionByWeight(int[] w) {
        //1,3的区间应该为 [0,1) [1,4)
        int left=0;
        pos=new int[w.length][2];
        for (int i=0;i<w.length;i++) {
            pos[i][0]=left;
            pos[i][1]=left+w[i];
            left=left+w[i];
            sum+=w[i];
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int i = random.nextInt(sum);
        for (int a=0;a<pos.length ;a++) {
            int[] po = pos[a];
            int left = po[0];
            int right = po[1];
            if(i>=left&&i<right){
                return a;
            }
        }
        return -1;
    }
}
