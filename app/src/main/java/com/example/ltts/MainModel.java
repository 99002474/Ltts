package com.example.ltts;

public class MainModel {
    Integer eventLogo;
    String eventName;
    public MainModel(Integer eventLogo,String eventName)
    {
        this.eventLogo=eventLogo;
        this.eventName=eventName;
    }
    public Integer getEventLogo()
    {
        return eventLogo;
    }

    public String getEventName()
    {
        return eventName;
    }
}

