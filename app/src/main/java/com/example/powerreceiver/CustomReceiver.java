package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if(intentAction != null){
            String toastMessage = "Unknown intent action";
            switch(intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power On!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power Off :(";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    int num = (int) (Math.random() * (1 - 20 + 1) + 1);
                    if(num == 0)
                    {
                        num++;
                    }
                    toastMessage = "Custom Broadcast Received, Square Root of a random number is: " + num*num;
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    int state = intent.getIntExtra("state",1);
                    switch (state) {
                        case 0:
                            toastMessage = "Headset Unplugged";
                            break;
                        case 1:
                            toastMessage = "Headset Plugged In";
                            break;
                        default:
                            toastMessage = "Headset Uncertain";
                    }
                    break;
                default: break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
