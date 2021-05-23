package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyj
 * @date: 2021/05/23
 */
public class R144_1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        doWrite(root,list);
        return list;
    }

    private void doWrite(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        doWrite(root.left,list);
        doWrite(root.right, list);
    }
}
