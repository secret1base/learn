package jvm.candy;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 反射获取泛型的类型
 * @author: wyj
 * @date: 2020/06/30
 */
public class ReflectCandy {
    public Set<Integer> test(List<String> list, Map<Integer, Object> map) {
        return null;
    }
    public static void main(String[] args) throws NoSuchMethodException {
        Method test = ReflectCandy.class.getMethod("test", List.class, Map.class);
        Type[] types = test.getGenericParameterTypes();
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println("原始类型 - " + parameterizedType.getRawType());
                Type[] arguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < arguments.length; i++) {
                    System.out.printf("泛型参数[%d] - %s\n", i, arguments[i]);
                }
            }
        }
    }
}
