package com.aplicativo.topijava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction() == Intent.ACTION_POWER_CONNECTED) {
            Toast.makeText(context, "Conectado a tomada", Toast.LENGTH_LONG).show();
        } else if(intent.getAction() == Intent.ACTION_POWER_DISCONNECTED){
            Toast.makeText(context, "Desconectado a tomada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "", Toast.LENGTH_LONG).show();
        }
    }
}