package datastructure;

import java.util.Iterator;

/**
 * 顺序表
 * @author: wyj
 * @date: 2020/05/20
 */
public class SeqList<T> implements Iterable<T>{
    private T[] elesments;
    private int N;
    public SeqList(int size){
        elesments=(T[])new Object[size];
        N=0;
    }
    public void add(T v){
        if(N==elesments.length){
            resize(elesments.length*2);
        }
        elesments[N++]=v;
    }

    public void insert(int i,T v){
        if(i<0||i>=N){
            throw new RuntimeException("指定位置索引不存在");
        }
        if(N==elesments.length){
            resize(elesments.length*2);
        }
        //移动
        for(int k=N-1;k>=i;k--){
            elesments[k+1]=elesments[k];
        }
        elesments[i]=v;
        N++;
    }

    private void resize(int i) {
        T[] temps= (T[])new Object[i];
        for(int k=0;k<N;k++){
            temps[k]=elesments[k];
        }
        elesments=temps;
    }

    public T remove(int i){
        if(i<0||i>=N){
            throw new RuntimeException("不存在");
        }
        T elesment = elesments[i];
        for (int k=i;k<N-1;k++){
            elesments[k]=elesments[k+1];
        }
        N--;
        if(N<elesments.length/4){
            resize(elesments.length/2);
        }
        return elesment;
    }
    public int size(){
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new SeqIterator();
    }

    private class SeqIterator implements Iterator{
        private int curr;
        SeqIterator(){
            this.curr=0;
        }

        @Override
        public boolean hasNext() {
            return curr<N;
        }

        @Override
        public T next() {
            return elesments[curr++];
        }
    }

}