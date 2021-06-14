package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/06/08
 */
public class R105_6 {
    /**
     * 			执行耗时:3 ms,击败了68.01% 的Java用户
     * 			内存消耗:38.3 MB,击败了84.58% 的Java用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preSt=0;
        int preEnd=preorder.length-1;
        int inSt=0;
        int inEnd=inorder.length - 1;
        Map<Integer,Integer> inMap=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preSt,preEnd,inSt,inEnd,inMap,preorder);
    }

    private TreeNode build(int preSt, int preEnd, int inSt, int inEnd, Map<Integer, Integer> inMap, int[] preorder) {
        int rootValue = preorder[preSt];
        TreeNode root=new TreeNode(rootValue);
        Integer inRootIndex = inMap.get(rootValue);
        int leftSize=inRootIndex-inSt;
        if(leftSize>0){
            root.left=build(preSt+1,preSt+leftSize,inSt,inRootIndex-1,inMap,preorder);
        }
        int rightSize=inEnd-inRootIndex;
        if(rightSize > 0){
            root.right=build(preSt+leftSize+1,preEnd,inRootIndex+1,inEnd,inMap,preorder);
        }
        return root;
    }
}
