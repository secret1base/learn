package datastructure;

/**
 * 最小优先队列(最小堆结构):最小先出
 * @author: wyj
 * @date: 2020/06/18
 */
public class MinPriorityQueue<T extends Comparable> {
    private T[] elements;
    private int N;
    public MinPriorityQueue(int size){
        elements=(T[])new Comparable[size+1];
        N=1;
    }

    public boolean isEmpty(){
        return N==1;
    }

    public int size(){
        return N-1;
    }

    public void enqueue(T item){
        if(N>elements.length-1){
            resize(elements.length*2);
        }
        elements[N]=item;
        swim(N);
        N++;
    }

    private void swim(int n) {
        while (n/2>=1){
            if(less(n,n/2)){
                swap(n,n/2);
                n=n/2;
            }else{
                break;
            }
        }
    }

    private void resize(int i) {
        T[] temps=(T[])new Comparable[i];
        for (int k=1;k<N;k++){
            temps[k]=elements[k];
        }
        elements=temps;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        T deq = elements[1];
        swap(1,N-1);
        N--;
        sink(1);
        return deq;
    }

    private void sink(int i) {
        while (i*2<N){
            int minSonIndex;
            if(i*2+1<N){
                if(less(i*2+1,i*2)){
                    minSonIndex=i*2+1;
                }else{
                    minSonIndex=i*2;
                }
            }else{
                minSonIndex=i*2;
            }
            if(less(minSonIndex,i)){
                swap(i,minSonIndex);
                i=minSonIndex;
            }else {
                break;
            }
        }
    }

    private boolean less(int i, int i1) {
        return elements[i].compareTo(elements[i1])<0;
    }

    private void swap(int i, int i1) {
        T temp=elements[i];
        elements[i]=elements[i1];
        elements[i1]=temp;
    }
}
