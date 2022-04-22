package arithmetic;

/**
 * 堆排序实现
 * 1、让数组从底部开始上浮，实现最大堆结构
 * 2、让堆顶和堆底的元素交换位置，然后排除掉堆底的元素后，重新进行上浮
 * 3、重复前面的两部操作，直到堆中没有元素位置，这时数组就是从小到达排序的
 * @author: wyj
 * @date: 2022/04/22
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] sort = heapSort(new int[]{3, 7, 10, 2, 9, 6, 4, 8, 1, 2, 4, 64});
        for (int i : sort) {
            System.out.println(i);
        }
    }
    public static int[] heapSort(int[] arr){
        //1.假设数组是二叉树结构的,堆的数组的第一个元素是不会使用的
        //创建一个数组
        int[] heap=new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            heap[i+1]=arr[i];
        }

        int begin=heap.length-1;
        //2.从叶子节点开始让元素上浮,全部上浮结束后，就是堆结构的数组了
        changeToHeap(heap, begin);
        //当前交换的索引位置
        for (int i=begin;i>0;i--){
            //3.取出堆顶的元素和数组中最后一个元素交换位置，那么数组的最后一个元素就是最大值了，然后重新调整堆的结构
            swap(heap,1,i);
            changeToHeap(heap,i-1);
        }
        return heap;
    }

    private static void changeToHeap(int[] heap, int begin) {
        for (int i = begin; i >0; i--) {
            //当前节点除以2就是上级节点的位置
            int a = i / 2;
            //父结点必须大于0因为0不是父结点
            if(a>0&&heap[i]>heap[a]){
                //如果当前叶子节点比父级节点大，就交换位置
                swap(heap,a,i);
            }
        }
    }

    private static void swap(int[] heap, int a, int i) {
        int temp=heap[a];
        heap[a]=heap[i];
        heap[i]=temp;
    }

}
