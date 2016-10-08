package com.szokesandor.tutorials.launch_after_boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReciever extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {

        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            // TODO: 2016.10.08. Maybe other activiti need to be carried out than simply run your application

            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
