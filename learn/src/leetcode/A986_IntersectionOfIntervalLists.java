package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986. 区间列表的交集
 * @author: wyj
 * @date: 2021/07/16
 */
public class A986_IntersectionOfIntervalLists {
    /**
     * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 s
     * econdList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
     *  返回这 两个区间列表的交集 。
     *  形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
     *  两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
     *  示例 1：
     * 输入：firstList =
     * [[0,2],[5,10],[13,23],[24,25]], secondList =
     * [[1,5],[8,12],[15,24],[25,26]]
     * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     *  示例 2：
     * 输入：firstList = [[1,3],[5,9]], secondList = []
     * 输出：[]
     *  示例 3：
     * 输入：firstList = [], secondList = [[4,8],[10,12]]
     * 输出：[]
     *  示例 4：
     * 输入：firstList = [[1,7]], secondList = [[3,10]]
     * 输出：[[3,7]]
     *  提示：
     *  0 <= firstList.length, secondList.length <= 1000
     *  firstList.length + secondList.length >= 1
     *  0 <= starti < endi <= 109
     *  endi < starti+1
     *  0 <= startj < endj <= 109
     *  endj < startj+1
     *
     *  		执行耗时:30 ms,击败了5.25% 的Java用户
     * 			内存消耗:39.3 MB,击败了71.44% 的Java用户
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < firstList.length; i++) {
            for (int j = 0; j < secondList.length; j++) {
                int left = firstList[i][0];
                int right = firstList[i][1];
                int l = secondList[j][0];
                int r = secondList[j][1];
                if(l<=right&&left<=l){
                    //0,2  1,5
                    list.add(new int[]{l,right<r?right:r});
                }else if(left>=l&&left<=r){
                    //1,5  0,2
                    list.add(new int[] {left, right<r?right:r});
                }
            }
        }
        int[][] arr=new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] ints = new A986_IntersectionOfIntervalLists().intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
