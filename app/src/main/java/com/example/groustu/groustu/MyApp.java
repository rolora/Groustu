package com.example.groustu.groustu;

import android.app.Application;

public class MyApp extends Application {
    private boolean inGroup = false;

    public boolean inGroup(){
        return inGroup;
    }

    public void setInGroup(boolean b){
        this.inGroup = b;
    }
}
