package datastructure;

/**
 * 红黑树:
 *  需要左旋:当前结点的左子结点为黑色，右子结点为红色
 *  需要右旋:当前节点的左子节点和左子节点的左子节点都为红色
 *  需要颜色反转:当前节点的左子节点和右子节点都为红色
 *  验证:1、不存在两个连续的红色节点 2、从根节点到叶子节点的黑色节点数应该是一致的
 * @author: wyj
 * @date: 2020/06/23
 */
public class RedBlackTree<K extends Comparable,V> {
    private Node root;
    private int N;
    private static final boolean RED=true;
    private static final boolean BLACK=false;

    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }

    public boolean isRed(Node node){
        if(node==null){
            return false;
        }
        return node.color==RED;
    }

    public void put(K key,V value){
        root= put(root,key,value);
        root.color=BLACK;
    }

    private Node put(Node node, K key, V value) {
        if(node==null){
            N++;
            return new Node(key,value,null,null,RED);
        }
        int i = node.key.compareTo(key);
        if(i>0){
            node.left=put(node.left,key,value);
        }else if(i<0){
            node.right=put(node.right,key,value);
        }else{
            node.value=value;
            return node;
        }
        if (!isRed(node.left)&&isRed(node.right)){
            node=rotateLeft(node);
        }

        if(isRed(node.left)&&isRed(node.left.left)){
            node=rotateRight(node);
        }

        if(isRed(node.left)&&isRed(node.right)){
            node=reverseColor(node);
        }
        return node;
    }

    /**颜色反转*/
    private Node reverseColor(Node node) {
        node.left.color=BLACK;
        node.right.color=BLACK;
        node.color=RED;
        return node;
    }

    /**右旋*/
    private Node rotateRight(Node node) {
        Node curr = node.left;
        node.left = curr.right;
        curr.right=node;
        curr.color=node.color;
        node.color=RED;
        return curr;
    }

    /**左旋*/
    private Node rotateLeft(Node node) {
        Node curr = node.right;
        node.right= curr.left;
        curr.left=node;
        curr.color=node.color;
        node.color=RED;
        return curr;
    }


    public Queue<K> midErgodic(){
        Queue<K> ks = new Queue<>();
        midErgodic(root,ks);
        return ks;
    }

    public V get(K key){
        Node node= get(root,key);
        if(node==null){
            return null;
        }
        return node.value;
    }

    private Node get(Node node, K key) {
        if(node==null){
            return null;
        }
        int i = node.key.compareTo(key);
        if(i>0){
            return get(node.left,key);
        }else if(i<0){
            return get(node.right,key);
        }else{
            return node;
        }
    }

    private void midErgodic(Node node, Queue<K> ks) {
        if(node==null){
            return;
        }
        if(node.left!=null){
            midErgodic(node.left,ks);
        }
        ks.enqueue(node.key);
        if(node.right!=null){
            midErgodic(node.right,ks);
        }
    }
    /**验证规则：不存在连续的红色节点*/
    public boolean validateRed(){
        return validateRed(root);
    }

    private boolean validateRed(Node node) {
        if(isRed(node)&&isRed(node.left)){
            System.out.println("红黑树不能存在两个连续的红色节点");
            return false;
        }
        if(isRed(node.right)){
            System.out.println("红黑树的右子节点不能为红色节点");
            return false;
        }
        if(node.left!=null){
            validateRed(node.left);
        }
        if(node.right!=null){
            validateRed(node.right);
        }
        return true;
    }

    /**获取单一链的黑色节点数(从根结点开始到各个叶节点的黑色节点数是相同的，如果不同代表不是红黑树)*/
    /**黑色节点数可以理解为红黑树的层级*/
    public int getBlackCount(){
        return validateBlackCount(root);
    }

    /**本职:获取黑色节点数，副职:如果黑色节点数存在异常，则抛出异常*/
    private int validateBlackCount(Node node) {
        if(node==null){
            return 0;
        }
        int curr=isRed(node)?0:1;
        int left=0;
        int right=0;
        if(node.left!=null){
            left=validateBlackCount(node.left);
        }
        if(node.right!=null){
            right=validateBlackCount(node.right);
        }
        if(left!=right){
            throw new RuntimeException("黑色节点数不一致");
        }
        return curr+left;
    }

    private class Node{
        K key;
        V value;
        Node left;
        Node right;
        boolean color;
        Node(K key,V value,Node left,Node right,boolean color){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
            this.color=color;
        }
    }
}
