package com.icefrog.strollit.baseframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredLogin {
    
    /***
     * 若为true则表示必须登录，反之可不需登录。 默认true
     */
    boolean required() default true;
    
}