package datastructure;

/**
 * 二叉查找树:put、delete、get、查找二叉树中最小的键、查找二叉树中最大的键、前序遍历、中序遍历、后序遍历、层序遍历、最大深度
 * @author: wyj
 * @date: 2020/05/29
 */
public class BinaryTree<K extends Comparable,V> {
    private Node root;
    private int N;

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void put(K key,V value){
        root= put(root,key,value);
    }

    private Node put(Node node, K key, V value) {
        if(node==null){
            N++;
            return new Node(key,value,null,null);
        }
        int i = node.key.compareTo(key);
        if(i>0){
            node.left=put(node.left,key,value);
        }else if(i<0){
            node.right=put(node.right,key,value);
        }else{
            node.value=value;
        }
        return node;
    }

    public void delete(K key){
        delete(root,key);
    }

    private Node delete(Node node, K key) {
        if(node==null){
            return null;
        }
        int i = node.key.compareTo(key);
        if(i>0){
            node.left=delete(node.left,key);
        }else if(i<0){
            node.right=delete(node.right,key);
        }else{
            N--;
            //删除本节点
            //1、找到能够替代的节点
            if(node.right==null){
                //没有右子节点则用左子节点
                return node.left;
            }
            if(node.left==null){
                //没有左子节点则用右子节点
                return node.right;
            }

            //到这里为左右子节点都存在的情况
            //取右子节点中最小的值
            Node minNode=node.right;
            while (minNode.left!=null){
                minNode=minNode.left;
            }
            //获取到后删除该值
            Node pre=node.right;
            //这里有个特别的坑，如果pre没有左子节点，需要直接置null，否则二叉树会变成环
            if(pre.left==null){
                node.right=null;
            }
            while (pre.left!=null){
                if(pre.left.left==null){
                    pre.left=null;
                }else{
                    pre=pre.left;
                }
            }
            minNode.left=node.left;
            minNode.right=node.right;
            node=minNode;
        }
        return node;
    }

    public V get(K key){
        return get(root,key);
    }

    private V get(Node node, K key) {
        if(node==null){
            return null;
        }
        int i = node.key.compareTo(key);
        if(i>0){
            return get(node.left,key);
        }else if(i<0){
            return get(node.right,key);
        }else{
            return node.value;
        }
    }

    public K getMaxKey(){
        Node node=root;
        while (node.right!=null){
            node=node.right;
        }
        return node.key;
    }

    public K getMinKey(){
        Node node =root;
        while (node.left!=null){
            node=node.left;
        }
        return node.key;
    }

    public Queue<K> preErgodic(){
        Queue<K> keys=new Queue<>();
        preErgodic(root,keys);
        return keys;
    }

    /**
     * 前序遍历
     * 1.把当前结点的key放入到队列中;
     * 2.找到当前结点的左子树，如果不为空，递归遍历左子树
     * 3.找到当前结点的右子树，如果不为空，递归遍历右子树
     * @param node
     * @param keys
     */
    private void preErgodic(Node node, Queue<K> keys) {
        if(node==null){
            return;
        }
        keys.enqueue(node.key);
        if(node.left!=null){
            preErgodic(node.left,keys);
        }
        if(node.right!=null){
            preErgodic(node.right,keys);
        }
    }


    public Queue<K> midErgodic() {
        Queue<K> keys=new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    /**
     * 中序遍历
     * 1.找到当前结点的左子树，如果不为空，递归遍历左子树
     * 2.把当前结点的key放入到队列中;
     * 3.找到当前结点的右子树，如果不为空，递归遍历右子树
     * @param node
     * @param keys
     */
    private void midErgodic(Node node, Queue<K> keys) {
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

    public Queue<K> afterErgodic(){
        Queue<K> keys=new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    /**
     * 后续遍历
     * 1.找到当前结点的左子树，如果不为空，递归遍历左子树
     * 2.找到当前结点的右子树，如果不为空，递归遍历右子树
     * 3.把当前结点的key放入到队列中;
     * @param node
     * @param keys
     */
    private void afterErgodic(Node node, Queue<K> keys) {
        if(node==null){
            return;
        }
        if(node.left!=null){
            afterErgodic(node.left,keys);
        }
        if(node.right!=null){
            afterErgodic(node.right,keys);
        }
        keys.enqueue(node.key);
    }

    /**
     * 层序遍历(非递归遍历)
     * 1.创建队列，存储每一层的结点；
     * 2.使用循环从队列中弹出一个结点：
     *  2.1获取当前结点的key；
     *  2.2如果当前结点的左子结点不为空，则把左子结点放入到队列中
     *  2.3如果当前结点的右子结点不为空，则把右子结点放入到队列中
     * @return
     */
    public Queue<K> layerErgodic(){
        Queue<K> keys=new Queue<>();
        Queue<Node> nodeQueue=new Queue<>();
        nodeQueue.enqueue(root);
        while (!nodeQueue.isEmpty()){
            Node node = nodeQueue.dequeue();
            keys.enqueue(node.key);
            if(node.left!=null){
                nodeQueue.enqueue(node.left);
            }
            if(node.right!=null){
                nodeQueue.enqueue(node.right);
            }
        }
        return keys;
    }

    public int maxDepth(){
        return maxDepth(root);
    }

    /**
     * 最大深度
     * @param node
     * @return
     */
    private int maxDepth(Node node) {
        if(node==null){
            return 0;
        }
        int left=0;
        int right=0;
        if(node.left!=null){
            left= maxDepth(node.left);
        }
        if(node.right!=null){
            right= maxDepth(node.right);
        }
        return left>right?left+1:right+1;
    }


    private class Node{
        K key;
        V value;
        Node left;
        Node right;
        Node(K key,V value,Node left,Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
}
