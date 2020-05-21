package datastructure;

import java.util.Iterator;

/**
 * @author: wyj
 * @create: 2020-05-21 19:02
 */
public class LinkList<T> implements Iterable<T>{
    private Node head;
    private int N;

    public LinkList(){
        head=new Node(null,null);
        N=0;
    }
    public void add(T v){
        if(head.next==null){
            head.next=new Node(v,null);
        }else{
            Node pre=head;
            for(int i=0;i<N;i++){
                pre=pre.next;
            }
            pre.next=new Node(v,null);
        }
        N++;
    }
    public void insert(int i,T v){
        if(i<0||i>=N){
            throw new RuntimeException("索引不存在");
        }
        Node pre=head;
        for(int k=0;k<i;k++){
            pre=pre.next;
        }
        Node after = pre.next;
        Node node = new Node(v, after);
        pre.next=node;
        N++;
    }
    public void modify(int i,T v){
        if(i<0||i>=N){
            throw new RuntimeException("索引不存在");
        }
        Node pre=head;
        for(int k=0;k<i;k++){
            pre=pre.next;
        }
        Node curr = pre.next;
        curr.item=v;
    }

    public T delMax(){
        if(head.next==null){
            throw new RuntimeException("已不存在元素");
        }
        Node del = head.next;
        head.next = del.next;
        N--;
        return del.item;
    }

    public T get(int i){
        if(i<0||i>=N){
            throw new RuntimeException("不存在");
        }
        Node pre=head;
        for(int k=0;k<i;k++){
            pre=pre.next;
        }
        return pre.next.item;
    }
    public boolean isEmpty(){
        return N==0;
    }

    public void clear(){
        head.next=null;
        head.item=null;
        N=0;
    }

    public T getMid(){
        Node fast=head;
        Node slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.item;
    }
    public void revirse(){
        if(N==0){
            return;
        }
        revirse(head.next);
    }

    private Node revirse(Node curr) {
        //传入父结点
        if(curr.next==null){
            head.next=curr;
            return curr;
        }
        Node pre = revirse(curr.next);
        pre.next=curr;
        curr.next=null;
        return curr;
    }
    @Override
    public Iterator iterator() {
        return new LinkListIterato();
    }


    private class LinkListIterato implements Iterator{
        private Node curr;
        LinkListIterato(){
            curr=head;
        }

        @Override
        public boolean hasNext() {
            return curr.next!=null;
        }

        @Override
        public Object next() {
            return (curr=curr.next).item;
        }
    }
    private class Node{
        private Node next;
        private T item;
        Node(T item,Node next){
            this.next=next;
            this.item=item;
        }
    }

}
