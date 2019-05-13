package com.example.tuan5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.Serializable;

public class Population implements Serializable {
    private String userName;
    private String userType;
    private boolean active;

    public Population(String userName, String userType)  {
        this.userName= userName;
        this.userType = userType;
        this.active= true;
    }

    public Population(String userName, String useType, boolean active) {
        this.userName = userName;
        this.userType = useType;
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseType() {
        return userType;
    }

    public void setUseType(String useType) {
        this.userType = useType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public String toString() {
        return this.userName +" ("+ this.userType+")";
    }
}
