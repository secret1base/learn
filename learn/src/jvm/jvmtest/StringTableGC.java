package jvm.jvmtest;


/**
 * 字符串常量池的垃圾回收
 * -Xmx10m 最大堆内存 -XX:+PrintStringTableStatistics 打印字符串统计信息
 * -XX:+PrintGCDetails -verbose:gc 打印垃圾回收信息
 */
public class StringTableGC {
    public static void main(String[] args) {
        int i=0;
        try{
            for(;i<10000;i++){
                String.valueOf(i).intern();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
