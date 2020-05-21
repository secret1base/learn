package arithmetic;

/**
 * 快速排序
 * @author: wyj
 * @create: 2020-05-20 18:11
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] quick = new QuickSort().quick(new int[]{1, 4, 6, 32, 5, 7, 5, 3, 1});
        for (int i : quick) {
            System.out.println(i);
        }
    }
    public int[] quick(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int a=0;
        int b=arr.length-1;
        sort(arr,a,b);
        return arr;
    }

    private void sort(int[] arr, int leftBound, int rightBound) {
        if(leftBound>=rightBound){
            return;
        }
        int partition=partition(arr,leftBound,rightBound);
        sort(arr,leftBound,partition-1);
        sort(arr,partition+1,rightBound);
    }

    private int partition(int[] arr, int leftBound, int rightBound) {
        int pirvot=arr[rightBound];
        int left=leftBound;
        int right=rightBound-1;
        while (left<=right){
            while (left<=right&&arr[left]<=pirvot){
                left++;
            }
            while (left<=right&&arr[right]>pirvot){
                right--;
            }
            if(left<right){
                swap(arr,left,right);
            }
        }
        swap(arr,left,rightBound);
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}
