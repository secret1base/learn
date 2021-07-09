package leetcode;

import leetcode.tool.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * @author: wyj
 * @date: 2021/06/29
 */
public class A450_DeleteTheNodesInTheBinarySearchTree {
    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
     * 根节点的引用。
     *  一般来说，删除节点可分为两个步骤：
     *  首先找到需要删除的节点；
     *  如果找到了，删除它。
     *  说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     *  示例:
     * root = [5,3,6,2,4,null,7]
     * key = 3
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     *     5
     *    / \
     *   4   6
     *  /     \
     * 2       7
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     *     5
     *    / \
     *   2   6
     *    \   \
     *     4   7
     */
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.8 MB,击败了77.55% 的Java用户
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        int i = Integer.compare(root.val,key);
        if(i>0){
            root.left=deleteNode(root.left,key);
        }else if(i<0){
            root.right=deleteNode(root.right,key);
        }else{
            //删除本节点
            //1、找到能够替代的节点
            if(root.right==null){
                //没有右子节点则用左子节点
                return root.left;
            }
            if(root.left==null){
                //没有左子节点则用右子节点
                return root.right;
            }
            //左右子树都不为空
            //左子树放到右子树的最左子树下面
            TreeNode left = root.left;
            TreeNode right = root.right;
            while (right.left!=null){
                right=right.left;
            }
            right.left=left;
            //返回右子树
            return root.right;
        }
        return root;
    }

//    /**
//     * 错误的解法
//     */
//    private TreeNode deleteNode(TreeNode root, int key) {
//        if(root==null){
//            return null;
//        }
//        if(root.val>key){
//            root.left=deleteNode(root.left,key);
//            return root;
//        }else if(root.val<key){
//            root.right=deleteNode(root.right,key);
//            return root;
//        }else{
//            //找到右节点最小的左节点
//            if(root.right!=null){
//                //两种情况右节点没有左节点时，右节点本身作为父结点使用
//                //有左节点时，左节点连接右节点，右节点断开左节点
//                TreeNode right = root.right;
//                if(right.left==null){
//                    right.left=root.left;
//                    return right;
//                }
//                TreeNode preNode=right;
//                TreeNode left = right.left;
//                while (left.left!=null){
//                    left=left.left;
//                    preNode=preNode.left;
//                }
//                //断开
//                preNode.left=null;
//                left.right=root.right;
//                left.left=root.left;
//                return left;
//            }else{
//                return root.left;
//            }
//        }
//    }
}
