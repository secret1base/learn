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
    public static int[] sort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
