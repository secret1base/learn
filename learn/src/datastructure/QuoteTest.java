package datastructure;

/**
 * 测试引用的传递
 * @author: wyj
 * @create: 2020-05-21 16:59
 */
public class QuoteTest {
    public static void main(String[] args) {
        Node first = new Node("1",null);
        Node two = new Node("2",null);
        Node three = new Node("3",null);
        first.next=two;
        two.next=three;
        Node pre=first;
        pre=pre.next;
        System.out.println(pre.v);
        System.out.println(first.v);
    }
    private static class Node<T>{
        private T v;
        private Node next;
        Node(T v,Node next){
            this.v=v;
            this.next=next;
        }
    }
}
