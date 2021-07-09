package leetcode;

import leetcode.tool.TreeNode;

/**
 * 100. 相同的树
 * @author: wyj
 * @date: 2021/06/29
 */
public class A100_TheSameTree {
    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     *  如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *  示例 1：
     * 输入：p = [1,2,3], q = [1,2,3]
     * 输出：true
     *  示例 2：
     * 输入：p = [1,2], q = [1,null,2]
     * 输出：false
     *  示例 3：
     * 输入：p = [1,2,1], q = [1,1,2]
     * 输出：false
     * 一次过，better and better
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:35.7 MB,击败了70.12% 的Java用户
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //一旦有一处不一致，就是不一致
        return validate(p,q);
    }

    private boolean validate(TreeNode p, TreeNode q) {
        if(p!=null&&q!=null){
            return p.val==q.val&&validate(p.left,q.left)&&validate(p.right,q.right);
        }else if(p != null||q!=null){
            return false;
        }else{
            return true;
        }
    }
}
