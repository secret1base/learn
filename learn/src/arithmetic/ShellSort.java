package arithmetic;

/**
 * 希尔排序
 * @author: wyj
 * @date: 2020/05/25
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] shell = new ShellSort().shell(new int[]{7, 23, 1, 2, 5, 8, 5, 32, 66, 31, 2, 657, 432, 23, 123});
        for (int i : shell) {
            System.out.println(i);
        }
    }
    public int[] shell(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int a=0;
        int b=arr.length-1;
        int d=a+(b-a)/2;
        while (d>=1){
            for(int i=d;i<arr.length;i++){
                for(int j=i;j>=d;j-=d){
                    if(arr[j-d]>arr[j]){
                        int temp=arr[j-d];
                        arr[j-d]=arr[j];
                        arr[j]=temp;
                    }else{
                        break;
                    }
                }
            }
            d=d/2;
        }
        return arr;
    }
}
