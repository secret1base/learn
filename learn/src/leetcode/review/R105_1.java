package leetcode.review;

import leetcode.A105_ConstructingBinaryTreeFromPreorderAndMesorderTraversalSequences;
import leetcode.A144_PreorderTraversalOfBinaryTree;
import leetcode.tool.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/05/21
 */
public class R105_1 {
    public static void main(String[] args) {
        TreeNode node = new R105_1()
                .buildTree(new int[]{3, 9, 5, 11, 20, 15, 7}, new int[]{5, 9, 11, 3, 15, 20, 7});
        List<Integer> list = new A144_PreorderTraversalOfBinaryTree().preorderTraversal(node);
        System.out.println(list);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
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
        int rootValue = preorder[preSt];
        TreeNode root=new TreeNode(rootValue);
        int inRootIndex=inMap.get(rootValue);
        int leftSize=inRootIndex-inSt;
        int rightSize=preEnd-preSt-leftSize;
        if(leftSize>0){
            root.left=build(preSt+1,preSt+leftSize,inSt,inRootIndex-1,preorder,inMap);
        }
        if(rightSize>0){
            root.right=build(preSt+leftSize+1,preEnd,inRootIndex+1,inEnd,preorder,inMap);
        }
        return root;
    }
}
