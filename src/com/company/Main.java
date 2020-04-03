package com.company;

import javafx.util.Pair;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Train[] trains = new Train[]{
                new Train(1, 0, 2, 1),
                new Train(2, 3, 1, 2),
                new Train(3, 5, 1, 3),
                new Train(4, 1, 4, 5)};
        EventList eventList = new EventList(Arrays.asList(trains));
        Pair<Integer, List<Integer>> res = eventList.getMaxProfit();
        System.out.println(res.getKey());
        System.out.println(res.getValue());
    }
}


