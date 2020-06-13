package jvm.jvmtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * io和nio的速度对比
 * @author: wyj
 * @date: 2020/06/12
 */
public class IOAndNIO {
    static final String FROM="D:\\BaiduNetdiskDownload\\zz.mp4";//1.4G
    static final String TOIO="C:\\Users\\Lenovo\\Desktop\\zz\\a.mp4";
    static final String TONIO="C:\\Users\\Lenovo\\Desktop\\zz\\b.mp4";
    static final int _1Mb=1024*1024;
    public static void main(String[] args) {
        directBuffer();//9574.9283
//        io();//12783.813
    }
    /**
     * NIO直接内存读取写入
     */
    private static void directBuffer(){
        long start = System.nanoTime();
        try(FileChannel from=new FileInputStream(FROM).getChannel();
            FileChannel to=new FileOutputStream(TONIO).getChannel()
        ){
            ByteBuffer bb=ByteBuffer.allocateDirect(_1Mb);
            while (true){
                int len=from.read(bb);
                if(len==-1){
                    break;
                }
                bb.flip();
                to.write(bb);
                bb.clear();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("directBuffer用时:"+(end-start)/1000_000.0);
    }

    private static void io(){
        //纳秒
        long start = System.nanoTime();
        try(FileInputStream from=new FileInputStream(FROM);
            FileOutputStream to=new FileOutputStream(TOIO);
        ){
            byte[] buf=new byte[_1Mb];
            while (true){
                int len=from.read(buf);
                if(len==-1){
                    break;
                }
                to.write(buf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long end=System.nanoTime();
        System.out.println("io用时:"+(end-start)/1000_000.0);
    }
}
