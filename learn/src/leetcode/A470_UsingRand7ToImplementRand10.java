package leetcode;

import java.util.Random;

/**
 * 470.用 Rand7() 实现 Rand10()
 * @author: wyj
 * @date: 2021/05/25
 */
public class A470_UsingRand7ToImplementRand10 {
    /**
     * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
     *  不要使用系统的 Math.random() 方法。
     *  示例 1:
     * 输入: 1
     * 输出: [7]
     *  示例 2:
     * 输入: 2
     * 输出: [8,4]
     *  示例 3:
     * 输入: 3
     * 输出: [8,1,10]
     * @return
     */
    /**
     * 470.md
     * 			执行耗时:24 ms,击败了6.72% 的Java用户
     * 			内存消耗:43.4 MB,击败了72.28% 的Java用户
     * @return
     */
    public int rand10() {
        int num=11;
        while (num>10){
            num=(rand7()-1)*7+rand7();
        }
        return num;
    }
    public int rand7(){
        Random random = new Random();
        return random.nextInt(7)+1;
    }

    public static void main(String[] args) {
        while (true){
            System.out.println(new A470_UsingRand7ToImplementRand10().rand10());
        }
    }

}
