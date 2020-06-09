package datastructure.test;

import datastructure.Queue;

/**
 * 折纸问题：利用二叉树解决折纸问题
 * @author: wyj
 * @date: 2020/06/04
 */
public class PaperFoldingTest {
    /**
     * 折纸问题
     */
    public static void main(String[] args) {
        //创建折纸树
        Node paperNode= createTree(3);
        //中序遍历进行打印
        Queue<String> paperList = new Queue<>();
        midErgodic(paperNode,paperList);
        for (String s : paperList) {
            System.out.println(s);
        }
    }

    /**
     * 中序遍历
     * @param node
     * @param keys
     */
    public static void midErgodic(Node<String,String> node, Queue<String> keys) {
        if(node==null){
            return;
        }
        if(node.left!=null){
            midErgodic(node.left,keys);
        }
        keys.enqueue(node.key);
        if(node.right!=null){
            midErgodic(node.right,keys);
        }
    }

    /**
     * 创建折纸树
     * @param count
     * @return
     */
    public static Node createTree(int count) {
        if(count==0){
            return null;
        }
        Node root=null;
        for(int i=0;i<count;i++){
            if(i==0){
                root=new Node("down","null",null,null);
            }else{
                Queue<Node> queue = new Queue<>();
                queue.enqueue(root);
                //折纸处理
                while (!queue.isEmpty()){
                    Node deNode = queue.dequeue();
                    if(deNode.left!=null){
                        queue.enqueue(deNode.left);
                    }
                    if(deNode.right!=null){
                        queue.enqueue(deNode.right);
                    }
                    if(deNode.left==null&&deNode.right==null){
                        deNode.left=new Node("down","null",null,null);
                        deNode.right=new Node("up","null",null,null);
                    }
                }
            }
        }
        return root;
    }
}

class Node<K,V>{
    K key;
    V value;
    Node left;
    Node right;
    Node(K key, V value, Node left, Node right){
        this.key=key;
        this.value=value;
        this.left=left;
        this.right=right;
    }
}