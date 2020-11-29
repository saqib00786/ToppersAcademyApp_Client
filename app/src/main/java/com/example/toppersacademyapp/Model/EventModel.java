package com.example.toppersacademyapp.Model;

public class EventModel {
    private String eventName;
    private String eventImage;

    public EventModel(String eventName, String eventImage) {
        this.eventName = eventName;
        this.eventImage = eventImage;
    }

    public EventModel() {
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventImage() {
        return eventImage;
    }

}

