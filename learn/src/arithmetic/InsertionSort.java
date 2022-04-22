package arithmetic;

/**
 * 插入排序
 * @author: wyj
 * @date: 2020/06/15
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] sort = sort(new int[]{3, 7, 10, 2, 9, 6, 4, 8, 1, 2, 4, 64});
        for (int i : sort) {
            System.out.println(i);
        }
    }


    /**
     * 插入排序:
     * 1、数组分为未排序的数组和已排序的数组
     * 2、然后从未排序数组中取出待插入元素，让已排序数组进行倒序遍历，直到当前元素比当前元素小，然后将待插入元素放到待插入元素后面，一直到最后一个元素为止
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        //代码的具体实现和插入排序的思想在细节上有区别
        for(int i=0;i<arr.length;i++){
            for (int j = i; j >0; j--) {
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }

}
