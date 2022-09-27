package com.company;

import java.util.*;

public class Right extends Action {
    public static final double P_UP = 0.1;
    public static final double P_DOWN = 0.1;
    public static final double P_RIGHT = 0.8;
    public static final double P_LEFT = 0;

    public Map<State, Double> reachableStates(State stateTo,
                                              ArrayList<State> statesFrom,
                                              Agent agent) {

        Map<State, Double> map = new HashMap<State, Double>();
        for (State state : statesFrom) {
            double probability = 0;
            if (stateTo.equals(right(state, agent))) {
                probability = probability + P_RIGHT;
            }
            if (stateTo.equals(up(state, agent))) {
                probability = probability + P_UP;
            }
            if (stateTo.equals(down(state, agent))) {
                probability = probability + P_DOWN;
            }
            if (probability != 0) {
                map.put(state, probability);
            }
        }

        return map;
    }

}