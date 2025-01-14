package com.example.datasendv2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;


public class BatteryLevelActivity extends Activity {
    private TextView battery;

    private BroadcastReceiver batteryreceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent){
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            battery.setText(String.valueOf(level)+"%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        battery=(TextView)this.findViewById(R.id.batterytxt);
        this.registerReceiver(this.batteryreceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }


}