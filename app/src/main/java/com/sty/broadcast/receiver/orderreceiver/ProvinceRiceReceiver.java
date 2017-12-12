package com.sty.broadcast.receiver.orderreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Steven.T on 2017/12/12/0012.
 */

public class ProvinceRiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //1.获取到发送广播得到的数据
        String content = getResultData();
        //2.展示到Toast上
        Toast.makeText(context, "省：" + content, Toast.LENGTH_SHORT).show();
        //2.1终止广播
        //abortBroadcast();
        //3.修改数据（扣大米）
        setResultData("习大大给每个村民发了500斤大米");
    }
}
