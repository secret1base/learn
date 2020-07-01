package jvm.candy;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦除
 * javac -g:vars GenericErasure.java
 * javap -v GenericErasure.class
 * @author: wyj
 * @date: 2020/06/30
 */
public class GenericErasure {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        Integer integer = list.get(0);
    }
}
