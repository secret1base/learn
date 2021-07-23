package leetcode;

import leetcode.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * @author: wyj
 * @date: 2021/07/22
 */
public class A889_ConstructBinaryTreeAccordingToPreorderAndPostorderTraversal {
    /**
     * 返回与给定的前序和后序遍历匹配的任何二叉树。
     *  pre 和 post 遍历中的值是不同的正整数。
     *  示例：
     *  输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
     * 输出：[1,2,3,4,5,6,7]
     *  提示：
     *  1 <= pre.length == post.length <= 30
     *  pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
     *  每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
     *
     *  这题比前序+中序或者后序+中序构造二叉树要难一点
     *  		执行耗时:1 ms,击败了99.33% 的Java用户
     * 			内存消耗:37.5 MB,击败了97.21% 的Java用户
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        //前序：中左右
        //后序：左右中
        int preSt=0;
        int preEnd=pre.length-1;
        int postSt=0;
        int postEnd=post.length-1;
        Map<Integer,Integer> postMap=new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }
        return createTree(preSt,preEnd,postSt,postEnd,pre,postMap);
    }

    private TreeNode createTree(int preSt, int preEnd, int postSt, int postEnd, int[] pre, Map<Integer, Integer> postMap) {
        if(preSt<=preEnd&&postSt<=postEnd){

        }else{
            return null;
        }
        int rootValue = pre[preSt];
        TreeNode root=new TreeNode(rootValue);
        //左分支长度计算
        //找到左分支长度的方法：889.jpg
        if(preSt+1<=preEnd){
            int leftValue = pre[preSt + 1];
            Integer postLeftPosition = postMap.get(leftValue);
            int leftSize = postLeftPosition - postSt + 1;
            if(leftSize>0){
                root.left=createTree(preSt+1,preSt+leftSize,postSt,postLeftPosition,pre,postMap);
            }
            int rightSize = preEnd - leftSize;
            if(rightSize>0){
                root.right=createTree(preSt+leftSize+1,preEnd,postSt+leftSize,postEnd-1,pre,postMap);
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode node = new A889_ConstructBinaryTreeAccordingToPreorderAndPostorderTraversal().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        TreeNode node = new A889_ConstructBinaryTreeAccordingToPreorderAndPostorderTraversal().constructFromPrePost(new int[]{2,1,3}, new int[]{3,1,2});
        System.out.println(node);
    }
}
