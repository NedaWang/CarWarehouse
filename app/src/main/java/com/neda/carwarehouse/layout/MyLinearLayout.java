package com.neda.carwarehouse.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.neda.carwarehouse.util.LogGenerator;

import java.util.Calendar;

public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getActionMasked()==0 || event.getActionMasked()==1) {
            Log.d(LogGenerator.LOG_KEY, LogGenerator.getMessage("LinearLayout " + Calendar.getInstance().getTimeInMillis(), "dispatch " + super.dispatchTouchEvent(event), event.getActionMasked()));
        }
        return super.dispatchTouchEvent(event);
//            return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked()==0 || event.getActionMasked()==1) {
            Log.d(LogGenerator.LOG_KEY, LogGenerator.getMessage("LinearLayout " + Calendar.getInstance().getTimeInMillis(), "onTouchEvent " + super.onTouchEvent(event), event.getActionMasked()));
        }
        return super.onTouchEvent(event);
    }
}
