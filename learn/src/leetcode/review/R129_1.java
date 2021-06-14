package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R129_1 {
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25
// 示例 2：
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
    //			执行耗时:2 ms,击败了9.61% 的Java用户
//			内存消耗:35.9 MB,击败了57.37% 的Java用户
    public int sumNumbers(TreeNode root) {
        //记录所有路径
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return 0;
        }
        Deque<Integer> path=new LinkedList<>();
        path.offerLast(root.val);
        record(root,path,list);
        int sum=0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    private void record(TreeNode root, Deque<Integer> path, List<Integer> list) {
        if(root.left==null&&root.right==null){
            ArrayList<Integer> ll = new ArrayList<>(path);
            StringBuilder s=new StringBuilder();
            for (Integer integer : ll) {
                s.append(integer);
            }
            list.add(Integer.parseInt(s.toString()));
        }
        if(root.left!=null){
            path.offerLast(root.left.val);
            record(root.left,path,list);
            path.pollLast();
        }
        if(root.right!=null){
            path.offerLast(root.right.val);
            record(root.right,path,list);
            path.pollLast();
        }

    }
}
