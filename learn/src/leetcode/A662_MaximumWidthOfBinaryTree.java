package leetcode;

import leetcode.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 662. 二叉树最大宽度
 * @author: wyj
 * @date: 2021/06/22
 */
public class A662_MaximumWidthOfBinaryTree {
    /**
     * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
     *  每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     *  示例 1:
     * 输入:
     *
     *            1
     *          /   \
     *         3     2
     *        / \     \
     *       5   3     9
     * 输出: 4
     * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
     *  示例 2:
     * 输入:
     *           1
     *          /
     *         3
     *        / \
     *       5   3
     *
     * 输出: 2
     * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
     *  示例 3:
     * 输入:
     *           1
     *          / \
     *         3   2
     *        /
     *       5
     * 输出: 2
     * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
     *  示例 4:
     * 输入:
     *
     *           1
     *          / \
     *         3   2
     *        /     \
     *       5       9
     *      /         \
     *     6           7
     * 输出: 8
     * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
     *  注意: 答案在32位有符号整数的表示范围内。
     */
    /**
     * 在超时解答的基础上进行改造，val中存储当前的位置(堆的思维)
     * 		执行耗时:1 ms,击败了99.96% 的Java用户
     * 		内存消耗:38.1 MB,击败了43.19% 的Java用户
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Deque<TreeNode> path=new LinkedList<>();
        root.val=1;
        path.offerLast(root);
        int max=0;
        while (!path.isEmpty()){
            max=Math.max(max,path.peekLast().val-path.peekFirst().val+1);
            //遍历出所有下一层的节点
            int size = path.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = path.pollFirst();
                if(node.left!=null){
                    node.left.val=node.val*2;
                    path.offerLast(node.left);
                }
                if(node.right!=null){
                    node.right.val=node.val*2+1;
                    path.offerLast(node.right);
                }
            }
        }
        return max;
    }
//    /**
//     * 超时解答
//     * @param root
//     * @return
//     */
//    public int widthOfBinaryTree(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        Deque<TreeNode> path=new LinkedList<>();
//        path.offerLast(root);
//        int max=0;
//        while (!path.isEmpty()){
//            //计算宽度
//            while (!path.isEmpty()&&(path.peekFirst()==null||path.peekLast()==null)){
//                if(path.peekFirst()==null){
//                    path.pollFirst();
//                }
//                if(path.peekLast()==null){
//                    path.pollLast();
//                }
//            }
//            max=Math.max(max,path.size());
//            //遍历出所有下一层的节点
//            int size = path.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = path.pollFirst();
//                if(node!=null){
//                    path.offerLast(node.left);
//                    path.offerLast(node.right);
//                }else{
//                    //null元素补null
//                    path.offerLast(null);
//                    path.offerLast(null);
//                }
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        TreeNode a1=new TreeNode(1);
        TreeNode a3=new TreeNode(3);
        TreeNode a2=new TreeNode(2);
        TreeNode a5=new TreeNode(5);
        TreeNode a9=new TreeNode(9);
        TreeNode a6=new TreeNode(6);
        TreeNode a7=new TreeNode(7);
        a1.left=a3;
        a1.right=a2;
        a3.left=a5;
        a5.left=a6;
        a2.right=a9;
        a9.right=a7;
        int i = new A662_MaximumWidthOfBinaryTree().widthOfBinaryTree(a1);//8
        System.out.println(i);
    }
}
