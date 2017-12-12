package com.sty.broadcast.receiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.sty.broadcast.receiver.MainActivity;

/**
 * Created by Steven.T on 2017/12/12/0012.
 * 手机开机时启动MainActivity
 */

public class BootReceiver extends BroadcastReceiver {
    //手机重启时执行这个方法
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, MainActivity.class);
        //如果在广播里面开启Activity 需要设置一个任务栈环境
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent2);
    }
}
