package com.company;

import java.util.ArrayList;

public class Action {
    BeliefState bState;

    // exclude terminal states since once we are in a terminal state we
    // exit from them
    public ArrayList<State> generateNeighbourStates(State state) {
        return null;
    }

    public State up(State s, Agent agent) {
        row = s.row + 1;
        col = s.column;
        state = new State(row, col);
        if (isLegalState(state, agent)) {
            return state;
        }
        return s;
    }

    public boolean isLegalState(State s, Agent agent) {
        int numOfRows = agent.beliefState
        if (s.row <= 0 || s.column <= 0) {
            return false;
        }
        if (s.row )
    }




}