package springmvc4.ch3;

/**
 * @author songjunbao
 * @createdate 2018/6/22
 */
public class ClazzTest {
    public static void main(String[] args) {
        String s = "songjunbao";
        Long l = 100L;
        boolean result = isSupportString(l);
        System.out.println(">>>result:" + result);

    }

    public static boolean isSupportString(Object obj){
        Class<?> c = obj.getClass();
        return String.class.isAssignableFrom(c);
    }

}
