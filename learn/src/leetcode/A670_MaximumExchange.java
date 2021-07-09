package leetcode;

/**
 * 670. 最大交换
 * @author: wyj
 * @date: 2021/06/29
 */
public class A670_MaximumExchange {
    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *  示例 1 :
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     *  示例 2 :
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换。
     *
     * 		执行耗时:4 ms,击败了14.71% 的Java用户
     * 		内存消耗:35.1 MB,击败了76.48% 的Java用户
     */
    public int maximumSwap(int num) {
        //7546
        String s = Integer.toString(num);
        String[] arr = s.split("");

        //找到破坏降序排列的数，然后去找到最大的数，接着从前向后找到比这个数小的数两者交换位置
        for (int i = 0; i < arr.length; i++) {
            //在这里可以直接用字符串比较是因为他们都是小于10的数，找到破坏降序排列的数
            if(i+1<arr.length&&arr[i].compareTo(arr[i+1])<0){
                int maxIndex=i+1;
                for(int j=i+1;j<arr.length;j++){
                    //这里写了个=号是因为，maxIndex的位置越靠后越好
                    if(arr[j].compareTo(arr[maxIndex])>=0){
                        maxIndex=j;
                    }
                }
                //从前向后找到比maxIndex小的数，交换位置
                for (int a=0;a<maxIndex;a++){
                    if(arr[a].compareTo(arr[maxIndex])<0){
                        String tmp = arr[a];
                        arr[a]=arr[maxIndex];
                        arr[maxIndex]=tmp;
                        StringBuilder sb=new StringBuilder();
                        for (String s1 : arr) {
                            sb.append(s1);
                        }
                        return Integer.parseInt(sb.toString());
                    }
                }
            }
        }
        return num;
    }
}
