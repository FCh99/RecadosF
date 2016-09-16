package com.example.faustocheca.recadosf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.faustocheca.recadosf.getservice.MyIntentService;

public class MyReceiverAutoStart extends BroadcastReceiver {
    public MyReceiverAutoStart() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())){
            Intent pushIntent = new Intent(context, MyIntentService.class);
            context.startService(pushIntent);

        }




    }
}
