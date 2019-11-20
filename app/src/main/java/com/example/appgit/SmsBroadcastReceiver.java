package com.example.appgit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

public class SmsBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        final String SMS_RECEIVED_ACTION ="android.provider.Telephony.SMS_RECEIVED";

        if(intent.getAction().equals(SMS_RECEIVED_ACTION)){
            String val = intent.getExtras().getString("extra");
            Object [] pdus=(Object [])intent.getExtras().get("pdus");
            SmsMessage[] messages= new SmsMessage[pdus.length];
            for( int i =0; i < pdus.length; i++){
                messages[i]= SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
        }

    }
}
