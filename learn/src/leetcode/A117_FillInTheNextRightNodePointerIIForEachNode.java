package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * @author: wyj
 * @date: 2021/07/13
 */
public class A117_FillInTheNextRightNodePointerIIForEachNode {
    /**
     * 给定一个二叉树
     *  填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *  初始状态下，所有 next 指针都被设置为 NULL。
     *  进阶：
     *  你只能使用常量级额外空间。
     *  使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *  示例：
     *  117.png
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：[1,#,2,3,#,4,5,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
     * 针连接），'#' 表示每层的末尾。
     *  提示：
     *  树中的节点数小于 6000
     *  -100 <= node.val <= 100
     *
     *  一次过
     * 			执行耗时:1 ms,击败了65.00% 的Java用户
     * 			内存消耗:38 MB,击败了59.20% 的Java用户
     */
    public Node117 connect(Node117 root) {
        if(root==null){
            return root;
        }
        //让每个Node的next连接上同层级的右侧节点，
        //层级遍历,因为需要每个节点的next连接上右侧的同级节点，因此层序遍历上下顺序不变，左右顺序颠倒
        Deque<Node117> path=new LinkedList<>();
        path.offerLast(root);
        while (!path.isEmpty()){
            int size = path.size();
            Node117 right=null;
            for (int i = 0; i < size; i++) {
                Node117 node = path.pollFirst();
                if(right==null){
                    right=node;
                }else{
                    node.next=right;
                    right=node;
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
