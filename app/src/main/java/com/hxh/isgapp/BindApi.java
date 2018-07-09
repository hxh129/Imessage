package com.hxh.isgapp;

import android.app.Activity;
import android.view.View;

import com.hxh.isgapp.retention.FindView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hxh on 2018/7/5.
 */

public class BindApi {
    public static void bindId(final Activity obj) {
        //使用反射调用setContentView
        Class<?> cls = obj.getClass();
//        if (cls.isAnnotationPresent(InjectLayout.class)) {
//            InjectLayout mId = cls.getAnnotation(InjectLayout.class);
//            int id = mId.value();
//            obj.setContentView(id);
//        }


        // 使用反射调用findViewById
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FindView.class)) {
                FindView mId = field.getAnnotation(FindView.class);
                if (mId == null) {
                    continue;//如果该方法上没有注解，循环下一个
                }
                int viewId = mId.value();
                View view = obj.findViewById(viewId);
                field.setAccessible(true);
                try {
                    field.set(obj, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // 使用反射调用setOnclick
//        Method[] methods = cls.getDeclaredMethods();
//        for (final Method method : methods) {
//            InjectClick mClick = method.getAnnotation(InjectClick.class);
//            if (mClick == null) {
//                continue;
//            }
//
//            int[] values = mClick.value();
//            for (int i = 0; i < values.length; i++) {
//                int clickId = values[i];
//                final View mView = obj.findViewById(clickId);
//                mView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        try {
//                            method.invoke(obj, mView);//反射调用用户设定的方法
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                        } catch (InvocationTargetException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//        }

    }
}
