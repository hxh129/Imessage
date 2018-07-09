package com.hxh.isgapp.retention;

import android.annotation.IntDef;

import com.hxh.isgapp.R;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hxh on 2018/7/4.
 */

public class TestA {

    public static final int STATUS_A =1;
    public static final int STATUS_B =2;

    public static int sStatus;
    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.PARAMETER)
    @IntDef({STATUS_A,STATUS_B})
    public @interface Status{

    }

    public static void setStatus(@Status int status) {
        sStatus = status;
    }
    public static String getStaus(){
        if(sStatus == STATUS_A){
            return "A";
        }else if(sStatus == STATUS_B){
            return "B";
        }else
            return "c";
    }
}
