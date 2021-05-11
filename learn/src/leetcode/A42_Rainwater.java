package leetcode;

import java.util.Arrays;

/**
 * 42. 接雨水
 * @author: wyj
 * @date: 2021/04/28
 */
public class A42_Rainwater {
    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 示例 1：
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 42.png
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * 提示：
     * n == height.length
     * 0 <= n <= 3 * 104
     * 0 <= height[i] <= 105
     */
    public static void main(String[] args) {
//        int[] ints = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(new A42_Rainwater().trap(ints));//6
//        int[] ints = {4,2,0,3,2,5};
//        System.out.println(new A42_Rainwater().trap(ints));//9
    }
//    /**
//     * 第一次提交：通过类似俄罗斯方块的消去法进行计算，计算超时
//     */
//    public int trap(int[] height) {
//        //通过俄罗斯方块的原理，进行计算
//        //找到最大值作为循环结束
//        int max=0;
//        for (int i : height) {
//            max = Math.max(max, i);
//        }
//        int sum=0;
//        for (int i=0;i<max;i++){
//            //消去底部一层，然后将底部这一层放入tmp中
//            int[] tmp=new int[height.length];
//            for (int a=0;a<height.length; a++){
//                int i1 = height[a];
//                if(i1-1>=0){
//                    tmp[a]=1;
//                    height[a]=i1-1;
//                }else{
//                    tmp[a]=0;
//                    height[a]=0;
//                }
//            }
//            //通过tmp计算
//            int left=0;
//            int right=0;
//            for(int k=0;k<tmp.length; k++){
//                //找到两个1间的凹槽
//                if (tmp[k] == 1) {
//                    while (k+1<tmp.length&&tmp[k]==tmp[k+1]){
//                        k++;
//                    }
//
//                    left=k;
//                    //通过上面这一步可以实现1101时能够将k定位到101左边这个1
//                    //继续向后找right,举例:10001通过下面代码能将k定位到01这里的0
//                    while (k<tmp.length){
//                        while (k+1<tmp.length&&tmp[k+1] == 0){
//                            k++;
//                        }
//                        if(k+1<tmp.length){
//                            right=k+1;
//                            sum+=right-left-1;
//                            k++;
//                            //初始化left
//                            left=k;
//                        }else{
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return sum;
//    }
}
