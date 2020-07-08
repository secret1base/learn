package jvm.jvmtest;

/**
 * 方法内联测试
 * @author: wyj
 * @date: 2020/07/08
 */
public class inlining {
    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            long a = System.nanoTime();
            int m=0;
            for (int j=0;j<10000;j++){
                m = multiplication(8, 9);
            }
            long b = System.nanoTime();
            System.out.printf("time:%s,value:%s\n" , b-a,m);
        }
    }
    private static int multiplication(final int a,final int b){
        return a*b;
    }

}
