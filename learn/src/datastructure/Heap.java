package datastructure;

/**
 * 最大堆
 * @author: wyj
 * @date: 2020/05/21
 */
public class Heap {
    private int[] arr;//堆的底层数组
    private int N;//记录索引

    public Heap(int size){
        this.arr=new int[size];
        N=0;
    }

    public void add(int v){
        arr[N++]=v;
        //结点上浮
        swim(N-1);
    }

    public int getMax(){
        int i = arr[0];
        if(N>0){
            //交换首尾节点位置
            swap(0,N-1);
            N--;
            //对根结点进行下沉
            sink(0);
        }else{
            N--;
        }
        return i;
    }

    public int size(){
        return N;
    }

    private void sink(int k) {
        if(2*k<N){
            if(2*k+1<N){
                if(arr[2*k]>arr[2*k+1]){
                    if(arr[k]<arr[2*k]){
                        swap(k,2*k);
                        sink(2*k);
                    }
                }else{
                    if(arr[k]<arr[2*k+1]){
                        swap(k,2*k+1);
                        sink(2*k+1);
                    }
                }
            }else{
                if(arr[k]<arr[2*k]){
                    swap(k,2*k);
                    sink(2*k);
                }
            }
        }
    }

    private void swim(int i) {
        if(i==0){
            return;//当本身为根结点时结束
        }
        if(arr[i]>arr[i/2]){
            swap(i,i/2);
        }
        swim(i/2);
    }

    private void swap(int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }


    /**
     * 堆是由完全二叉树构成的数组、
     * 完全二叉树的规则是，父节点永远比它的左右子节点大，
     * 左右子节点相互间的大小没有规律。
     * 某个结点k，他的父节点是k/2，左右子节点分别为2k和2k+1，
     * 新增元素时，是新增如当前数组的最小空白索引内。插入后对该节点进行结点的上浮，
     * 如果比父节点大则和父节点交换位置，一直到不再比父节点大为止。
     * 取值时一直从根结点进行取值，这样取出的数据就可以是按着从大小的顺序。
     * 从根结点取值时，根结点先和当前的最底部的右结点交换位置。
     * 交换位置后将该元素从堆中移除(记录用的索引-1)，然后根结点开始进行下沉操作。
     */
}
