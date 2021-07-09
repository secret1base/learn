package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 442. 数组中重复的数据
 * @author: wyj
 * @date: 2021/06/24
 */
public class A442_DuplicateDataInArray {
    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     *  找到所有出现两次的元素。
     *  你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     *  示例：
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [2,3]
     *
     * 执行耗时:23 ms,击败了9.73% 的Java用户
     * 内存消耗:47.1 MB,击败了79.69% 的Java用户
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer orDefault = map.get(nums[i]);
            if(orDefault!=null){
                list.add(nums[i]);
            }else{
                map.put(nums[i], 1);
            }
        }
        return list;
    }
}
