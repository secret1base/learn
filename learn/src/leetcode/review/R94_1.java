package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R94_1 {
    /**
     * 中序遍历
     *     1
     *   2   3
     * 4  5 6  7
     *
     * 4251637
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        doWrite(root,list);
        return list;
    }

    private void doWrite(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        doWrite(root.left,list);
        list.add(root.val);
        doWrite(root.right, list);
    }
}
