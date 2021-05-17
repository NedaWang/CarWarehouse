package com.neda.carwarehouse.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.neda.carwarehouse.util.LogGenerator;

import java.util.Calendar;

public class MyFrameLayout extends FrameLayout {
    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //Called to process touch screen events.
    // You can override this to intercept all touch screen events before they are dispatched to the window.
    // Return true if this event was consumed.
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getActionMasked()==0 || event.getActionMasked()==1) {
            Log.d(LogGenerator.LOG_KEY, LogGenerator.getMessage("FrameLayout " + Calendar.getInstance().getTimeInMillis(), "dispatch " + super.dispatchTouchEvent(event), event.getActionMasked()));

        }
        return super.dispatchTouchEvent(event);
//            return true;
    }


    // Called when a touch screen event was not handled by any of the views under it.
    // This is most useful to process touch events that happen outside of your window bounds,
    // where there is no view to receive it.
    //
    //Parameters
    //event	MotionEvent: The touch screen event being processed.
    // Return true if you have consumed the event, false if you haven't.
    // The default implementation always returns false.
    @Override
    public boolean onTouchEvent(MotionEvent event){
            if (event.getActionMasked() == 0 || event.getActionMasked() == 1) {

            Log.d(LogGenerator.LOG_KEY, LogGenerator.getMessage("FrameLayout " + Calendar.getInstance().getTimeInMillis(), "onTouchEvent " + super.onTouchEvent(event), event.getActionMasked()));
        }
            return super.onTouchEvent(event);
    }
}
