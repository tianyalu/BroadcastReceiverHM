package com.sty.broadcast.receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sty.broadcast.receiver.orderreceiver.FinalReceiver;
import com.sty.broadcast.receiver.specialreceiver.ScreenReceiver;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSendNotOrdered;
    private Button btnSendOrdered;
    ScreenReceiver screenReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setListeners();
        dynamicRegisterBroadcastReceiver();
    }

    //当Activity销毁的时候取消注册广播接收者
    @Override
    protected void onDestroy() {
        unregisterReceiver(screenReceiver);
        super.onDestroy();
    }

    private void initViews(){
        btnSendNotOrdered = findViewById(R.id.btn_send_not_ordered);
        btnSendOrdered = findViewById(R.id.btn_send_ordered);
    }

    private void setListeners(){
        btnSendNotOrdered.setOnClickListener(this);
        btnSendOrdered.setOnClickListener(this);
    }

    //动态注册广播，诸如解锁/锁屏事件类的广播静态注册无效，必须动态注册
    private void dynamicRegisterBroadcastReceiver(){
        screenReceiver = new ScreenReceiver();
        //创建intent-filter对象
        IntentFilter filter = new IntentFilter();
        //添加要注册的action
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        //注册广播接收者
        registerReceiver(screenReceiver, filter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_not_ordered:
                sendBroadcastNotOrdered();
                break;
            case R.id.btn_send_ordered:
                sendBroadcastOrdered();
                break;
            default:
                break;
        }
    }

    //发送一条无序广播
    private void sendBroadcastNotOrdered(){
        Intent intent = new Intent();
        //设置action
        intent.setAction("com.sty.custom.broadcast");
        intent.putExtra("name", "新闻联播每天晚上7点钟准时开播");
        //发送广播
        sendBroadcast(intent);
    }

    //发送一条有序广播（发大米）
    private void sendBroadcastOrdered(){
        Intent intent = new Intent();
        //设置action
        intent.setAction("com.sty.custom.broadcast.rice");
        /**
         * receiverPermission:接收的权限
         * resultReceiver:最终的广播接收者,无论如何最终都能接收到广播
         */
        sendOrderedBroadcast(intent, null, new FinalReceiver(), null,
                1, "习大大给每个村民发了1000斤大米", null);
    }
}
