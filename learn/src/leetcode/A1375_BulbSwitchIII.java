package leetcode;

/**
 * 1375. 灯泡开关 III
 * @author: wyj
 * @date: 2021/09/08
 */
public class A1375_BulbSwitchIII {
    /**
     * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。
     *  在 k 时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。
     *  灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：
     *  灯处于打开状态。
     *  排在它之前（左侧）的所有灯也都处于打开状态。
     *  请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。
     *  示例 1：
     *  输入：light = [2,1,3,5,4]
     * 输出：3
     * 解释：所有开着的灯都变蓝的时刻分别是 1，2 和 4 。
     *  示例 2：
     *  输入：light = [3,2,4,1,5]
     * 输出：2
     * 解释：所有开着的灯都变蓝的时刻分别是 3 和 4（index-0）。
     *  示例 3：
     *  输入：light = [4,1,2,3]
     * 输出：1
     * 解释：所有开着的灯都变蓝的时刻是 3（index-0）。
     * 第 4 个灯在时刻 3 变蓝。
     *  示例 4：
     *  输入：light = [2,1,4,3,6,5]
     * 输出：3
     *  示例 5：
     *  输入：light = [1,2,3,4,5,6]
     * 输出：6
     *  提示：
     *  n == light.length
     *  1 <= n <= 5 * 10^4
     *  light 是 [1, 2, ..., n] 的一个排列。
     *  Related Topics 数组
     *
     *  读题花了十分钟，没看懂意思，
     *  解题注意每次校验时取当前开的灯的最大的序号，作为遍历的结束节点，中间一旦有灯没开，则不能变蓝
     *  		执行耗时:741 ms,击败了5.05% 的Java用户
     * 			内存消耗:47 MB,击败了85.35% 的Java用户
     */
    public int numTimesAllBlue(int[] light) {
        boolean[] array=new boolean[light.length+1];
        int count=0;
        int max=0;
        for (int i = 0; i < light.length; i++) {
            int a = light[i];
            max=Math.max(max,a);
            array[a]=true;
            boolean flag=true;
            //所有开着的灯必须是连续的,一旦一个没开，就不能变蓝色
            for (int j = 1; j < max; j++) {
                if(!array[j]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new A1375_BulbSwitchIII().numTimesAllBlue(new int[]{2,1,3,5,4});
        System.out.println(i);
    }
}
