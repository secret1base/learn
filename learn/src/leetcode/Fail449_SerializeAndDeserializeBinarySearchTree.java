package leetcode;

import leetcode.tool.TreeNode;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 449. 序列化和反序列化二叉搜索树
 * @author: wyj
 * @date: 2021/07/13
 */
public class Fail449_SerializeAndDeserializeBinarySearchTree {
    /**
     * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
     *  设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
     * 列化为最初的二叉搜索树。
     *  编码的字符串应尽可能紧凑。
     *  示例 1：
     * 输入：root = [2,1,3]
     * 输出：[2,1,3]
     *  示例 2：
     * 输入：root = []
     */
    //另外一种方法是通过前序遍历+中序遍历的结构来构造二叉树，然后从二叉树生成二叉树时，
    // 需要生成前序遍历+中序遍历的字符串，可能也不符合题目要求，不清楚还有什么结构是不需要多余null
    // 也不需要遍历两边就能确定二叉树结构的
//    /**
//     * 借助堆结构实现，需要添加个辅助类用于记录当前值的索引位置,
//     * 结构不够紧凑内存溢出了
//     * @param root
//     * @return
//     */
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        List<String> list=new ArrayList<>();
//        if(root==null){
//            return null;
//        }
//        Deque<P> path=new LinkedList<>();
//        path.offerLast(new P(1,root));
//        //堆结构0索引位置放null
//        list.add(null);
//        while (!path.isEmpty()){
//            P p = path.pollFirst();
//            int curr = p.index;
//            while (list.size()<curr){
//                //当前要放在索引3处，但是list目前是{null,1}，size=2，索引只到1，还需要放一个值
//                list.add(null);
//            }
//            list.add(Integer.toString(p.curr.val));
//            if(p.curr.left!=null){
//                path.offerLast(new P(curr*2,p.curr.left));
//            }
//            if(p.curr.right!=null){
//                path.offerLast(new P(curr*2+1,p.curr.right));
//            }
//        }
//        return list.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if(data==null){
//            return null;
//        }
//        //[null, zzz, null]
//        String substring = data.substring(1, data.length() - 1);
//        String[] heap = substring.split(", ");
//        //heap是个堆结构的数据
//        return addNode(1,heap);
//    }
//
//    private TreeNode addNode(int i, String[] heap) {
//        String val = heap[i];
//        if("null".equals(val)){
//            return null;
//        }
//        TreeNode node=new TreeNode(Integer.parseInt(val));
//        if(i*2<heap.length){
//            node.left=addNode(i*2,heap);
//        }
//        if(i*2+1<heap.length){
//            node.right=addNode(i*2+1,heap);
//        }
//        return node;
//    }
//
//    class P{
//        int index;
//        TreeNode curr;
//
//        public P(int index, TreeNode curr) {
//            this.index = index;
//            this.curr = curr;
//        }
//    }
//
//    public static void main(String[] args) {
//        TreeNode a1=new TreeNode(1);
//        TreeNode a2=new TreeNode(2);
//        TreeNode a3=new TreeNode(3);
//        a1.left=a2;
//        a1.right=a3;
//        String serialize = new A449_SerializeAndDeserializeBinarySearchTree().serialize(a1);
//        System.out.println(serialize);
//        TreeNode deserialize = new A449_SerializeAndDeserializeBinarySearchTree().deserialize(serialize);
//        System.out.println();
//    }
}
