package com.company;

import java.util.ArrayList;

public class BeliefState {

    //todo add an array that tell you the probabilities of making an observation at state

    public double[][] currentState;
    public double[][] nextState;
    public State[] interiorWalls;
    public State[] terminalStates;

    public BeliefState(StateType[][] map,
                       State startingState) {
        int rows = map.length;
        int columns = map[0].length;
        this.currentState = new double[rows][columns];
        this.nextState = new double[rows][columns];

        initializeInteriorWallsAndTerminalStates(map);
        initializeStates(map, startingState);
    }

    public BeliefState(State s) {

    }

    public boolean isWall(State s) {
        for (State wall : interiorWalls)
            if (s.equals(wall))
                return true;
        return false;
    }

    public boolean isTerminal(State s) {
        for (State terminal : terminalStates)
            if (s.equals(terminal))
                return true;
        return false;
    }

    public void initializeInteriorWallsAndTerminalStates(StateType[][] map) {
        ArrayList<State> walls = new ArrayList<State>();
        ArrayList<State> terminals = new ArrayList<State>();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == StateType.WALL) {
                    walls.add(new State(row, col));
                }
                if (map[row][col] == StateType.TERMINAL) {
                    terminals.add(new State(row, col));
                }
            }
        }
        this.interiorWalls = new State[walls.size()];
        this.terminalStates = new State[terminals.size()];
        for (int i = 0; i < this.interiorWalls.length; i++) {
            this.interiorWalls[i] = walls.get(i);
        }
        for (int i = 0; i < this.terminalStates.length; i++) {
            this.terminalStates[i] = terminals.get(i);
        }
    }
    ///

    public void initializeStates(StateType[][] map, State startingState) {
        int rows = map.length;
        int columns = map[0].length;
        int numOfStates = (rows - 2) * (columns - 2);
        double numOfNonTerminalStates = 9;
//        double numOfNonTerminalStates = numOfStates - this.interiorWalls.length;
//        numOfNonTerminalStates = numOfNonTerminalStates - this.terminalStates.length;

        if (startingState == null) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {

                    if (map[row][col] == StateType.NORMAL) {
                        this.currentState[row][col] = 1 / numOfNonTerminalStates;
                        this.nextState[row][col] = 0;
                    }
                    if (map[row][col] == StateType.WALL) {
                        this.currentState[row][col] = 0;
                        this.nextState[row][col] = 0;
                    }
                    if (map[row][col] == StateType.TERMINAL) {
                        this.currentState[row][col] = 0;
                        this.nextState[row][col] = 0;
                    }
                }
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (row == startingState.row && col == startingState.column) {
                        this.currentState[row][col] = 1;
                        this.nextState[row][col] = 0;
                    } else {
                        this.currentState[row][col] = 0;
                        this.nextState[row][col] = 0;
                    }
                    if (map[row][col] == StateType.WALL) {
                        this.currentState[row][col] = 0;
                        this.nextState[row][col] = 0;
                    }
                }
            }

        }
    }

}
