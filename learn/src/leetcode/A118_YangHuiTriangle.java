package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * @author: wyj
 * @date: 2021/07/14
 */
public class A118_YangHuiTriangle {
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *  在杨辉三角中，每个数是它左上方和右上方的数的和。
     *  示例:
     *  输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     *
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.1 MB,击败了87.57% 的Java用户
     */
    public List<List<Integer>> generate(int numRows) {
        /**
         *      [1],
         *     [1,1],
         *    [1,2,1], 2:下标1 =下标0+下标1
         *   [1,3,3,1], 3：下标1=下标0+下标1 3：下标2=下标1+下标2
         *  [1,4,6,4,1]
         */
        List<List<Integer>> list=new ArrayList<>();
        if(numRows==0){
            return list;
        }
        List<Integer> one=new ArrayList<>();
        one.add(1);
        list.add(one);
        for (int i = 1; i < numRows; i++) {
            //获取上一行
            List<Integer> pre = list.get(i - 1);
            List<Integer> curr=new ArrayList<>();
            for (int j = 0; j < pre.size()+1;j++){
                //第一个和最后一个都需要特殊处理,根据规律直接赋值为1即可
                if(j==0||j==pre.size()){
                    curr.add(1);
                    continue;
                }
                curr.add(pre.get(j-1)+pre.get(j));
            }
            list.add(curr);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = new A118_YangHuiTriangle().generate(5);
        for (List<Integer> list : generate) {
            System.out.println(list);
        }
    }
}
