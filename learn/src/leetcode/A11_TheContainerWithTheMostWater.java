package leetcode;

/**
 * 11. 盛最多水的容器
 * @author: wyj
 * @date: 2021/04/22
 */
public class A11_TheContainerWithTheMostWater {
    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器。
     * 11.jpg
     * 示例 1：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     * 输入：height = [1,1]
     * 输出：1
     * 示例 3：
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     * 示例 4：
     * 输入：height = [1,2,1]
     * 输出：2
     * 提示：
     * n = height.length
     * 2 <= n <= 3 * 104
     * 0 <= height[i] <= 3 * 104
     */
    public static void main(String[] args) {
        int i = new A11_TheContainerWithTheMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(i);
    }

    /**
     * 第二次解答
     * 说明：n次
     * 声明左右指针left、right向中间进行寻找，声明max最大值
     * 比较左右哪边是短板，根据短板计算面积取最大值，下一步是哪边是短板哪边进行移动，
     * 一直到不满足left<right的条件为止结束循环
     * 执行用时：3 ms, 在所有 Java 提交中击败了94.41%的用户
     * 内存消耗：52 MB, 在所有 Java 提交中击败了26.74%的用户
     */
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while (left<right){
            int a = height[left];
            int b=height[right];
            if(a<b){
                max= Math.max(a*(right-left),max);
                left++;
            }else{
                max= Math.max(b*(right-left),max);
                right--;
            }
        }
        return max;
    }

//    /**
//     * 第一次解答
//     * 说明：暴力破解遍历所有情况比较最大值：n*n次
//     * 答案是对的但是被判超时了
//     */
//    public int maxArea(int[] height) {
//        int max=0;
//        for(int a=0;a<height.length;a++){
//            for (int b=a+1;b<height.length;b++){
//                //取两个板子中的短板作为高
//                int minHigh= height[a]<height[b]?height[a]:height[b];
//                int nowArea = minHigh * (b - a);
//                max=nowArea>max?nowArea:max;
//            }
//        }
//        return max;
//    }
}
