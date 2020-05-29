package datastructure;

/**
 * 有序符号表(key从小到大):get(Key)、put(key,value)、remove(key)、size、isEmpty
 * @author: wyj
 * @date: 2020/05/26
 */
public class OrderSymbolTable<K extends Comparable<K>,V> {
    private Node head;
    private int N;
    public OrderSymbolTable(){
        head=new Node(null,null,null);
        N=0;
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    /**
     * put
     * @param key
     * @param value
     */
    public void put(K key,V value){
        if(isEmpty()){
            head.next=new Node(key,value,null);
            N++;
        }else{
            Node pre=head;
            //从小到大排序
            while (pre.next!=null){
                //当前节点对比
                int i = pre.next.key.compareTo(key);
                if(i==0){
                    pre.next.value=value;
                    return;
                }else if(i>0){
                    //当前节点比key大，key放当前节点前面
                    Node after = pre.next;
                    pre.next= new Node(key,value,after);
                    N++;
                    return;
                }else{
                    //当前节点比key小，key继续向后
                    pre=pre.next;
                }
            }
            //表中没有节点比key大，可以放最后
            pre.next=new Node(key,value,null);
            N++;
            return;
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
                Node after = pre.next.next;
                Node remove = pre.next;
                pre.next=after;
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
            System.out.println("key="+pre.next.key+",value="+ pre.next.value);
            pre = pre.next;
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
