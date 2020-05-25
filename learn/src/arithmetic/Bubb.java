package arithmetic;

/**
 * 冒泡排序
 * @author: wyj
 * @date: 2020/05/25
 */
public class Bubb {
    public static void main(String[] args) {
        int[] sort = new Bubb().sort(new int[]{6, 5, 4, 32, 1, 10, 20});
        for (int i : sort) {
            System.out.println(i);
        }
    }

    public int[] sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
