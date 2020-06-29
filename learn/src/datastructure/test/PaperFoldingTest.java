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
        PaperFoldingTest paperTest = new PaperFoldingTest();
        Node tree = paperTest.createTree(3);
        Queue<String> ks = new Queue<>();
        paperTest.midErgodic(tree,ks);
        for (String k : ks) {
            System.out.println(k);
        }
    }

    public Node createTree(int count){
        if(count<=0){
            return null;
        }
        Node root = null;
        for(int i=0;i<count;i++){
            if(i==0){
                root=new Node("down",null,null);
            }else{
                Queue<Node> nodes = new Queue<>();
                nodes.enqueue(root);
                while (!nodes.isEmpty()){
                    Node dequeue = nodes.dequeue();
                    if(dequeue.left!=null&&dequeue.right!=null){
                        nodes.enqueue(dequeue.left);
                        nodes.enqueue(dequeue.right);
                    }else{
                        dequeue.left=new Node("down",null,null);
                        dequeue.right=new Node("up",null,null);
                    }
                }
            }
        }
        return root;
    }

    public void midErgodic(Node<String> node,Queue<String> ks){
        if(node==null){
            return;
        }
        if(node.left!=null){
            midErgodic(node.left,ks);
        }
        ks.enqueue(node.item);
        if(node.right!=null){
            midErgodic(node.right,ks);
        }
    }
}

class Node<T>{
    public T item;
    public Node left;
    public Node right;
    public Node(T item,Node left,Node right){
        this.item=item;
        this.left=left;
        this.right=right;
    }
}