package leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R56_4 {
    /**
     * 		执行耗时:7 ms,击败了75.74% 的Java用户
     * 		内存消耗:41.2 MB,击败了45.46% 的Java用户
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0]<o2[0]){
                return -1;
            }else if(o1[0]==o2[0]){
                if(o1[1]<o2[1]){
                    return -1;
                }else if(o1[1]==o2[1]){
                    return 0;
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        });
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left=intervals[i][0];
            int right=intervals[i][1];
            for (int j = i+1; j <intervals.length; j++){
                if(right>=intervals[j][1]){
                    i++;
                }else if(right>=intervals[j][0]&&right<=intervals[j][1]){
                    right=intervals[j][1];
                    i++;
                }else{
                    break;
                }
            }
            list.add(new int[]{left,right});
        }
        int[][] res=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
