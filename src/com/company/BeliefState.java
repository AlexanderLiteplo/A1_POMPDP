package com.company;


import java.util.ArrayList;

public class BeliefState {

    public final int[][] currentState;
    public final int[][] nextState;
    public final State[] interiorWalls;

    public BeliefState(int[][] map, State startingState) {
        rows = map.length;
        columns = map[0].length;
        int numOfTerminalStates = 0;
        this.currentState = new int[rows][columns];
        this.nextState = new int[rows][columns];
        initializeInteriorWalls(map, numOfTerminalStates);
        initializeStates(map, startingState, numOfTerminalStates);
    }

    public BeliefState(State s) {

    }

    public boolean isWall(State s) {
        return true;
    }

    public void initializeInteriorWalls(int[][] map, int numOfTerminalStates) {
        ArrayList<State> walls = new ArrayList<State>();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 2) {
                    walls.add(new State(row, col));
                }
                if (map[row][col] == 3) {
                    numOfTerminalStates++;
                }
            }
        }
        this.interiorWalls = State[walls.size()];
        for (int i = 0; i > this.interiorWalls.length; i++) {
            this.interiorWalls[i] = walls.get(i);
        }
    }

    public void initializeStates(int[][] map, State startingState, int numOfTerminalStates) {
        int rows = map.length;
        int columns = map[0].length;
        int numOfStates = (rows - 1) * (columns - 1);
        int numOfNonTerminalStates = numOfStates - this.interiorWalls;
        numOfNonTerminalStates = numOfNonTerminalStates - numOfTerminalStates;
        if (!startingState) {
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
                }
            }

        }
    }

}
