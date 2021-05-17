package com.neda.carwarehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.neda.carwarehouse.util.LogGenerator;

public class MultiPointerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_pointer);

        View layout = findViewById(R.id.multi_pointer_page);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                if(event.getActionMasked()!=MotionEvent.ACTION_MOVE) {
//                    Log.d("Week11Log", LogGenerator.getEventType(event.getActionMasked()) + ". pointer count: " + event.getPointerCount());
//                }
                if(event.getActionMasked()==MotionEvent.ACTION_POINTER_DOWN){
                    LogGenerator.log(""+event.getActionIndex());
                    int id = event.getPointerId(event.getActionIndex());
                    int indx = event.findPointerIndex(id);
                }
                return true;
            }
        });
    }
}