package jvm.candy;

/**
 * @author: wyj
 * @date: 2020/07/01
 */
public class SwitchEnum {
    public static void method(Sex sex) {
        switch (sex){
            case MAN:{
                System.out.println("nan");
                break;
            }
            case WOMAN:{
                System.out.println("nv");
                break;
            }
        }
    }
}

enum Sex{
    MAN,WOMAN,OTHER
}