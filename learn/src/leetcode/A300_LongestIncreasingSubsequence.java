package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 300.最长递增子序列
 * @author: wyj
 * @date: 2021/05/18
 */
public class A300_LongestIncreasingSubsequence {
    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *  子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
     * 列。
     *  示例 1：
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     *  示例 2：
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     *  示例 3：
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *  提示：
     *  1 <= nums.length <= 2500
     *  -104 <= nums[i] <= 104
     */
    public static void main(String[] args) {
        int i = new A300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,200,18,101,102,103});
        System.out.println(i);
    }

    /**
     * 解题思路:
     * 300.xls
     * 			执行耗时:72 ms,击败了71.47% 的Java用户
     * 			内存消耗:38 MB,击败了74.89% 的Java用户
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        /**
         * 解题思路
         * nums 10,9,2,5,3,7,101
         * //每个节点存储以对应所以位置的最长递增子序列长度
         * store=new int[nums.length]
         * store[0]:10
         * 存储	1
         * store[1]:9
         * 存储	1
         * store[2]:2
         * 存储	1
         * store[3]:5
         * 	从前往后找，找到nums[j]<nums[3]的值，取其中最大的值进行加1
         * 	只找到nums[2]=2，store[2]+1
         * 	存储	2
         * store[4]:3
         * 	从前往后找，找到nums[j]<nums[4]的值，取其中最大的值进行加1
         * 	当前nums=3
         * 	只找到nums[2]=,store[2]+1=>2
         * 	存储2
         * store[5]:7
         * 	从前往后找，找到nums[j]<7的值，取其中最大的值进行加1
         * 	找到
         * 	找到2,5,3都比7小，对应下标为2,3,4
         * 	store[2]=1
         * 	store[3]=2
         * 	store[4]=2
         * 	最大值为2，2+1
         * 	存储3
         * store[6]:101
         * 	从前往后找，找到nums[j]<101的值，取其中最大的值进行加1
         * 	找到
         * 	找到10,9,2,5,3,7都比101小，对应下标为0,1,2,3,4,5
         * 	store[0]=1
         * 	store[1]=1
         * 	store[2]=1
         * 	store[3]=2
         * 	store[4]=2
         * 	store[5]=3
         * 	最大值为3，3+1
         * 	存储4
         */
        int[] store=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //初始第i位的值为1
            store[i]=1;
            for (int j=0;j<i;j++){
//                从前往后找，找到nums[j]<101的值，取其中最大的值进行加1
                if(nums[j]<nums[i]){
                    store[i]=Math.max(store[i],store[j]+1);
                }
            }
        }
        int max=0;
        for (int j = 0; j < store.length; j++) {
            max=Math.max(store[j],max);
        }
        return max;
    }
    /**
     * 第一次解题，结果正确，运行超时
     * @param nums
     * @return
     */
    public int firstLengthOfLIS(int[] nums) {
        //由于存在：1267345,暴力破解,递归删除，每次删除后检查一遍，如果是递增的则返回,不是则继续删除
        List<Integer> list=new ArrayList<>();
        for (Integer i : nums) {
            list.add(i);
        }
        if(validateAdd(list)){
            return list.size();
        }
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            max= Math.max(doRemove(i,new ArrayList<>(list)),max);
        }
        return max;
    }

    private int doRemove(int i, List<Integer> list) {
        list.remove(i);
        //校验是否为递增
        if(validateAdd(list)){
            //是，返回长度，不需要继续删除
            return list.size();
        }else{
            //不是，继续删除
            int max=1;
            for (int j = 0; j < list.size(); j++) {
                int a = doRemove(j, new ArrayList<>(list));
                if(a==list.size()-1){
                    //这里最理想的结果就是只减去一个就符合递增序列，不可能有更长的了，通过这处代码进行剪枝
                    return a;
                }
                max=Math.max(max,a);
            }
            return max;
        }
    }

    private boolean validateAdd(List<Integer> list) {
        for (int j = 0; j < list.size()-1; j++) {
            if(list.get(j)>=list.get(j+1)){
                //不符合递增要求
                return false;
            }
        }
        return true;
    }
}
