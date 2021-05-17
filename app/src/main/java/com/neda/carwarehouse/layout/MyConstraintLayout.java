package com.neda.carwarehouse.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.neda.carwarehouse.util.LogGenerator;

import java.util.Calendar;

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
        if (event.getActionMasked() == 0 || event.getActionMasked() == 1) {
            Log.d(LogGenerator.LOG_KEY, LogGenerator.getMessage("ConstraintLayout " + Calendar.getInstance().getTimeInMillis(), "dispatch " + super.dispatchTouchEvent(event), event.getActionMasked()));
        }
        return super.dispatchTouchEvent(event);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == 0 || event.getActionMasked() == 1) {
            Log.d(LogGenerator.LOG_KEY, LogGenerator.getMessage("ConstraintLayout " + Calendar.getInstance().getTimeInMillis(), "onTouchEvent " + super.onTouchEvent(event), event.getActionMasked()));
        }
        return super.onTouchEvent(event);
    }
}
