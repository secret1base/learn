package leetcode;

import leetcode.tool.TreeNode;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * @author: wyj
 * @date: 2021/06/22
 */
public class A297_SerializationAndDeserializationOfBinaryTree {
    /**
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
     * 式重构得到原数据。
     *  请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
     * 反序列化为原始的树结构。
     *  提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
     * 方法解决这个问题。
     *  示例 1：
     * 输入：root = [1,2,3,null,null,4,5]
     * 输出：[1,2,3,null,null,4,5]
     *  示例 2：
     * 输入：root = []
     * 输出：[]
     *  示例 3：
     * 输入：root = [1]
     * 输出：[1]
     *  示例 4：
     * 输入：root = [1,2]
     * 输出：[1,2]
     *
     * 		执行耗时:13 ms,击败了75.54% 的Java用户
     * 		内存消耗:40.4 MB,击败了71.41% 的Java用户
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append("none,");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        LinkedList<String> path=new LinkedList<>();
        for (String s : arr) {
            if(s.length()>0){
                path.offerLast(s);
            }
        }
        return deserialize(path);
    }

    private TreeNode deserialize(LinkedList<String> path) {
        String first = path.pollFirst();
        if(first.equals("none")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(first));
        root.left=deserialize(path);
        root.right=deserialize(path);
        return root;
    }

    public static void main(String[] args) {
        /**
         *            1
         *          / \
         *         2   3
         *        / \
         *       4   5
         */
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a1.left=a2;
        a1.right=a3;
        a3.left=a4;
        a3.right=a5;
        String serialize = new A297_SerializationAndDeserializationOfBinaryTree().serialize(a1);
        System.out.println(serialize);
        TreeNode deserialize = new A297_SerializationAndDeserializationOfBinaryTree().deserialize(serialize);
        String serialize1 = new A297_SerializationAndDeserializationOfBinaryTree().serialize(deserialize);
        System.out.println(serialize1);
    }
}
