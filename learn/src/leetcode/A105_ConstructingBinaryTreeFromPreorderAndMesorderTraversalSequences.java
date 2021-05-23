package leetcode;

import leetcode.tool.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 105.从前序与中序遍历序列构造二叉树
 * @author: wyj
 * @date: 2021/05/21
 */
public class A105_ConstructingBinaryTreeFromPreorderAndMesorderTraversalSequences {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *  注意:
     * 你可以假设树中没有重复的元素。
     *  例如，给出
     *  前序遍历 preorder = [3, 9, 5, 11, 20, 15, 7]
     *  中序遍历 inorder =  [5, 9, 11, 3, 15, 20, 7]
     *
     *  返回如下的二叉树：
     *
     *        3
     *     /    \
     *    9     20
     *   / \    /  \
     *  5   11 15   7
     */
    public static void main(String[] args) {
        TreeNode node = new A105_ConstructingBinaryTreeFromPreorderAndMesorderTraversalSequences()
                .buildTree(new int[]{3, 9, 5, 11, 20, 15, 7}, new int[]{5, 9, 11, 3, 15, 20, 7});
        List<Integer> list = new A144_PreorderTraversalOfBinaryTree().preorderTraversal(node);
        System.out.println(list);
    }

    /**
     * 注意每次构建树时，前序序列和中序序列的索引区间
     * 			执行耗时:2 ms,击败了98.49% 的Java用户
     * 			内存消耗:38.9 MB,击败了20.07% 的Java用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null||preorder.length == 0){
            return null;
        }
        Map<Integer,Integer> inMap=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        int preSt=0;
        int preEnd=preorder.length-1;
        int inSt=0;
        int inEnd=inorder.length - 1;
        return build(preSt,preEnd,inSt,inEnd,preorder,inMap);
    }


    private TreeNode build(int preSt, int preEnd, int inSt, int inEnd, int[] preorder, Map<Integer, Integer> inMap) {
        //前序序列中的第一个节点是根节点
        int rootValue = preorder[preSt];
        TreeNode root=new TreeNode(rootValue);
        //中序序列中根节点的位置
        Integer inRootIndex = inMap.get(rootValue);
        //左子节点数量
        int leftSize = inRootIndex - inSt;
        //右子节点数量
        int rightSize = preEnd - preSt - leftSize;
        if(leftSize>0){
            //当前节点的左子节点将作为根节点
            /**
             *  前序遍历 preorder = [3, 9, 5, 11, 20, 15, 7]
             *  中序遍历 inorder =  [5, 9, 11, 3, 15, 20, 7]
             *  9
             */
            root.left= build(preSt+1,preSt+leftSize,inSt,inRootIndex-1,preorder,inMap);
        }
        if(rightSize > 0){
            //当前节点的右子节点将作为根节点
            /**
             *  前序遍历 preorder = [3, 9, 5, 11, 20, 15, 7]
             *  中序遍历 inorder =  [5, 9, 11, 3, 15, 20, 7]
             *  20
             */
            root.right=build(preSt+leftSize+1,preEnd,inRootIndex+1,inEnd,preorder,inMap);
        }
        return root;
    }


}
