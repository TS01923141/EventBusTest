package com.example.biji.eventbustest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.biji.eventbustest.data.MyEvent;
import com.example.biji.eventbustest.util.SampleDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
//    private EventBus eventBus;
    private TextView textView;
    private Button mShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        mShowDialog = findViewById(R.id.show_btn);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SampleDialog(MainActivity.this).show();
            }
        });
//        eventBus = EventBus.getDefault();
//        eventBus.register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MyEvent event){
        textView.setText(event.getMyEventString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
