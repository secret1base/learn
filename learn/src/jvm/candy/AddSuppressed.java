package jvm.candy;

/**
 * 压制异常功能演示
 * @author: wyj
 * @date: 2020/07/01
 */
public class AddSuppressed implements AutoCloseable{
    @Override
    public void close() throws Exception {
        throw new Exception("close异常");
    }

    public static void main(String[] args) {
        try(AddSuppressed as= new AddSuppressed();) {
            int i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

