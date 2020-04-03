package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Event {
    int time;
    EventType type;
    Train train;
    Event otherEvent;

    int profit;
    List<Integer> ids = new ArrayList<>();

    public Event(int time, EventType type, Train train) {
        this.time = time;
        this.type = type;
        this.train = train;
    }

    public Event(int time, EventType type, Train train, Event otherEvent) {
        this.time = time;
        this.type = type;
        this.train = train;
        this.otherEvent = otherEvent;
    }

}
