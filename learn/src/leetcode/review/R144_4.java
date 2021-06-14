package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R144_4 {
    //		执行耗时:0 ms,击败了100.00% 的Java用户
    //		内存消耗:36.8 MB,击败了36.03% 的Java用户
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        record(root,list);
        return list;
    }

    private void record(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        record(root.left, list);
        record(root.right, list);
    }
}
