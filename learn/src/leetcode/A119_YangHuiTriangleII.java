package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * @author: wyj
 * @date: 2021/07/19
 */
public class A119_YangHuiTriangleII {
    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *  在杨辉三角中，每个数是它左上方和右上方的数的和。
     *  示例:
     *  输入: 3
     * 输出: [1,3,3,1]
     * 			执行耗时:2 ms,击败了43.91% 的Java用户
     * 			内存消耗:36.5 MB,击败了8.64% 的Java用户
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        if(rowIndex==0){
            return list;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> tmp=new ArrayList<>();
            for (int j = 0; j <= list.size(); j++) {
                if(j==0||list.size()==j){
                    tmp.add(1);
                }else{
                    tmp.add(list.get(j-1)+list.get(j));
                }
            }
            list=tmp;
        }
        return list;
    }
}
