package com.neda.carwarehouse.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.neda.carwarehouse.util.LogGenerator;

public class MyTextView extends AppCompatTextView {

    public MyTextView(@NonNull Context context) {
        super(context);
    }

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(LogGenerator.LOG_KEY,LogGenerator.getMessage("TextView","dispatchTouchEvent",event.getActionMasked()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(LogGenerator.LOG_KEY,LogGenerator.getMessage("TextView","onTouchEvent",event.getActionMasked()));
        return super.onTouchEvent(event);
    }
}
