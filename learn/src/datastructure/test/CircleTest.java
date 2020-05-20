package datastructure.test;

/**
 * 快慢指针判断是否存在环以及获取环入口
 * @author: wyj
 * @create: 2020-05-20 16:20
 */
public class CircleTest {
    public static void main(String[] args) {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);


        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
//        //产生环
        seven.next = third;
        boolean circle = isCircle(first);
        System.out.println(circle);
        String circleEntry = getCircleEntry(first);
        System.out.println(circleEntry);

    }

    private static boolean isCircle(Node<String> first){
        Node<String> slow=first;
        Node<String> fast=first;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    private static String getCircleEntry(Node<String> first){
        Node<String> slow=first;
        Node<String> fast=first;
        Node<String> index = null;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                index=first;
                continue;
            }
            if(index!=null){
                index=index.next;
            }
            if(slow.equals(index)){
                return index.v;
            }
        }
        return null;
    }


    private static class Node<T> {
        private T v;
        private Node<T> next;
        private Node(T v, Node next){
            this.v=v;
            this.next=next;
        }
        private Node(T v){
            this.v=v;
        }
    }
}
