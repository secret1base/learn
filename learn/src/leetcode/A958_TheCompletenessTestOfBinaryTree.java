package leetcode;

import leetcode.tool.TreeNode;

import java.util.*;

/**
 * 958. 二叉树的完全性检验
 * @author: wyj
 * @date: 2021/06/14
 */
public class A958_TheCompletenessTestOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        //通过堆的方式来为树中的每个节点进行编号,排序到最后一个节点时，如果是完全二叉树，需要满足，当前节点的序号与堆的长度一致
        ANode aNode = new ANode(root,1);
        List<ANode> list=new ArrayList<>();
        list.add(aNode);
        int i=0;
        while (i<list.size()){
            ANode n = list.get(i++);
            if(n.node!=null){
                list.add(new ANode(n.node.left,n.position*2));
                list.add(new ANode(n.node.right,n.position*2+1));
            }
        }
        return list.get(i-1).position==list.size();
    }
}
class ANode{
    TreeNode node;
    int position;

    public ANode(TreeNode node, int position) {
        this.node = node;
        this.position = position;
    }

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
