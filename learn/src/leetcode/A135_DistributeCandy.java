package leetcode;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * @author: wyj
 * @date: 2021/06/30
 */
public class A135_DistributeCandy {
    /**
     * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     *  你需要按照以下要求，帮助老师给这些孩子分发糖果：
     *  每个孩子至少分配到 1 个糖果。
     *  评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
     *  那么这样下来，老师至少需要准备多少颗糖果呢？
     *  示例 1：
     * 输入：[1,0,2]
     * 输出：5
     * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
     *  示例 2：
     * 输入：[1,2,2]
     * 输出：4
     * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
     *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
     *
     *      	执行耗时:3 ms,击败了64.34% 的Java用户
     * 			内存消耗:39.5 MB,击败了53.07% 的Java用户
     */
    public int candy(int[] ratings) {
        //每个必须有一个，如果一个小孩的评分比左右两侧中但凡一侧的评分高，就必须拿到更多的糖果，不然只可以拿一个
        //122 121
        //1221 1221 先左侧比较 1211 再右侧比较 1221
        //1234 1234
        //4321 4321
        int[] store=new int[ratings.length];
        Arrays.fill(store, 1);
        //分别从左到右和从右到左进行一次比较即可，
        //从右到左比较时需要注意虽然都是当前值比上一个值小时当前值store[i]=store[上一个]+1，
        //但是如果当前值store[i]本来就比store[上一个]大就不需要进行+1
        //从左
        for (int i = 0; i < ratings.length; i++) {
            //比较
            if(i>0&&ratings[i]>ratings[i-1]){
                store[i]=store[i-1]+1;
            }
        }
        //从右
        for (int i = ratings.length - 1; i >=0; i--) {
            //当前值比上一个值大，且store[i]<=store[i+1](如果i>i+1则本身就算是处理过的)，则当前值为上一个值+1
            if(i+1<ratings.length&&ratings[i]>ratings[i+1]&&store[i]<=store[i+1]){
                store[i]=store[i+1]+1;
            }
        }
//        System.out.println(Arrays.toString(store));
        int sum=0;
        for (int i : store) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
//        int candy = new A135_DistributeCandy().candy(new int[]{1,3,4,5,2});
//        System.out.println(candy);//11
        int candy = new A135_DistributeCandy().candy(new int[]{1,0,2});
        System.out.println(candy);//5
        //1,3,4,5,2
        //12341
    }
}
