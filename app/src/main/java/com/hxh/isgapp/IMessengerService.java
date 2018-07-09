package com.hxh.isgapp;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * Created by hxh on 2018/5/30.
 */

public class IMessengerService extends Service {
    private static final String TAG = "ImessagerService";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.d(TAG, msg.getData().getString("key"));
                    Messenger client = msg.replyTo;
                    Message message = new Message();
                    message.what =2;
                    Bundle bundle = new Bundle();
                    bundle.putString("service","我是服务端，我回复你");
                    message.setData(bundle);
                    try {
                        Thread.sleep(10000);
                        client.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    final Messenger messenger = new Messenger(new MessengerHandler());
}
