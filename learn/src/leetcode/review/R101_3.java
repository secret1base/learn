package leetcode.review;

import leetcode.tool.TreeNode;

/**
 * @author: wyj
 * @date: 2021/06/09
 */
public class R101_3 {
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
    //		执行耗时:0 ms,击败了100.00% 的Java用户
    //		内存消耗:36.3 MB,击败了85.06% 的Java用户
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return false;
        }
        return check(root.left,root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val==right.val&&check(left.left,right.right)&&check(left.right,right.left);
    }
}
