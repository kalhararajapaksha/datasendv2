package com.example.datasendv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText phno,bot,bat;

    private TextView battery;


    private BroadcastReceiver batteryreceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent){
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            battery.setText(String.valueOf(level));

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        battery=(TextView)this.findViewById(R.id.batterytxt);
        this.registerReceiver(this.batteryreceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        phno = (EditText) findViewById( R.id.phoneno);
        bot = (EditText) findViewById(R.id.bottles);
        bat = (EditText) findViewById(R.id.battery);
    }

    public void loginBtn(View view) {
        String phoneN = phno.getText().toString();
        String bottel = bot.getText().toString();
      //  String battery = bat.getText().toString();
        String batLevel=battery.getText().toString();
                background bg = new background(this);
        bg.execute(phoneN,bottel,batLevel);
    }




}