package datastructure;

import java.util.Iterator;

/**
 * @author: wyj
 * @create: 2020-05-20 14:00
 */
public class SeqList<T> implements Iterable<T>{
    private T[] elements;
    private int index;

    /**
     * 初始化
     * @param i
     */
    public SeqList(int i){
        this.elements= (T[]) new Object[i];
        this.index=0;
    }

    //新增
    public void insert(T a){
        if(index==elements.length){
            resize(elements.length*2);
        }
        elements[index++]=a;
    }

    //插入新增
    public void insert(int i,T a){
        if(index==elements.length){
            resize(elements.length*2);
        }
        //移动i及i后面的元素
        for(int k=index;k>i;k--){
            elements[k]=elements[k-1];
        }
        elements[i]=a;
        index++;
    }
    //扩容缩容
    private void resize(int i) {
        T[] temps=(T[])new Object[i];
        for(int k=0;k<index;k++){
            temps[k]=elements[k];
        }
        elements=temps;
    }

    //指定删除
    public void remove(int i){
        for(int k=i;k<index-1;k++){
            elements[k]=elements[k+1];
        }
        index--;
    }
    //遍历
    @Override
    public Iterator iterator() {
        return new SeqIterator();
    }
    private class SeqIterator implements Iterator<T>{
        private int cursor;
        public SeqIterator(){
            this.cursor=0;
        }
        @Override
        public boolean hasNext() {
            return this.cursor<index;
        }

        @Override
        public T next() {
            return elements[cursor++];
        }
    }
}
