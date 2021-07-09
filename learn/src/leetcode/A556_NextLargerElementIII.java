package leetcode;

/**
 * 556. 下一个更大元素 III
 * @author: wyj
 * @date: 2021/06/29
 */
public class A556_NextLargerElementIII {
    /**
     * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
     *  注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
     *  示例 1：
     * 输入：n = 12
     * 输出：21
     *  示例 2：
     * 输入：n = 21
     * 输出：-1
     * 		执行耗时:4 ms,击败了43.07% 的Java用户
     * 		内存消耗:35.5 MB,击败了15.57% 的Java用户
     */
    public int nextGreaterElement(int n) {
        try {
            String s = Integer.toString(n);
            String[] split = s.split("");
            int[] arr=new int[split.length];
            for (int i = 0; i < split.length; i++) {
                arr[i]=Integer.parseInt(split[i]);
            }
            //从后向前找到破坏降序排列的数，替换比这个数大一点的数后，对当前位置后面进行升序排列
            for (int i = arr.length-1; i >=0; i--) {
                if(i-1>=0&&arr[i]>arr[i-1]){
                    //后面的比前面的大破坏
                    for (int j = arr.length - 1; j >i-1; j--) {
                        if(arr[j]>arr[i-1]){
                            int tmp = arr[j];
                            arr[j]=arr[i-1];
                            arr[i-1]=tmp;
                            //i-1后面的进行升序排列
                            for (int a=i;a<arr.length;a++){
                                for (int b = a+1; b <arr.length; b++) {
                                    if(arr[a]>arr[b]){
                                        int num = arr[a];
                                        arr[a]=arr[b];
                                        arr[b]=num;
                                    }
                                }
                            }
                            StringBuilder sb=new StringBuilder();
                            for (int i1 : arr) {
                                sb.append(i1);
                            }
                            return Integer.parseInt(sb.toString());
                        }
                    }
                }
            }
        }catch (Exception e){
            //超出int限制就return-1
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new A556_NextLargerElementIII().nextGreaterElement(2147483486);
        System.out.println(i);
    }
}
