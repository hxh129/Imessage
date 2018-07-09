package com.hxh.isgapp.retention;

import android.annotation.SuppressLint;
import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by hxh on 2018/7/4.
 */
@Retention(CLASS)
@Target(value = ElementType.FIELD)
public @interface FindView {
    @IdRes int value();
}
