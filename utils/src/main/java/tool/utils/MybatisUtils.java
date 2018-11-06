package tool.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 描述:业务实体转换为mybatis的example
 *
 * @author Red
 * @version 1.0
 * @DATE: 2017/06/12 11:39
 */
public class MybatisUtils {

    /**
     * 将obj转成Mybatis Example, 目前只支持=操作
     *
     * @param obj
     * @param example
     * @param <T>
     * @return
     */
    public static <T> T convertObj2Example(Object obj, T example) {
        Object criteria = Reflections.invokeMethodByName(example, "createCriteria", new Object[]{});
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            if (field.getAnnotation(NotSqlProperty.class) != null) {
                continue;
            }
            Object value = Reflections.getFieldValue(obj, field.getName());
            if (value != null) {
                String name = StringUtils.capitalize(field.getName());
                Reflections.invokeMethodByName(criteria, "and" + name + "EqualTo", new Object[]{value});
            }
        }
        //针对有逻辑删除的表, 自动加上delete_flag = 0
        Method deleteFlagMethod = Reflections.getAccessibleMethodByName(criteria, "andDeleteFlagEqualTo");
        if (deleteFlagMethod != null) {
            Reflections.invokeMethodByName(criteria, "andDeleteFlagEqualTo", new Object[]{(short) 0});
        }
        return example;
    }
    public static <T> T convertObj2Criteria(Object obj, T criteria) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            if (field.getAnnotation(NotSqlProperty.class) != null) {
                continue;
            }
            Object value = Reflections.getFieldValue(obj, field.getName());
            if (value != null) {
                String name = StringUtils.capitalize(field.getName());
                Reflections.invokeMethodByName(criteria, "and" + name + "EqualTo", new Object[]{value});
            }
        }

        return criteria;
    }
    /*public static <T> Object createCriteria4Query(Object obj, T example) {
        Object criteria = Reflections.invokeMethodByName(example, "createCriteria", new Object[]{});
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            if (field.getAnnotation(NotSqlProperty.class) != null) {
                continue;
            }
            Object value = Reflections.getFieldValue(obj, field.getName());
            if (value != null) {
                String name = StringUtils.capitalize(field.getName());
                Reflections.invokeMethodByName(criteria, "and" + name + "EqualTo", new Object[]{value});
            }
        }
        //针对有逻辑删除的表, 自动加上delete_flag = 0
        Method deleteFlagMethod = Reflections.getAccessibleMethodByName(criteria, "andDeleteFlagEqualTo");
        if (deleteFlagMethod != null) {
            Reflections.invokeMethodByName(criteria, "andDeleteFlagEqualTo", new Object[]{(short) 0});
        }
        return criteria;
    }*/
}
