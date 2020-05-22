package datastructure;

import java.util.Iterator;

/**
 * 栈：压栈、弹栈、判空、获取长度、遍历
 * @author: wyj
 * @date: 2020/05/22
 */
public class Stack<T> implements Iterable<T>{
    private Node head;
    private int N;

    public Stack(){
        this.head=new Node(null,null);
        N=0;
    }

    public void push(T item){
        if(N==0){
            head.next=new Node(item,null);
        }else{
            //压栈放在根结点后面就可以了
            Node pre=head;
            Node after = pre.next;
            Node curr = new Node(item, null);
            head.next=curr;
            curr.next=after;
        }
        N++;
    }

    public T pop(){
        if(N==0){
            return null;
        }else{
            Node curr=head.next;
            Node next = curr.next;
            head.next=next;
            N--;
            return curr.item;
        }
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator{
        private Node curr;
        StackIterator(){
            curr=head;
        }

        @Override
        public boolean hasNext() {
            return curr.next!=null;
        }

        @Override
        public T next() {
            return (curr=curr.next).item;
        }
    }

    private class Node{
        Node next;
        T item;
        Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
}
