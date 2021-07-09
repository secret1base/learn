package leetcode;

import leetcode.tool.TreeNode;

/**
 * 572. 另一个树的子树
 * @author: wyj
 * @date: 2021/07/09
 */
public class A572_SubtreeOfAnotherTree {
    /**
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
     * s 也可以看做它自身的一棵子树。
     *  示例 1:
     * 给定的树 s:
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     *  给定的树 t：
     *    4
     *   / \
     *  1   2
     *  返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
     *  示例 2:
     * 给定的树 s：
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     *     /
     *    0
     *  给定的树 t：
     *    4
     *   / \
     *  1   2
     *  返回 false。
     */
    /**
     * 校验子树的方法是从判断树是否为镜像对称树那题中获取的经验
     * 			执行耗时:3 ms,击败了93.02% 的Java用户
     * 			内存消耗:38.3 MB,击败了88.97% 的Java用户
     */
    boolean flag=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        walk(root,subRoot);
        return flag;
    }

    private void walk(TreeNode root, TreeNode subRoot) {
        if(root==null||flag==true){
            return;
        }
        if(root.val==subRoot.val){
            //检查是否为子树
            if(validate(root,subRoot)){
                flag=true;
                return;
            }
        }
        walk(root.left,subRoot);
        walk(root.right,subRoot);
    }

    private boolean validate(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&validate(p.left,q.left)&&validate(p.right,q.right);
    }
}
