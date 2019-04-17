package com.guoj.learningdemo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Created by guoj on 2019/4/17.
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Viewinject {
    int mainlayoutid() default -1;
}
