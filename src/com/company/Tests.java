package com.company;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
// Add imports here
import java.util.ArrayList;
import java.util.*;

public class Tests {
    Agent agent;

    @Before
    public void setUp() {
        // Add setup code here
        int[][] beliefState = new int[4][5];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                beliefState[row][col] = 1;
            }
        }
        beliefState[2][2] = 2;
        beliefState[3][4] = 3;
        beliefState[2][4] = 3;
        State startingState = null
        Agent agent = new Agent(beliefState, startingState);

    }

    @Test
    public void Down_ReachableStates_Corner14() {
        // Enter code here
// Enter code here
        Left goLeft = new Left();
        State stateTo = new State(1,4);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,3));
        statesFrom.add(new State(1,3));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,3), );


        Map<State, Double> actual = goLeft.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.equals(expected));

    }

    @Test
    public void Up_ReachableStates_CornerCase11() {
        // Enter code here
        // Enter code here
        Left goLeft = new Left();
        State stateTo = new State(1,1);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,1));
        statesFrom.add(new State(1,2));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,1), 0.1);
        expected.put(new State(1,2), 0.1);

        Map<State, Double> actual = goLeft.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.equals(expected));

    }

    @Test
    public void Down_ReachableStates_CornerCase11() {
        // Enter code here
// Enter code here
        Left goLeft = new Left();
        State stateTo = new State(1,1);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,1));
        statesFrom.add(new State(1,2));
        statesFrom.add(new State(2,1));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,1), 0.9);
        expected.put(new State(2,1), 0.8);
        expected.put(new State(1,2), 0.1);

        Map<State, Double> actual = goLeft.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.equals(expected));

    }

    @Test
    public void Right_ReachableStates_CornerCase11() {
        // Enter code here
        // Enter code here
        Left goLeft = new Left();
        State stateTo = new State(1,1);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,1));
        statesFrom.add(new State(2,1));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,1), 0.1);
        expected.put(new State(2,1), 0.1);

        Map<State, Double> actual = goLeft.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.equals(expected));

    }

    @Test
    public void Action_generateNeighbourStates_BesideTerminalStateAndTwoOutsideWalls() {
        // Enter code here
        State s = new State(1, 4);
        Left action = new Left();
        ArrayList<State> neighbourStates = action.generateNeighbourStates(s);
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
        ArrayList<State> neighbourStates = action.generateNeighbourStates(s);
        State[] expected = new State[3];
        expected[0] = new State(3, 3);
        expected[1] = new State(2, 3);
        expected[2] = new State(1, 3);
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
    public void Action_generateNeighbourStates_AroundTerminalStateAndOutsideWall() {
        // Enter code here
        State s = new State(3, 3);
        Left action = new Left();
        ArrayList<State> neighbourStates = action.generateNeighbourStates(s);
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
        ArrayList<State> neighbourStates = action.generateNeighbourStates(s);
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
        ArrayList<State> neighbourStates = action.generateNeighbourStates(s);
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
    public void Left_ReachableStates_cornerCase11() {
        // Enter code here
        Left goLeft = new Left();
        State stateTo = new State(1,1);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,1));
        statesFrom.add(new State(1,2));
        statesFrom.add(new State(2,1));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,1), 0.9);
        expected.put(new State(2,1), 0.1);
        expected.put(new State(1,2), 0.8);

        Map<State, Double> actual = goLeft.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.equals(expected));

    }

    @Test
    public void BeliefState_isWall_OutsideStateIsWall2() {
        // Enter code here
        State s = new State(3,5);
        boolean isThereWall = agent.beliefStates.isWall(s);
        assertTrue(isThereWall);

    }

    @Test
    public void BeliefState_isWall_OutsideStateIsWall1() {
        // Enter code here
        State s = new State(4,4);
        boolean isThereWall = agent.beliefStates.isWall(s);
        assertTrue(isThereWall);

    }

    @Test
    public void BeliefState_isWall_TerminalStateIsNotWall() {
        // Enter code hereState
        State s = new State(2,4);
        boolean isThereWall = agent.beliefStates.isWall(s);
        assertFalse(isThereWall);

    }

    @Test
    public void BeliefState_isWall_NonTerminalStateIsNotWall() {
        // Enter code here
        State s = new State(1, 1);
        boolean isThereWall = agent.beliefStates.isWall(s);
        assertFalse(isThereWall);
    }

    @Test
    public void BeliefState_isWall_stateIsWall() {
        // Enter code here
        State s = new State(2, 2);
        boolean isThereWall = agent.beliefStates.isWall(s);
        assertTrue(isThereWall);
    }


}
