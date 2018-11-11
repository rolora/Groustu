package com.example.groustu.groustu;

import android.app.Application;

public class MyApp extends Application {
    private boolean inGroup = false;
    private User user = new User("Abby","A first year pre-med student majoring in BME","Avatar1");

    public boolean inGroup(){
        return inGroup;
    }

    public void setInGroup(boolean b){
        this.inGroup = b;
    }

    //these methods are to be re-implemented after SQL
    public String getUName() {
        return user.getUname();
    }

    public String getUserDescription() {
        return user.getUserDescription();
    }

    public String getUserAvatar() {
        return user.getUserAvatar();
    }
}
