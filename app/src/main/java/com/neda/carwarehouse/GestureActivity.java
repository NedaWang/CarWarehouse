package com.neda.carwarehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.neda.carwarehouse.layout.MyConstraintLayout;
import com.neda.carwarehouse.layout.MyTextView;
import com.neda.carwarehouse.util.LogGenerator;

import java.util.Calendar;

public class GestureActivity extends AppCompatActivity {

    TextView actionType;
    TextView getXY;
    TextView getRawXY;

    MyTextView myTextView;
    MyConstraintLayout myconstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        View view=findViewById(R.id.frame_layout_id);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getActionMasked()==0 || event.getActionMasked()==1) {
            Log.d(LogGenerator.LOG_KEY, LogGenerator.getMessage("Activity " + Calendar.getInstance().getTimeInMillis(), "dispatch " + super.dispatchTouchEvent(event), event.getActionMasked()));
        }
//        return true;
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked()==0 || event.getActionMasked()==1) {
            Log.d(LogGenerator.LOG_KEY, LogGenerator.getMessage("Activity " + Calendar.getInstance().getTimeInMillis(), "onTouchEvent " + super.onTouchEvent(event), event.getActionMasked()));
        }
        return super.onTouchEvent(event);
    }
}