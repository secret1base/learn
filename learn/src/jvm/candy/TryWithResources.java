package jvm.candy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: wyj
 * @date: 2020/07/01
 */
public class TryWithResources {
    public static void main(String[] args) {
        try(InputStream is=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\jvm.options")){
            System.out.println(is.available());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
