package leetcode;

/**
 * 双向节点
 * @author: wyj
 * @date: 2021/07/13
 */
public class Node117 {
    public int val;
    public Node117 left;
    public Node117 right;
    public Node117 next;

    public Node117() {}

    public Node117(int _val) {
        val = _val;
    }

    public Node117(int _val, Node117 _left, Node117 _right, Node117 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
