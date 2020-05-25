package datastructure;

/**
 * 最大堆
 * @author: wyj
 * @date: 2020/05/21
 */
public class Heap<T extends Comparable<T>> {
    private T[] elements;
    private int N;//索引从1开始，0不使用
    public Heap(int size){
        elements= (T[]) new Comparable[size];
        N=1;
    }

    public boolean isEmpty(){
        return N==1;
    }
    //动态扩容、新增、删除、遍历、获取当前数组、按从小到大获取
    public void add(T v){
        if(N==elements.length){
            resize(elements.length*2);
        }
        elements[N]=v;
        swim(N);
        N++;
    }

    private void swim(int n) {
        while (n/2>1){
            if(less(n,n/2)){
                swap(elements,n,n/2);
            }
            n=n/2;
        }
    }

    private void resize(int i) {
        T[] temps= (T[]) new Comparable[i];
        for(int k=0;k<N;k++){
            temps[k]= elements[k];
        }
    }

    public T delMax(){
        swap(elements,1,N-1);
        T max = elements[N-1];
        N--;
        sink(1);
        return max;
    }

    private void sink(int i) {
        while (i*2<N){
            if(i*2+1<N){
                if(less(i*2,i*2+1)){
                    //右子节点大
                    if(less(i,i*2+1)){
                        swap(elements,i,i*2+1);
                        i=i*2+1;
                    }else{
                        break;
                    }
                }else{
                    //左子节点大
                    if(less(i,i*2)){
                        swap(elements,i,i*2);
                        i=i*2;
                    }else{
                        break;
                    }
                }
            }
        }
    }

    private void swap(T[] elements, int a, int b) {
        T element=elements[a];
        elements[a]=elements[b];
        elements[b]=element;
    }

    public boolean less(int a,int b){
        return elements[a].compareTo(elements[b])<0;
    }

    public Comparable[] getArr(){
        return elements;
    }

}
