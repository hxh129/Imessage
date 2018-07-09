package com.hxh.isgapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.internal.policy.PhoneWindow;
import com.google.android.collect.Maps;
import com.hxh.isgapp.retention.FindView;
import com.hxh.isgapp.retention.TestA;
import com.test.hxh.processor.annotations.BindView;
import com.test.hxh.processor.annotations.LCJViewBinder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @BindView( R.id.tv_hello_world)
    public TextView textView;

    @Override
    @SuppressWarnings("unchckedunchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PhoneWindow pw = (PhoneWindow) getWindow();
        pw.setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        LCJViewBinder.bind(this);
        textView.setText("测试" );
//        getWindow().setContentView(R.layout.actifvity_main);
//        HashMap<String, String> map = Maps.newHashMap();
//        HashMap<String, String> map1 = new HashMap<>();
//        LinearLayout linearLayout = findViewById(R.id.test_layout);
//        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.activity_main, linearLayout);
//        layoutInflater.inflate(R.layout.activity_main, linearLayout);layoutInflater.inflate(R.layout.activity_main, linearLayout);
//
//       LinearLayout linearLayout1 = view.findViewById(R.id.test_layout);
//        linearLayout1.addView(layoutInflater.from(this).inflate(R.layout.activity_main,null));
        try {

            Class classZ = Class.forName("com.hxh.isgapp.Test");
            Constructor c = classZ.getDeclaredConstructor(String.class,String.class);
            c.setAccessible(true);
            Object object =  c.newInstance("好好","差差");
            Method method;
            method = classZ.getDeclaredMethod("getString");
            method.setAccessible(true);

//            Method[] methods = classZ.getMethods();
//            for(Method m:methods) {
//                if (m.getName().equals("setContentView")&&m.getParameterTypes()[0].equals(int.class)) {
//                    Log.e("eadsdsds","findfidndddd");
//                    method.invoke(object,R.layout.activity_main);
//                    break;
//                }
//                Log.e("eadsdsds",m.getName());
//            }
            String s = (String) method.invoke(object);

//                View view = (View) method.invoke(object,R.layout.activity_main);
                Log.e("TAG",s.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        PhoneWindow pw = (PhoneWindow) getWindow();
//       pw.clearContentView();
        TestA.setStatus(111);
        Toast.makeText(this, TestA.getStaus(),Toast.LENGTH_SHORT).show();
    }
}
