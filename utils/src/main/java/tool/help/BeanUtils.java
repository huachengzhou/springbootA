package tool.help;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class BeanUtils {

    /**
     * 根据属性名获取属性值
     */
    protected Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            // log.error(e.getMessage(), e);
            return null;
        }
    }

    public Class<MimeTypeUtils> getMimeTypeUtilsClass(){
        return MimeTypeUtils.class;
    }

    /**
     *
     * @param field 类字段 (必须是public修饰符的字段名称)
     * @param target 对象
     * @return 对象属性value
     */
    public static Object getFieldValue(Field field, Object target){
        return ReflectionUtils.getField(field, target);
    }

    /**
     *
     * @param clazz
     * @param name (必须是public修饰符的字段名称)
     * @return
     */
    public static Field findField(Class<?> clazz, String name){
        return ReflectionUtils.findField(clazz, name);
    }

    /**
     *
     * @param clazz
     * @param name 所有修饰符都可以
     * @return
     */
    public static Field getField(Class<?> clazz, String name){
        try {
            Field field = clazz.getDeclaredField(name);
            if (!ObjectUtils.isEmpty(field)){
                return field;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author zch
     * @Time 2018年7月6日 下午5:14:25
     * @Description <p>获取到对象中属性为null的属性名  </P>
     * @param source 要拷贝的对象
     * @return
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
    /**
     * @author zch
     * @Time 2018年7月6日 下午5:14:25
     * @Description <p> 拷贝非空对象属性值 </P>
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }
}
