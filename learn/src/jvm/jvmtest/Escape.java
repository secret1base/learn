package jvm.jvmtest;

/**
 * 方法逃逸和线程逃逸
 * @author: wyj
 * @date: 2020/07/08
 */
public class Escape {
    public Object obj;
    public Object methodEscape1(){//方法逃逸(返回值)
        return new Object();
    }
    public void methodEscape2(){//方法逃逸(给全局变量赋值)
        obj=new Object();
    }

    public static void main(String[] args) {
        Escape escape = new Escape();
        escape.obj=10;
        Runnable runnable = () -> {
            for (int i=0;i<100;i++){
                try {
                    System.out.println(escape.obj);//线程逃逸(赋值给可以在其他线程中访问的实例变量)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
