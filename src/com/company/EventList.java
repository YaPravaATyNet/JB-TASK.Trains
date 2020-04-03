package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class EventList {
    List<Event> events = new ArrayList<>();

    EventList(List<Train> trains) {
        for (Train train: trains) {
            Event startEvent = new Event(train.start, EventType.START, train);
            Event finishEvent = new Event(train.start + train.period, EventType.FINISH, train, startEvent);
            this.events.add(startEvent);
            this.events.add(finishEvent);
        }
        this.events.sort((e1, e2) -> {
            if (e1.time == e2.time) {
                if (e1.type == EventType.FINISH) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return e1.time - e2.time;
        });
    }

    public Pair<Integer, List<Integer>> getMaxProfit() {
        if (events.isEmpty()) {
            return new Pair<>(0, new ArrayList<>());
        }
        for (int i = 1; i < events.size(); i++) {
            Event curEvent = events.get(i);
            if (curEvent.type == EventType.START) {
                curEvent.profit = events.get(i - 1).profit;
                curEvent.ids = new ArrayList<>(events.get(i - 1).ids);
                continue;
            }
            int curProfit = curEvent.otherEvent.profit + curEvent.train.price;
            if (curProfit > events.get(i - 1).profit) {
                curEvent.profit = curProfit;
                curEvent.ids = new ArrayList<>(curEvent.otherEvent.ids);
                curEvent.ids.add(curEvent.train.id);
            } else {
                curEvent.profit = events.get(i - 1).profit;
                curEvent.ids = new ArrayList<>(events.get(i - 1).ids);
            }
        }
        Event last = events.get(events.size() - 1);
        return new Pair<>(last.profit, last.ids);
    }
}
