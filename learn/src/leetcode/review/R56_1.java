package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R56_1 {
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
// 示例 1：
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0]<o2[0]){
                return -1;
            }else if(o1[0]==o2[0]){
                if(o1[1]<o2[1]){
                    return -1;
                }else if(o1[1] == o2[1]){
                    return 0;
                }else{
                    return 1;
                }
            }else {
                return 1;
            }
        });
        List<int[]> list=new ArrayList<>();
        //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        for (int i = 0; i < intervals.length; i++) {
            int left=intervals[i][0];
            int right=intervals[i][1];
            for (int j = i+1; j < intervals.length; j++) {
                if(right>=intervals[j][0]&&right<=intervals[j][1]){
                    right=intervals[j][1];
                    i++;
                }else if(right > intervals[j][1]){
                    //吃掉
                    i++;
                }else{
                    break;
                }
            }
            list.add(new int[]{left,right});
        }
        int[][] r=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            r[i]=list.get(i);
        }
        return r;
    }
}
