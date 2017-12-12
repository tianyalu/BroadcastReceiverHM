package com.sty.broadcast.receiver.specialreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Steven.T on 2017/12/12/0012.
 */

public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //1.获取当前广播事件的类型
        String action = intent.getAction();
        //2.对当前广播事件类型作一个判断
        if("android.intent.action.SCREEN_OFF".equals(action)){
            Log.i("Tag", "屏幕锁屏了");
        }else{
            Log.i("Tag", "屏幕解锁了");
        }
    }
}
