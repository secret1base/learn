package leetcode.review;

/**
 * @author: wyj
 * @date: 2021/05/15
 */
public class R42_1 {
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
    public int trap(int[] height) {
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        int max=0;
        for (int i = 0; i < height.length; i++){
            left[i]=max=Math.max(max,height[i]);
        }
        max=0;
        for (int i = height.length - 1; i >=0; i--){
            right[i]=max=Math.max(max,height[i]);
        }
        int sum=0;
        for (int i = 0; i < height.length; i++) {
            int i1 = Math.min(left[i], right[i]) - height[i];
            if(i1>0){
                sum+=i1;
            }
        }
        return sum;
    }
}
