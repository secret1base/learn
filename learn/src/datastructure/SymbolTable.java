package datastructure;

import java.util.Iterator;

/**
 * 无序符号表：isEmpty、size、put、get、remove、foreach
 * @author: wyj
 * @date: 2020/05/22
 */
public class SymbolTable<K,V> implements Iterable<V>{
    private Node head;
    private int N;
    public SymbolTable(){
        head=new Node(null,null,null);
        N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void put(K key,V value){
        if(isEmpty()){
            head.next=new Node(key,value,null);
            N++;
        }else{
            Node pre=head;
            while (pre.next!=null){
                if(pre.next.key.equals(key)){
                    pre.next.value=value;
                    return;
                }
                pre=pre.next;
            }
            pre.next=new Node(key,value,null);
            N++;
        }
    }
    public V get(K key){
        Node pre=head;
        while (pre.next!=null){
            if(pre.next.key.equals(key)){
                return pre.next.value;
            }
            pre=pre.next;
        }
        return null;
    }

    public V remove(K key){
        Node pre=head;
        while (pre.next!=null){
            if(pre.next.key.equals(key)){
                Node remove = pre.next;
                Node curr = pre.next.next;
                pre.next=curr;
                N--;
                return remove.value;
            }
            pre=pre.next;
        }
        return null;
    }

    public void foreach(){
        Node pre=head;
        while (pre.next!=null){
            System.out.println("key="+pre.next.key+",value="+pre.next.value);
            pre=pre.next;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new TableIterator();
    }

    private class TableIterator implements Iterator{
        private Node curr;
        TableIterator(){
            curr=head;
        }

        @Override
        public boolean hasNext() {
            return curr.next!=null;
        }

        @Override
        public V next() {
            return (curr=curr.next).value;
        }
    }
    private class Node{
        K key;
        V value;
        Node next;
        Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
}
