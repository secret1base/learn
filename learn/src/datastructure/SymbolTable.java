package datastructure;

import java.util.Iterator;

/**
 * 无序符号表：插入键值对、根据key删除键值对、根据key获取值、获取长度、判空、查询、遍历
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

    /**
     * 用于修改key的对应值
     * @param k
     * @return
     */
    private Node getNode(K k){
        if(isEmpty()){
            return null;
        }else{
            Node curr=head;
            while (curr.next!=null){
                curr=curr.next;
                if(curr.key.equals(k)){
                    return curr;
                }
            }
        }
        return null;
    }

    /**
     * 获取
     * @param k
     * @return
     */
    public V get(K k){
        if(isEmpty()){
            return null;
        }else{
            Node curr=head;
            while (curr.next!=null){
                curr=curr.next;
                if(curr.key.equals(k)){
                    return curr.value;
                }
            }
        }
        return null;
    }

    public void foreach(){
        Node pre=head;
        while (pre.next!=null){
            pre=pre.next;
            System.out.println("key="+pre.key+",value="+pre.value);
        }
    }

    public void put(K k,V v){
        if(isEmpty()){
            head.next=new Node(k,v,null);
            N++;
        }else{
            Node node = getNode(k);
            if(node!=null){
                node.value=v;
            }else{
                Node after = head.next;
                Node curr = new Node(k, v, after);
                head.next=curr;
                N++;
            }
        }
    }
//    根据key删除键值对、根据key获取值、获取长度、判空、查询

    public V remove(K k){
        Node pre=head;
        while (pre.next!=null){
            if(pre.next.key.equals(k)){
                Node delNode = pre.next;
                Node curr = delNode.next;
                pre.next=curr;
                N--;
                return delNode.value;
            }
            pre=pre.next;
        }
        return null;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<V> iterator() {
        return new SymbolTableIterator();
    }
    private class SymbolTableIterator implements Iterator{
        private Node curr;
        SymbolTableIterator(){
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
