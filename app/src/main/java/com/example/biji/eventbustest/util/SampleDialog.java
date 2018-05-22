package com.example.biji.eventbustest.util;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.biji.eventbustest.R;
import com.example.biji.eventbustest.data.MyEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by biji on 2018/5/22.
 */

public class SampleDialog extends Dialog {
    private Context context;
    private Button sendBtn;
    private EditText editText;
    private EventBus mEventBus;

    public SampleDialog(@NonNull Context context) {
        super(context, android.R.style.Theme_Light);
        this.context = context;

        mEventBus = EventBus.getDefault();
        setContentView(R.layout.dialog_layout);
        sendBtn = findViewById(R.id.send_button);
        editText = findViewById(R.id.edit_text);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyEvent event = new MyEvent();
                event.setMyEventString(editText.getText().toString());
                mEventBus.post(event);
                dismiss();
            }
        });
    }
}
