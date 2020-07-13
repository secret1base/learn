package datastructure;

/**
 * 最大索引队列
 * @author: wyj
 * @date: 2020/06/19
 */
public class MaxIndexPriorityQueue<T extends Comparable<T>> {
    /**普通数组*/
    private T[] arr;
    /**堆结构索引数组*/
    private int[] indexArr;
    /**反向索引数组*/
    private int[] reverseArr;
    private int N;

    /**
     * 用于验证是否为堆结构
     * @return
     */
    public T[] getArr(){
        return arr;
    }
    public int[] getIndexArr(){
        return indexArr;
    }
    public int[] getReverseArr(){
        return reverseArr;
    }


    public MaxIndexPriorityQueue(int size){
        arr = (T[])new Comparable[size];
        indexArr=new int[size+1];
        reverseArr=new int[size];
        for (int i=0;i<reverseArr.length;i++){
            reverseArr[i]=-1;
        }
        N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void enqueue(T item){
        if(N>=arr.length){
            resize(arr.length*2);
        }
        int currIndex=N+1;
        arr[N]=item;
        indexArr[currIndex]=N;
        reverseArr[N]=currIndex;
        N++;
        swim(currIndex);
    }

    private void swim(int currIndex) {
        while (currIndex/2>=1){
            if(less(currIndex/2,currIndex)){
                swap(currIndex/2,currIndex);
                currIndex=currIndex/2;
            }else{
                break;
            }
        }
    }

    private void resize(int i) {
        T[] temps=(T[])new Comparable[i];
        int[] pq=new int[i+1];
        int[] qp=new int[i];
        for (int k=0;k<arr.length;k++){
            temps[k]=arr[k];
        }
        for (int k=1;k<indexArr.length;k++){
            pq[k]=indexArr[k];
        }
        for (int k=0;k<i;k++){
            if(k<N){
                qp[k]=reverseArr[k];
            }else{
                qp[k]=-1;
            }
        }
        arr=temps;
        indexArr=pq;
        reverseArr=qp;
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        int i = indexArr[1];
        swap(1,N);
        N--;
        sink(1);
        return arr[i];
    }
    public T get(int i){
        if(i<0||i>=N){
            throw new RuntimeException("不存在对应索引");
        }
        return arr[indexArr[reverseArr[i]]];
    }

    private void sink(int i) {
        while (i*2<N+1){
            int maxIndex;
            if(i*2+1<N+1){
                if(less(i*2+1,i*2)){
                    maxIndex=i*2;
                }else{
                    maxIndex=i*2+1;
                }
            }else{
                maxIndex=i*2;
            }
            if(less(i,maxIndex)){
                swap(i,maxIndex);
                i=maxIndex;
            }else{
                break;
            }

        }
    }

    private boolean less(int a, int b) {
        return arr[indexArr[a]].compareTo(arr[indexArr[b]])<0;
    }

    private void swap(int i, int n) {
        int temp=indexArr[i];
        indexArr[i]=indexArr[n];
        indexArr[n]=temp;

        reverseArr[indexArr[i]]=i;
        reverseArr[indexArr[n]]=n;
    }


    public void update(int i,T item){
        if(i<0||i>=N){
            throw new RuntimeException("不存在此索引");
        }
        arr[i]=item;
        int k = reverseArr[i];
        sink(k);
        swim(k);
    }
}
