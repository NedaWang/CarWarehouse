package com.neda.carwarehouse.util;

import android.view.MotionEvent;

public class LogGenerator {
    public static final String LOG_KEY = "Week10Log";

    //use the final keyword in a method declaration to indicate that the method cannot be overridden by subclasses
    public static String getEventType(int event){
        String event_type = "";
        switch (event){
            case MotionEvent.ACTION_DOWN:
                event_type = "action down";
                break;
            case MotionEvent.ACTION_UP:
                event_type = "action up";
                break;
            case MotionEvent.ACTION_MOVE:
                event_type = "action move";
                break;
            default:
                event_type = "unkown";
        }
        return event_type;
    }

    public static String getMessage(String source, String method, int eventType){
        return String.format("%-15s | %-15s | %-15s",source,method,getEventType(eventType));
    }

}
