package datastructure;

import java.util.Iterator;

/**
 * 双向链表
 * @author: wyj
 * @create: 2020-05-21 16:29
 */
public class DoubleLinkList<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;

    public DoubleLinkList(){
        head=new Node(null,null,null);
        last=null;
        N=0;
    }

    /**
     * 清空
     */
    public  void clear(){
        head.pre=null;
        head.next=null;
        head.v=null;
        last=null;
        N=0;
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 长度
     * @return
     */
    public  int length(){
        return N;
    }

    /**
     * 获取指定位置的值
     * @param i
     * @return
     */
    public  T get(int i){
        if(i<0||i>=N){
            throw new RuntimeException("索引不存在");
        }
        Node pre=head;
        for(int k=0;k<i;k++){
            pre=pre.next;
        }
        return pre.next.v;
    }

    /**
     * 新增
     * @param t
     */
    public  void add(T t){
        if(last==null){
            last = new Node(head, null, t);
            head.next=last;
        }else {
            Node oldLast=last;
            Node node=new Node(oldLast,null,t);
            oldLast.next=node;
            last=node;
        }
        N++;
    }

    /**
     * 指定索引插入，插入后原元素后移一位
     * @param i
     * @param t
     */
    public void insert(int i,T t){
        if(i<0||i>=N){
            throw new RuntimeException("索引不存在");
        }
        Node pre=head;
        for (int k=0;k<i;k++){
            pre=pre.next;
        }
        Node curr = pre.next;
        Node newNode = new Node(pre, curr, t);
        pre.next=newNode;
        curr.pre=newNode;
        N++;
    }

    /**
     * 移除指定元素
     * @param i
     * @return
     */
    public  T remove(int i){
        if(i<0||i>=N){
            throw new RuntimeException("不存在对应索引");
        }
        Node pre=head;
        for(int k=0;k<i;k++){
            pre=pre.next;
        }
        Node toDel = pre.next;
        Node curr = toDel.next;
        pre.next=curr;
        curr.pre=pre;
        N--;
        return toDel.v;
    }

    /**
     * 判断元素存在位置
     * @param t
     * @return
     */
    public  int indexOf(T t){
        Node curr=head;
        int i=0;
        while (curr.next!=null){
            curr=curr.next;
            if(curr.v.equals(t)){
                return i;
            }
            i++;
        }
        return -1;
    }
    public  T getFirst(){
        return head.next.v;
    }
    public  T getLast(){
        return last.v;
    }

    @Override
    public Iterator iterator() {
        return new DoubleLinkIter();
    }


    private class Node{
        Node pre;
        Node next;
        private T v;
        Node(Node pre,Node next,T v){
            this.pre=pre;
            this.next=next;
            this.v=v;
        }
    }

    private class DoubleLinkIter implements Iterator{
        private Node curr;
        DoubleLinkIter(){
            curr=head;
        }

        @Override
        public boolean hasNext() {
            return curr.next!=null;
        }

        @Override
        public Object next() {
            return (curr=curr.next).v;
        }
    }
}
