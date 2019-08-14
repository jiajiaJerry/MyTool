package com.jiajia.jerry_annotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : jerry
 * @date : 2018/7/21 22:05
 */
@Target(ElementType.TYPE) //这个注解告诉编译器我们这个注解使用在类上面的
@Retention(RetentionPolicy.SOURCE) //这个注解告诉编译器我们在源码阶段处理注解
public @interface EntryGenerator {

    String packageName();

    Class<?> entryTemplete();
}
