package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 202. 快乐数
 * @author: wyj
 * @date: 2021/07/13
 */
public class A202_HappyNumber {
    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *  「快乐数」定义为：
     *  对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     *  然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     *  如果 可以变为 1，那么这个数就是快乐数。
     *  如果 n 是快乐数就返回 true ；不是，则返回 false 。
     *  示例 1：
     * 输入：19
     * 输出：true
     * 解释：
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     *  示例 2：
     * 输入：n = 2
     * 输出：false
     *  1 <= n <= 231 - 1
     *
     *  		执行耗时:1 ms,击败了99.61% 的Java用户
     * 			内存消耗:35.9 MB,击败了6.72% 的Java用户
     */
    public boolean isHappy(int n) {
        //难点在，什么时候可以结束循环,因此需要借助map，记录每次循环后的值一旦重复就是进入循环了
        Map<Integer,Integer> map=new HashMap<>();
        while (n!=1){
            map.put(n,1);
            String s = Integer.toString(n);
            n=0;
            for (int i = 0; i < s.length();i++){
                int a = s.charAt(i) - '0';
                n+=a*a;
            }
            Integer integer = map.get(n);
            if(integer!=null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A202_HappyNumber().isHappy(19));
    }
}
