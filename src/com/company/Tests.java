package com.company;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
// Add imports here
import java.util.ArrayList;

public class Tests {
    Agent agent;

    @Before
    public void setUp() {
        // Add setup code here
        int[][] map = new int[5][6];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                map[row][col] = 1;
            }
        }
        map[2][2] = 2;
        map[3][4] = 3;
        map[2][4] = 3;
        //adding walls that are in spots like 0,0 and 4,5
        for(int column = 0; column < map[0].length; column++) {
            map[0][column] = 2;
            map[4][column] = 2;
        }

        for(int row = 0; row < map.length; row++){
            map[row][0] = 2;
            map[row][5] = 2;
        }


        State startingState = null;
        agent = new Agent(map, startingState);

//        render(agent);
    }

    public void render(Agent agent) {
        double[][] finalState = agent.beliefState.nextState;
        int rows = finalState.length;
        int cols = finalState[0].length;

        for (int row = rows - 1; row >= 0; row--) {
            printTop(cols - 1);

            for (int col = 0; col < cols; col++) {
                double probability = finalState[row][col];
                int blockType = agent.map[row][col];
                System.out.print("|  " + blockType + "  ");
            }
            System.out.print("|" + "\n");
        }
        printTop(cols - 1);
    }

    public void printTop(int entriesInColumns) {
        for (int col = 0; col < entriesInColumns; col++) {
            System.out.print("-------");
        }
        System.out.print("\n");
    }

    

    @Test
    public void Action_generateNeighbourStates_BesideTerminalStateAndTwoOutsideWalls() {
        // Enter code here
        State s = new State(1, 4);
        Left action = new Left();
        ArrayList<State> neighbourStates = action.generateNeighbors(s, agent);
        State[] expected = new State[2];
        expected[0] = new State(1, 4);
        expected[1] = new State(1, 3);
        boolean[] areAllStatesFound = {false, false};
        assertEquals(2, neighbourStates.size());

        for (int i = 0; i < 2; i++) {
            State state = neighbourStates.get(i);
            boolean foundStateInExpected = false;
            for (int j = 0; j < 2; j++) {
                if (state.equals(expected[j])) {
                    foundStateInExpected = true;
                    areAllStatesFound[j] = true;
                    break;
                }
            }
            assertTrue(foundStateInExpected);
        }
        for (int i = 0; i < 2; i++) {
            assertTrue(areAllStatesFound[i]);
        }
    }

    @Test
    public void Action_generateNeighbourStates_BetweenTerminalStateAndInteriorWall() {
        // Enter code here
        State s = new State(2, 3);
        Left action = new Left();
        ArrayList<State> neighbourStates = action.generateNeighbors(s, agent);
        State[] expected = new State[3];
        expected[0] = new State(3, 3);
        expected[1] = new State(2, 3);
        expected[2] = new State(1, 3);
        boolean[] areAllStatesFound = {false, false, false};

        for(State state: neighbourStates)
            System.out.println(state.toString());
        assertEquals(3, neighbourStates.size());

        for (int i = 0; i < 3; i++) {
            State state = neighbourStates.get(i);
            boolean foundStateInExpected = false;
            for (int j = 0; j < 3; j++) {
                if (state.equals(expected[j])) {
                    foundStateInExpected = true;
                    areAllStatesFound[j] = true;
                    break;
                }
            }
            assertTrue(foundStateInExpected);
        }
        for (int i = 0; i < 3; i++) {
            assertTrue(areAllStatesFound[i]);
        }

    }

    @Test
    public void Action_generateNeighbourStates_AroundTerminalStateAndOutsideWall() {
        // Enter code here
        State s = new State(3, 3);
        Left action = new Left();
        ArrayList<State> neighbourStates = action.generateNeighbors(s, agent);
        State[] expected = new State[3];
        expected[0] = new State(3, 2);
        expected[1] = new State(3, 3);
        expected[2] = new State(2, 3);
        boolean[] areAllTrue = {false, false, false};
        assertEquals(3, neighbourStates.size());

        for (int i = 0; i < 3; i++) {
            State state = neighbourStates.get(i);
            boolean foundStateInExpected = false;
            for (int j = 0; j < 3; j++) {
                if (state.equals(expected[j])) {
                    foundStateInExpected = true;
                    areAllTrue[j] = true;
                    break;
                }
            }
            assertTrue(foundStateInExpected);
        }
        for (int i = 0; i < 3; i++) {
            assertTrue(areAllTrue[i]);
        }
    }

    @Test
    public void Action_generateNeighbourStates_BetweenInteriorWallAndOutsideWall() {
        // Enter code here
        State s = new State(2, 1);
        Left action = new Left();
        ArrayList<State> neighbourStates = action.generateNeighbors(s, agent);
        State[] expected = new State[3];
        expected[0] = new State(1, 1);
        expected[1] = new State(2, 1);
        expected[2] = new State(3, 1);
        boolean[] areAllStatesFound = {false, false, false};
        assertEquals(3, neighbourStates.size());

        for (int i = 0; i < 3; i++) {
            State state = neighbourStates.get(i);
            boolean foundStateInExpected = false;
            for (int j = 0; j < 3; j++) {
                if (state.equals(expected[j])) {
                    foundStateInExpected = true;
                    areAllStatesFound[j] = true;
                    break;
                }
            }
            assertTrue(foundStateInExpected);
        }
        for (int i = 0; i < 3; i++) {
            assertTrue(areAllStatesFound[i]);
        }

    }

    @Test
    public void Action_generateNeighbourStates_CornerCase() {
        // Enter code here
        State s = new State(1, 1);
        Left action = new Left();
        ArrayList<State> neighbourStates = action.generateNeighbors(s, agent);
        State[] expected = new State[3];
        expected[0] = new State(1, 1);
        expected[1] = new State(2, 1);
        expected[2] = new State(1, 2);
        boolean[] areAllStatesFound = {false, false, false};
        assertEquals(3, neighbourStates.size());

        for (int i = 0; i < 3; i++) {
            State state = neighbourStates.get(i);
            boolean foundStateInExpected = false;
            for (int j = 0; j < 3; j++) {
                if (state.equals(expected[j])) {
                    foundStateInExpected = true;
                    areAllStatesFound[j] = true;
                    break;
                }
            }
            assertTrue(foundStateInExpected);
        }
        for (int i = 0; i < 3; i++) {
            assertTrue(areAllStatesFound[i]);
        }
    }

   

    @Test
    public void BeliefState_isWall_OutsideStateIsWall2() {
        // Enter code here
        State s = new State(3,5);
        boolean isThereWall = agent.beliefState.isWall(s);
        assertTrue(isThereWall);

    }

    // Hey Deep
    // What is this test doing?
    // 4,
    @Test
    public void BeliefState_isWall_OutsideStateIsWall1() {
        // Enter code here
        State s = new State(4,4);
        boolean isThereWall = agent.beliefState.isWall(s);
        assertTrue(isThereWall);

    }

    @Test
    public void BeliefState_isWall_TerminalStateIsNotWall() {
        // Enter code hereState
        State s = new State(2,4);
        boolean isThereWall = agent.beliefState.isWall(s);
        assertFalse(isThereWall);

    }

    @Test
    public void BeliefState_isWall_NonTerminalStateIsNotWall() {
        // Enter code here
        State s = new State(1, 1);
        boolean isThereWall = agent.beliefState.isWall(s);
        assertFalse(isThereWall);
    }

    @Test
    public void BeliefState_isWall_stateIsWall() {
        // Enter code here
        State s = new State(2, 2);
        boolean isThereWall = agent.beliefState.isWall(s);
        assertTrue(isThereWall);
    }


}
