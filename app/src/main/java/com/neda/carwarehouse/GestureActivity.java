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
        actionType=findViewById(R.id.action_type);
        getXY=findViewById(R.id.get_x_y_id);
        getRawXY=findViewById(R.id.get_raw_x_y_id);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x=(int)event.getX();
                int y=(int)event.getY();
                int rawX=(int)event.getRawX();
                int rawY=(int)event.getRawY();
                getXY.setText(x+","+y);
                getRawXY.setText(rawX+","+rawY);

                int action = event.getActionMasked();
                switch(action) {
                    case (MotionEvent.ACTION_DOWN) :
                        actionType.setText("Down");
                        return true;
                    case (MotionEvent.ACTION_MOVE) :
                        actionType.setText("MOVE");
                        return true;
                    case (MotionEvent.ACTION_UP) :
                        Toast.makeText(GestureActivity.this,"Action UP",Toast.LENGTH_SHORT).show();
                        //context: getApplicationContext()
                        //v.getContext()
                        //Toast.makeText(v.getContext(),"Action UP",Toast.LENGTH_SHORT).show();
                        actionType.setText("UP");
                        return true;
                    default :
                        return false;
                }
            }
        });

        myTextView = findViewById(R.id.textView2);
        myTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(LogGenerator.LOG_KEY,LogGenerator.getMessage("myTextView","onTouch",event.getActionMasked()));
                return false;
            }
        });
        myconstraintLayout = findViewById(R.id.constraint_layout);
        myconstraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(LogGenerator.LOG_KEY,LogGenerator.getMessage("myconstraintLayout","onTouch",event.getActionMasked()));
                return false;
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(LogGenerator.LOG_KEY,LogGenerator.getMessage("Activity","dispatchTouchEvent",event.getActionMasked()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(LogGenerator.LOG_KEY,LogGenerator.getMessage("Activity","onTouchEvent",event.getActionMasked()));
        return super.onTouchEvent(event);
    }
}