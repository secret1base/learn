package datastructure;

/**
 * 最大优先队列(最大堆结构):最大先出
 * @author: wyj
 * @date: 2020/06/17
 */
public class MaxPriorityQueue<T extends Comparable> {
    private T[] elements;
    private int N;

    public MaxPriorityQueue(int size){
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
            if(less(n/2,n)){
                swap(n/2,n);
                n=n/2;
            }else{
                break;
            }
        }
    }

    private void swap(int i, int n) {
        T temp=elements[i];
        elements[i]=elements[n];
        elements[n]=temp;
    }

    private boolean less(int i, int n) {
        return elements[i].compareTo(elements[n])<0;
    }

    private void resize(int i) {
        T[] temps=(T[])new Comparable[i];
        for(int k=1;k<N;k++){
            temps[k]=elements[k];
        }
        elements=temps;
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        T dequeue = elements[1];
        swap(1,N-1);
        N--;
        sink(1);
        return dequeue;
    }

    private void sink(int i) {
        while (i*2<N){
            int maxSonIndex;
            if(i*2+1<N){
                if(less(i*2+1,i*2)){
                    maxSonIndex=i*2;
                }else{
                    maxSonIndex=i*2+1;
                }
            }else{
                maxSonIndex=i*2;
            }
            if(less(i,maxSonIndex)){
                swap(i,maxSonIndex);
                i=maxSonIndex;
            }else{
                break;
            }
        }
    }
}
