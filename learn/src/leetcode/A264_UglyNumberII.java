package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 264. 丑数 II
 * @author: wyj
 * @date: 2021/07/12
 */
public class A264_UglyNumberII {
    /**
     * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     *  丑数 就是只包含质因数 2、3 和 5 的正整数。
     *  示例 1：
     * 输入：n = 10
     * 输出：12
     * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
     *  示例 2：
     * 输入：n = 1
     * 输出：1
     * 解释：1 通常被视为丑数。
     *  提示：
     *  1 <= n <= 1690
     *  Related Topics 哈希表 数学 动态规划 堆（优先队列）
     *
     *  应该算动态规划
     *  		执行耗时:2 ms,击败了98.71% 的Java用户
     * 			内存消耗:37.4 MB,击败了74.94% 的Java用户
     */
    public int nthUglyNumber(int n) {
        int[] store=new int[n];
        store[0]=1;
        int a=0;
        int b=0;
        int c=0;
        for (int i=1;i<n;i++){
            int n1=store[a]*2;
            int n2=store[b]*3;
            int n3=store[c]*5;
            store[i] = Math.min(Math.min(n1, n2), n3);
            if(n1==store[i]){
                a++;
            }
            if(n2==store[i]){
                b++;
            }if(n3==store[i]){
                c++;
            }
        }
        return store[n-1];
    }
//
//    /**
//     * 暴力破解生成指定数量个丑数，超时
//     * @param n
//     * @return
//     */
//    public int nthUglyNumber(int n) {
//        List<Integer> validates=new ArrayList<>();
//        validates.add(2);
//        validates.add(3);
//        validates.add(5);
//        List<Integer> list=new ArrayList<>();
//        //把第一个丑数放进去
//        list.add(1);
//        for (int i = 1; i < n; i++) {
//            genarateUglyNumber(list,validates);
//        }
//        return list.get(n-1);
//    }
//
//    /**
//     * 生成一个丑数
//     * @param list
//     * @param validates
//     */
//    private void genarateUglyNumber(List<Integer> list, List<Integer> validates) {
//        Integer init = list.get(list.size() - 1);
//        while (true){
//            init++;
//            //校验是否为丑数
//            int sum=init;
//            boolean flag=true;
//            while (sum!=1){
//                int before=sum;
//                for (Integer integer : validates) {
//                    if(sum%integer==0){
//                        //能被整除
//                        sum/=integer;
//                    }
//                }
//                if(before==sum){
//                    //已经无法除了,没找到
//                    flag=false;
//                    break;
//                }
//            }
//            if(flag){
//                //找到了
//                list.add(init);
//                return;
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new A264_UglyNumberII().nthUglyNumber(10));
    }
}
