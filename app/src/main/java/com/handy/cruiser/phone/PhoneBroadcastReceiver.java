package com.handy.cruiser.phone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by handy on 16/8/7.
 */
public class PhoneBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Intent service = new Intent(context, PhoneService.class);
        context.startService(service);   //启动服务
    }

}
