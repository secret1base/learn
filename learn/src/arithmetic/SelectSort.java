package arithmetic;

/**
 * 选择排序
 * @author: wyj
 * @date: 2020/05/25
 */
public class SelectSort {
    public int[] selectSort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            if(i!=min){
                int tmp=arr[min];
                arr[min]=arr[i];
                arr[i]=tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = new SelectSort().selectSort(new int[]{3, 1, 3, 6, 7, 2, 10, 7, 8});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
