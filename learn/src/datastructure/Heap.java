package datastructure;

/**
 * 最大堆:动态扩容、新增、删除、取最大值
 * less、exchange、delMax、insert、swim、sink
 * @author: wyj 有问题 备份下
 * @date: 2020/05/21
 */
public class Heap<T extends Comparable<T>> {
    private T[] elements;
    private int N;
    public Heap(int size){
        elements=(T[])new Comparable[size+1];
        N=1;
    }

    public boolean isEmpty(){
        return N==1;
    }

    public int size(){
        return N-1;
    }

    public void add(T item){
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
        T[] temps = (T[])new Comparable[i];
        for (int k=1;k<N;k++){
            temps[k]=elements[k];
        }
        elements=temps;
    }

    public T delMax(){
        if(isEmpty()){
            return null;
        }
        swap(1,N-1);
        N--;
        T del = elements[N];
        sink(1);
        return del;
    }

    private void sink(int i) {
        while (2*i<N){
            int maxSonIndex;
            if(2*i+1<N){
                if(less(2*i,2*i+1)){
                    maxSonIndex=2*i+1;
                }else{
                    maxSonIndex=2*i;
                }
            }else{
                maxSonIndex=2*i;
            }
            if(less(i,maxSonIndex)){
                swap(i,maxSonIndex);
                i=maxSonIndex;
            }else{
                break;
            }
        }
    }

    public boolean isHeap(){
        for (int i=N-1;i/2>1;i--){
            if(elements[i].compareTo(elements[i/2])>0){
                return false;
            }
        }
        return true;
    }

}
