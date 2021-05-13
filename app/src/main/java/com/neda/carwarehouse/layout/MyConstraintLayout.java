package com.neda.carwarehouse.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.neda.carwarehouse.util.LogGenerator;

public class MyConstraintLayout extends ConstraintLayout {
    public MyConstraintLayout(@NonNull Context context) {
        super(context);
    }

    public MyConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyConstraintLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(LogGenerator.LOG_KEY,LogGenerator.getMessage("ConstraintLayout","dispatchTouchEvent",event.getActionMasked()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(LogGenerator.LOG_KEY,LogGenerator.getMessage("ConstraintLayout","onTouchEvent",event.getActionMasked()));
        return super.onTouchEvent(event);
    }
}
