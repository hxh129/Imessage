package com.hxh.client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private Messenger messenger;
    private String TAG = "MainActivityClient";
    private TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHello = findViewById(R.id.tv_hello);
        findViewById(R.id.tv_go_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestMeregeActivity.class));
            }
        });
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = Message.obtain();
                message.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("key", "我来自客户端");
                message.replyTo = clientMessenger;
                message.setData(bundle);
                try {
                    messenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        Intent intent = new Intent();
        intent.setAction("com.hxh.isgapp.IMessengerService");
        intent.setPackage("com.hxh.isgapp");
//        intent.setComponent(new ComponentName("com.hxh.isgapp","com.hxh.isgapp.IMessengerService"));
//        bindService(intent, connection, BIND_AUTO_CREATE);
        getWindow().clearContentView();
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            if (binder == null) return;
            messenger = new Messenger(binder);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    class ClientHandler extends Handler {
        private WeakReference<MainActivity> activity;

        public ClientHandler(MainActivity mainActivity) {
            activity = new WeakReference<MainActivity>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 2:
                    Log.d(TAG, msg.getData().getString("service"));
                    Toast.makeText(activity.get(), msg.getData().getString("service"), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    Messenger clientMessenger = new Messenger(new ClientHandler(this));
}
