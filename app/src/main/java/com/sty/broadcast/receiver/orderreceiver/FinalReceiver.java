package com.sty.broadcast.receiver.orderreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 最终的receiver不需要在清单文件中配置
 * Created by Steven.T on 2017/12/12/0012.
 */

public class FinalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String content = getResultData();
        Toast.makeText(context, "报告习大大：" + content, Toast.LENGTH_SHORT).show();;
    }
}
