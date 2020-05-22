package arithmetic;

/**
 * @author: wyj
 * @date: 2020/05/21
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints = new MergeSort().mergeSort(new int[]{3, 7, 10, 2, 9, 6, 4, 8, 1, 2, 4, 64});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] mergeSort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int a=0;
        int b=arr.length-1;
        sort(arr,a,b);
        return arr;
    }
    private void sort(int[] arr,int leftBound,int rightBound){
        if(leftBound>=rightBound){
            return;
        }
        int mid=(leftBound+rightBound)/2;
        sort(arr,leftBound,mid);
        sort(arr,mid+1,rightBound);
        merge(arr,leftBound,mid,rightBound);
    }

    private void merge(int[] arr,int leftBound,int mid,int rightBound){
        int left=leftBound;
        int right=mid+1;
        int[] temps=new int[arr.length];
        int index=leftBound;
        while(left<=mid&&right<=rightBound){
            if(arr[left]<arr[right]){
                temps[index++]=arr[left++];
            }else{
                temps[index++]=arr[right++];
            }
        }
        while(left<=mid){
            temps[index++]=arr[left++];
        }
        while(right<=rightBound){
            temps[index++]=arr[right++];
        }
        for(int i=leftBound;i<=rightBound;i++){
            arr[i]=temps[i];
        }
    }
}
