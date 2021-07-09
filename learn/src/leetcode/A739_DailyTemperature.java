package leetcode;

import java.util.Arrays;

/**
 * 739. 每日温度
 * @author: wyj
 * @date: 2021/06/23
 */
public class A739_DailyTemperature {
    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     *  例如，给定一个列表
     *  temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
     *  你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     *  		执行耗时:366 ms,击败了20.16% 的Java用户
     * 			内存消耗:52.8 MB,击败了5.01% 的Java用户
     */
    public int[] dailyTemperatures(int[] temperatures) {
        //用于过滤一部分的查询
        int[] right=new int[temperatures.length];
        for (int i = temperatures.length-1; i >=0; i--) {
            if(i==temperatures.length - 1){
                right[i] = temperatures[i];
            }else{
                right[i] = Math.max(temperatures[i],right[i+1]);
            }
        }
        int[] arr=new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if(temperatures[i]<right[i]){
                int a = temperatures[i];
                int k=i+1;
                while (temperatures[k]<=a){
                    k++;
                }
                arr[i]=k-i;
            }else{
                arr[i]=0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = new A739_DailyTemperature().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
}
