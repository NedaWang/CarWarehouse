package com.neda.carwarehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.neda.carwarehouse.util.LogGenerator;

public class ScaleActivity extends AppCompatActivity {

    ScaleGestureDetector scaleGestureDetector;
    GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        scaleGestureDetector = new ScaleGestureDetector(this, new MyScaleGestureDetector());

        View layout = findViewById(R.id.scale_layout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    class MyScaleGestureDetector extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        float scale = 1.0f;
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            LogGenerator.log("onScale "+scale);
//            LogGenerator.log("onscale "+detector.getScaleFactor());
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            scale = 1.0f;
            LogGenerator.log("onScaleBegin");
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            LogGenerator.log("onScaleEnd");
            super.onScaleEnd(detector);
        }
    }
}