package tool.utils;

import java.lang.annotation.*;

/**
 **	非SQL字段对应的属性注释
 ** @author:red
 **
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotSqlProperty {

	String value() default "";
}
