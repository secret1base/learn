package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/05/31
 */
public class R101_2 {
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.4 MB,击败了66.28% 的Java用户
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return check(root.left,root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left);
    }
}
