package com.company;

import java.util.*;

public class Up extends Action {

    public static final double P_UP = 0.8;
    public static final double P_LEFT = 0.1;
    public static final double P_DOWN = 0;
    public static final double P_RIGHT = 0.1;

    public Map<State, Double> reachableStates(
            State stateTo,
            ArrayList<State> statesFrom,
            Agent agent) {
        Map<State, Double> map = new HashMap<State, Double>();

        for (State stateFrom : statesFrom) {
            double probability = 0;
            State stateUp = stateTo(up(stateFrom, agent), stateFrom);
            if (stateTo.equals(stateUp)) {
                probability = probability + P_UP;
            }
            State stateLeft = stateTo(left(stateFrom, agent), stateFrom);
            if (stateTo.equals(stateLeft)) {
                probability = probability + P_LEFT;
            }
            State stateRight = stateTo(right(stateFrom, agent), stateFrom);
            if (stateTo.equals(stateRight)) {
                probability = probability + P_RIGHT;
            }
            if (probability != 0) {
                map.put(stateFrom, probability);
            }
        }
        return map;
    }


}