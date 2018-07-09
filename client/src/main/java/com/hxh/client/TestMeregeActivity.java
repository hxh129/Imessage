package com.hxh.client;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

/**
 * Created by hxh on 2018/6/20.
 */

public class TestMeregeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_merge);
//        findViewById(R.id.stub_import).setVisibility(View.VISIBLE);
        ((ViewStub)findViewById(R.id.stub_import)).inflate();
        String s = "1234";
    }
}
