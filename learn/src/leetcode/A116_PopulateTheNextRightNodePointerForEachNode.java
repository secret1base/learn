package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * @author: wyj
 * @date: 2021/07/28
 */
public class A116_PopulateTheNextRightNodePointerForEachNode {
    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     *  填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *  初始状态下，所有 next 指针都被设置为 NULL。
     *  进阶：
     *  你只能使用常量级额外空间。
     *  使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *  示例：
     *  116.png
     * 输入：root = [1,2,3,4,5,6,7]
     * 输出：[1,#,2,3,#,4,5,6,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由
     * next 指针连接，'#' 标志着每一层的结束。
     *  提示：
     *  树中节点的数量少于 4096
     *  -1000 <= node.val <= 1000
     *
     *  		执行耗时:2 ms,击败了66.58% 的Java用户
     * 			内存消耗:38.7 MB,击败了34.72% 的Java用户
     */
    public Node117 connect(Node117 root) {
        Deque<Node117> path=new LinkedList<>();
        if(root==null){
            return null;
        }
        path.offerLast(root);
        while (!path.isEmpty()){
            int size = path.size();
            Node117 pre=null;
            for (int i = 0; i < size; i++) {
                Node117 node = path.pollFirst();
                if(pre==null){
                    pre=node;
                }else{
                    node.next=pre;
                    pre=node;
                }
                if(node.right!=null){
                    path.offerLast(node.right);
                }
                if(node.left!=null){
                    path.offerLast(node.left);
                }
            }
        }
        return root;
    }
}
