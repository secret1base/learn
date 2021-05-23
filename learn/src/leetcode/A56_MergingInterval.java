package leetcode;

import java.util.*;

/**
 * 56.合并区间
 * @author: wyj
 * @date: 2021/05/20
 */
public class A56_MergingInterval {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
     * 回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *  示例 1：
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *  示例 2：
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *  提示：
     *  1 <= intervals.length <= 104
     *  intervals[i].length == 2
     *  0 <= starti <= endi <= 104
     *
     */
    public static void main(String[] args) {
        int[][] merge = new A56_MergingInterval().merge(new int[][]{{1,4},{4,5}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public int[][] merge(int[][] intervals) {
        /**
         * [2,3][1,3][4,5][1,2]
         * 先排序
         * [1,2][1,3][2,3][4,5]
         * 举例:[1,2][1,3]left=left2时，right<right2时right=right2
         * 一旦left!=left2则是下一个区间
         */
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0]<o2[0]){
                return -1;
            }else if(o1[0]==o2[0]){
                if(o1[1]<o2[1]){
                    return - 1;
                }else if (o1[1] == o2[1]) {
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        });
//        for (int[] interval : intervals) {
//            System.out.println(Arrays.toString(interval));
//        }
        List<int[]> list=new ArrayList<>();
        int left=intervals[0][0];
        int right=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=right){
                //当前区间i的左区间小于right则区间有交集，更新right，right去两个区间中右区间的最大值
                right=Math.max(right,intervals[i][1]);
            }else{
                list.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        list.add(new int[]{left,right});
        int[][] res=new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j]=list.get(j);
        }
        return res;
    }
}
