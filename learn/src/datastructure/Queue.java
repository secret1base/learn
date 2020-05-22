package datastructure;

import java.util.Iterator;

/**
 * 队的实现：进队、出队、判空、获取长度、遍历
 * @author: wyj
 * @date: 2020/05/22
 */
public class Queue<T> implements Iterable<T>{
    private Node head;
    private int N;

    public Queue(){
        head=new Node(null,null);
        N=0;
    }

    public void enqueue(T item){
        if(N==0){
            head.next=new Node(item,null);
            N++;
        }else{
            Node pre=head;
            while (pre.next!=null){
                pre=pre.next;
            }
            pre.next=new Node(item,null);
            N++;
        }
    }

    public T dequeue(){
        if(N==0){
            return null;
        }
        Node pre=head;
        Node delnode = pre.next;
        head.next= delnode.next;
        N--;
        return delnode.item;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node{
        Node next;
        T item;
        Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
    private class QueueIterator implements Iterator{
        private Node curr;
        QueueIterator(){
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
}
