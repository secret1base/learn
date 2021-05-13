package datastructure.test;

/**
 * 快慢指针判断是否存在环以及获取环入口
 * @author: wyj
 * @date: 2020/05/22
 */
public class CircleTest {

    public static void main(String[] args) {
        Node<String> first = new Node<String>("11",null);
        Node<String> two = new Node<String>("22",null);
        Node<String> three = new Node<String>("33",null);
        Node<String> four = new Node<String>("44",null);
        Node<String> five = new Node<String>("55",null);
        Node<String> six = new Node<String>("66",null);
        first.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        five.next=six;
        first.foreach();

        System.out.println(isCircle(first));

        five.next=two;
//        first.foreach();
        System.out.println(isCircle(first));
        Node circleEntry = getCircleEntry(first);
        System.out.println(circleEntry.item);
    }


    public static boolean isCircle(Node node){
        Node fast=node;
        Node slow=node;
        while (fast.next!=null&&fast.next.next!=null){
            fast= fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                return true;
            }
        }
        return false;
    }

    public static Node getCircleEntry(Node node){
        Node fast=node;
        Node slow=node;
        Node index=null;
        while (true){
            if(fast==null||fast.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(index==null&&fast.equals(slow)){
                index=node;
                break;
            }
        }
        while (index!=slow){
            index=index.next;
            slow=slow.next;
        }
        return index;
    }

    private static class Node<T>{
        Node next;
        T item;
        Node(T item,Node next){
            this.next=next;
            this.item=item;
        }
        public void foreach(){
            Node curr=this;
            System.out.println(curr.item);
            while (curr.next!=null){
                curr=curr.next;
                System.out.println(curr.item);
            }
        }
    }

}

