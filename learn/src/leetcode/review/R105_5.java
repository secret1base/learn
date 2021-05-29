package leetcode.review;

import leetcode.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyj
 * @date: 2021/05/30
 */
public class R105_5 {
    /**
     * 		执行耗时:3 ms,击败了68.14% 的Java用户
     * 		内存消耗:38.7 MB,击败了36.22% 的Java用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preSt=0;
        int preEnd=preorder.length-1;
        int inSt=0;
        int inEnd=inorder.length-1;
        Map<Integer,Integer> inMap=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preSt,preEnd,inSt,inEnd,preorder,inMap);
    }

    private TreeNode build(int preSt, int preEnd, int inSt, int inEnd, int[] preorder, Map<Integer, Integer> inMap) {
        int rootValue = preorder[preSt];
        TreeNode root=new TreeNode(rootValue);
        Integer inRootIndex = inMap.get(rootValue);
        int leftSize=inRootIndex-inSt;
        int rightSize=inEnd-inRootIndex;
        if(leftSize>0){
            root.left=build(preSt+1,preSt+leftSize,inSt,inRootIndex-1,preorder,inMap);
        }
        if(rightSize>0){
            root.right=build(preSt+leftSize+1,preEnd,inRootIndex+1,inEnd,preorder,inMap);
        }
        return root;

    }
}
