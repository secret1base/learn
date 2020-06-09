package jvm.jvmtest;

/**
 * 堆内存诊断分析
 * @date: 2020/06/09
 */
public class HeapMemoryDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1....");
        Thread.sleep(30000);// 输入 jps获取进程id  ，输入jmap -heap 进程id
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println("2....");
        Thread.sleep(30000);//输入jmap -heap 进程id
        bytes=null;
        System.gc();
        System.out.println("3....");
        Thread.sleep(1000000L);//输入jmap -heap 进程id
    }
}
