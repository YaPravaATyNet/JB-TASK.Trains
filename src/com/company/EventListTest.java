package com.company;

import javafx.util.Pair;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventListTest {

    public void assertRes(Train[] trains, int profit, Integer[] ids) {
        Pair<Integer, List<Integer>> res = new EventList(Arrays.asList(trains)).getMaxProfit();
        assertEquals(profit, res.getKey());
        assertEquals(Arrays.asList(ids), res.getValue());
    }

    @Test
    public void getMaxProfit(){
        assertRes(new Train[]{new Train(1, 0, 5, 3)}, 3, new Integer[]{1});
        assertRes(new Train[]{}, 0, new Integer[]{});

        Train[] trains = new Train[]{
                new Train(1, 0, 1, 2),
                new Train(2, 1, 3, 5),
                new Train(3, 4, 2, 7),
                new Train(4, 6, 2, 3),
                new Train(5, 9, 5, 9),
        };
        assertRes(trains, 26, new Integer[]{1, 2, 3, 4, 5});

        trains = new Train[]{
                new Train(1, 0, 2, 2),      //  |---|
                new Train(2, 0, 1, 1),      //  |-|
                new Train(3, 2, 1, 3),      //      |-|
                new Train(4, 3, 3, 4),      //        |-----|
                new Train(5, 2, 2, 5),      //     |---|
        };
        assertRes(trains, 9, new Integer[]{1, 3, 4});

        trains = new Train[]{
                new Train(1, 0, 1, 2),      //  |-|
                new Train(2, 0, 7, 10),     //  |-------------|
                new Train(3, 1, 1, 3),      //    |-|
                new Train(4, 3, 1, 5),      //        |-|
                new Train(5, 5, 2, 4),      //            |---|
        };
        assertRes(trains, 14, new Integer[]{1, 3, 4, 5});

        trains = new Train[]{
                new Train(1, 0, 1, 2),      //  |-|
                new Train(2, 0, 7, 20),     //  |-------------|
                new Train(3, 1, 1, 3),      //    |-|
                new Train(4, 3, 1, 5),      //        |-|
                new Train(5, 5, 2, 4),      //            |---|
        };
        assertRes(trains, 20, new Integer[]{2});

        trains = new Train[]{
                new Train(1, 0, 2, 2),      //  |---|
                new Train(2, 3, 4, 5),      //        |-------|
                new Train(3, 1, 5, 6),      //    |---------|
                new Train(4, 7, 1, 3),      //                |-|
        };
        assertRes(trains, 10, new Integer[]{1, 2, 4});
    }
}
