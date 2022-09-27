package com.company;

import java.util.ArrayList;

public class Action {
    BeliefState bState;

    // exclude terminal states since once we are in a terminal state we
    // exit from them
    public ArrayList<State> generateNeighbourStates(State state, Agent agent) {
        ArrayList<State> neighbours = new ArrayList<>();
        //if !null then add
        //if null returned only once then add
        // current state as neighbour because theres a wall
        boolean hasWall = false;
        State addMe = up(state, agent);
        if(addMe != null)
            neighbours.add(addMe);
        else
            hasWall = true;

        addMe = down(state, agent);
        if(addMe != null)
            neighbours.add(addMe);
        else
            hasWall = true;

        addMe = right(state, agent);
        if(addMe != null)
            neighbours.add(addMe);
        else
            hasWall = true;

        addMe = left(state, agent);
        if(addMe != null)
            neighbours.add(addMe);
        else
            hasWall = true;

        if(hasWall)
            neighbours.add(state);

        return null;
    }

    public State up(State s, Agent agent) {
        return computeLegalState(s.row + 1, s.column, s, agent);
    }

    public State left(State s, Agent agent) {
        return computeLegalState(s.row, s.column - 1, s, agent);
    }

    public State right(State s, Agent agent) {
        return computeLegalState(s.row, s.column + 1, s, agent);
    }

    public State down(State s, Agent agent) {
        return computeLegalState(s.row - 1, s.column, s, agent);
    }


    public State computeLegalState(int row, int col, State s, Agent agent) {
        State state = new State(row, col);
        if (isLegalState(state, agent)) {
            return state;
        }
        return null;
    }



    public boolean isLegalState(State s, Agent agent) {
        State[] interiorWalls = agent.beliefState.interiorWalls;
        int numOfInteriorWalls = interiorWalls.length;
        int numOfRows = agent.beliefState.currentState.length;
        int numOfColumns = agent.beliefState.currentState[0].length;
        if (s.row <= 0 || s.column <= 0) {
            return false;
        }
        if (s.row >= numOfRows || s.column >= numOfColumns) {
            return false;
        }
        for (State interiorWall : interiorWalls) {
            if ((s.row == interiorWall.row) && (s.column == interiorWall.column)) {
                return false;
            }
        }
        return true;
    }




}