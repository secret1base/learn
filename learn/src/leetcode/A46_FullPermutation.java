package leetcode;

import java.util.*;

/**
 * 46.全排列
 * @author: wyj
 * @date: 2021/05/17
 */
public class A46_FullPermutation {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *  示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *  示例 2：
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     *  示例 3：
     * 输入：nums = [1]
     * 输出：[[1]]
     *  提示：
     *  1 <= nums.length <= 6
     *  -10 <= nums[i] <= 10
     *  nums 中的所有整数 互不相同
     * @param nums
     * @return
     */
    public static void main(String[] args) {
        List<List<Integer>> permute = new A46_FullPermutation().permute(new int[]{1, 2, 3});
        System.out.println("---------------");
        System.out.println(permute);
    }

    /**
     * 			执行耗时:2 ms,击败了54.38% 的Java用户
     * 			内存消耗:38.4 MB,击败了92.55% 的Java用户
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res=new ArrayList<>();
        boolean[] used=new boolean[n];
        //使用栈是为了节省空间，可以进行重复利用
        Stack<Integer> path=new Stack<>();
        dfs(n,res,path,0,used,nums);
        return res;
    }
    /**
     * 深度优先遍历，选值填入，当长度达到最大不进行填值，选值时不能选择已经被选过的
     * 思路与n皇后解法一致
     * 			执行耗时:2 ms,击败了54.38% 的Java用户
     * 			内存消耗:38.4 MB,击败了94.32% 的Java用户
     * @param n 数组长度
     * @param res 存放位置
     * @param path 存储已经使用的元素
     * @param level 记录当前的层数
     * @param used 记录已经使用的元素
     * @param nums 数组
     */
    private void dfs(int n, List<List<Integer>> res, Stack<Integer> path, int level, boolean[] used, int[] nums) {
        if(level==n){
            //到达边界
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            //判断是否被使用
            if(!used[i]){
                //没被使用则可以进行填值
                path.push(nums[i]);
                //标记被使用
                used[i]=true;
                //进入下一个递归
                dfs(n,res,path,level+1,used,nums);
                //递归结束进行回溯
                used[i] = false;
                path.pop();
            }
        }
    }



}
