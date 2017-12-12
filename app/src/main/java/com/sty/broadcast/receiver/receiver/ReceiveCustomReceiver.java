package com.sty.broadcast.receiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Steven.T on 2017/12/12/0012.
 * 自定义广播接收器
 */

public class ReceiveCustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //1.取出发送的广播中携带的数据
        String content = intent.getStringExtra("name");
        //2.把获取到的数据展示到Toast上
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
