package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/06/02
 */
public class R94_3 {
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.9 MB,击败了19.10% 的Java用户
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        doRecord(root,list);
        return list;
    }

    private void doRecord(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        doRecord(root.left,list);
        list.add(root.val);
        doRecord(root.right,list);
    }
}
