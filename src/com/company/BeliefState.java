package com.company;

import java.util.ArrayList;

public class BeliefState {

    public double[][] currentState;
    public double[][] nextState;
    public State[] interiorWalls;
    public State[] terminalStates;

    public BeliefState(int[][] map, State startingState) {
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
        
        return true;
    }

    public void initializeInteriorWallsAndTerminalStates(int[][] map) {
        ArrayList<State> walls = new ArrayList<State>();
        ArrayList<State> terminals = new ArrayList<State>();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 2) {
                    walls.add(new State(row, col));
                }
                if (map[row][col] == 3) {
                    terminals.add(new State(row, col));
                }
            }
        }
        this.interiorWalls  = new State[walls.size()];
        this.terminalStates = new State[terminals.size()];
        for (int i = 0; i < this.interiorWalls.length; i++) {
            this.interiorWalls[i] = walls.get(i);
        }
        for (int i = 0; i < this.terminalStates.length; i++) {
            this.terminalStates[i] = terminals.get(i);
        }
    }

    public void initializeStates(int[][] map, State startingState) {
        int rows = map.length;
        int columns = map[0].length;
        int numOfStates = (rows - 1) * (columns - 1);
        double numOfNonTerminalStates = numOfStates - this.interiorWalls.length;
        numOfNonTerminalStates = numOfNonTerminalStates - this.terminalStates.length;
        if (startingState == null) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (map[row][col] == 1) {
                        this.currentState[row][col] = 1 / numOfNonTerminalStates;
                        this.nextState[row][col] = 0;
                    }
                    if (map[row][col] == 2) {
                        this.currentState[row][col] = -1;
                        this.nextState[row][col] = -1;
                    }
                    if (map[row][col] == 3) {
                        this.currentState[row][col] = 0;
                        this.nextState[row][col] = 0;
                    }
                    if (row == 0 || col == 0) {
                        this.currentState[row][col] = -1;
                        this.nextState[row][col] = -1;
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
                    if (map[row][col] == 2) {
                        this.currentState[row][col] = -1;
                        this.nextState[row][col] = -1;
                    }
                    if (row == 0 || col == 0) {
                        this.currentState[row][col] = -1;
                        this.nextState[row][col] = -1;
                    }
                }
            }

        }
    }

}
