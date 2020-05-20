package datastructure;

import java.util.Iterator;

/**
 * 单向链表
 * @author: wyj
 * @create: 2020-05-20 14:54
 */
public class LinkList<T> implements Iterable<T> {
    private Node head;//头节点
    private int N;//当前位置

    public LinkList(){
        this.N=0;
        this.head=new Node(null);
    }

    //新增
    public void add(T v){
        Node temp=head;
        for(int i=0;i<N;i++){
            temp=temp.next;
        }
        temp.next= new Node<T>(v);
        N++;
    }
    //插入
    public void insert(int i,T v){
        Node temp=head;
        for(int k=0;k<i;k++){
            //找到目标结点的父结点
            temp=temp.next;
        }
        temp.next= new Node<T>(v,temp.next);
        N++;
    }
    //修改
    public void modify(int i,T v){
        Node temp=head;
        for(int k=0;k<i;k++){
            //找到目标结点的父结点
            temp=temp.next;
        }
        temp.next.v=v;
    }
    //删除
    public T delete(int i){
        Node temp = this.head;
        for(int k=0;k<i;k++){
            //找到目标结点的父结点
            temp=temp.next;
        }
        Node next = temp.next.next;//目标结点的子节点
        T v = (T)temp.next.v;
        temp.next=next;
        N--;
        return v;
    }

    //获取对应值
    public T get(int i){
        Node<T> temp = this.head;
        for(int k=0;k<i;k++){
            temp=temp.next;
        }
        return temp.v;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void clear(){
        N=0;
        head.next=null;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator iterator() {
        return new LinkIterator();
    }

    private class LinkIterator implements Iterator<T>{
        private Node cursor;

        private LinkIterator(){
            this.cursor=head;
        }

        @Override
        public boolean hasNext() {
            return cursor.next!=null;
        }

        @Override
        public T next() {
            return (T) (cursor=cursor.next).v;
        }
    }


    private class Node<T>{
        private T v;
        private Node<T> next;
        private Node(T v,Node next){
            this.v=v;
            this.next=next;
        }
        private Node(T v){
            this.v=v;
        }
    }
}
