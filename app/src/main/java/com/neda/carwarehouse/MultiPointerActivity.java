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

                Log.d("Week11Log",LogGenerator.getEventType(event.getActionMasked()));
                return true;
            }
        });
    }
}