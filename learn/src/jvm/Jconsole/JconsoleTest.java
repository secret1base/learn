package jvm.Jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * jconsole监控
 * cmd输入:jconsole
 * @author: wyj
 * @date: 2020/05/26
 */
public class JconsoleTest {
    /**全局变量在对象被回收前始终存在，可以看到堆内存在程序执行结束前始终处于上升状态*/
    public byte[] bytes=new byte[128*1024];
    JconsoleTest(){
        /**
         * 局部变量在构造方法JconsoleTest执行完毕后就处于待回收状态
         * 通过jconsole可以看到堆内存是一个增长、下降、增长、下降的折线图
         */
//         byte[] bytes=new byte[128*1024];
    }
    public static void main(String[] args) {
        while (true){
            System.out.println("开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fill(1000);
        }
    }

    private static void fill(int i) {
        List<JconsoleTest> list=new ArrayList<>();
        for (int k=0;k<i;k++){
            list.add(new JconsoleTest());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
