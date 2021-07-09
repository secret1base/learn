package leetcode;

import leetcode.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * @author: wyj
 * @date: 2021/06/29
 */
public class A106_ConstructBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences {
    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *  注意:
     * 你可以假设树中没有重复的元素。
     *  例如，给出
     *  中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     *  返回如下的二叉树：
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 		执行耗时:3 ms,击败了68.12% 的Java用户
     * 		内存消耗:38.1 MB,击败了95.45% 的Java用户
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        int inSt=0;
        int inEnd=inorder.length-1;
        int poSt=0;
        int poEnd=postorder.length - 1;
        return createTree(inSt,inEnd,poSt,poEnd,inMap,postorder);
    }

    private TreeNode createTree(int inSt, int inEnd, int poSt, int poEnd, Map<Integer, Integer> inMap, int[] postorder) {
        int rootValue = postorder[poEnd];
        Integer inRootIndex = inMap.get(rootValue);
        TreeNode root=new TreeNode(rootValue);
        int leftSize=inRootIndex-inSt;
        if(leftSize>0){
            root.left=createTree(inSt,inRootIndex-1,poSt,poSt+leftSize-1,inMap,postorder);
        }
        int rightSize=inEnd-inRootIndex;
        if(rightSize>0){
            root.right=createTree(inRootIndex+1,inEnd,poSt+leftSize,poEnd-1,inMap,postorder);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] inorder=new int[]{9,3,15,20,7};
        int[] postorder=new int[]{9,15,7,20,3};
        /**
         *    3
         *  9   15
         *          20
         *              7
         */
        TreeNode node = new A106_ConstructBinaryTreeFromMiddleOrderAndPostOrderTraversalSequences().buildTree(inorder, postorder);
        System.out.println("s");
    }
}
