package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ReachableStatesTests {

    Agent agent;

    @Before
    public void setUp() {
        // Add setup code here
        int[][] map = new int[4][5];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                map[row][col] = 1;
            }
        }
        map[2][2] = 2;
        map[3][4] = 3;
        map[2][4] = 3;
        State startingState = null;
        agent = new Agent(map, startingState);
    }

    @Test
    public void Right_ReachableStates_Case23() {
        // Enter code here
        Right right = new Right();
        State stateTo = new State(2,3);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(3,3));
        statesFrom.add(new State(2,3));
        statesFrom.add(new State(1,3));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(3,3),  0.1);
        expected.put(new State(1,3), 0.1);


        Map<State, Double> actual = right.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void Left_ReachableStates_Case23() {
        // Enter code here
        Left left = new Left();
        State stateTo = new State(2,3);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(3,3));
        statesFrom.add(new State(2,3));
        statesFrom.add(new State(1,3));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(3,3),  0.1);
        expected.put(new State(2,3),  0.8);
        expected.put(new State(1,3), 0.1);


        Map<State, Double> actual = left.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }


    @Test
    public void Up_ReachableStates_Case23() {
        // Enter code here
        Up up = new Up();
        State stateTo = new State(2,3);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(3,3));
        statesFrom.add(new State(2,3));
        statesFrom.add(new State(1,3));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(2,3),  0.1);
        expected.put(new State(1,3), 0.8);


        Map<State, Double> actual = up.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }


    @Test
    public void Down_ReachableStates_Case23() {
        // Enter code here
        Down down = new Down();
        State stateTo = new State(2,3);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(3,3));
        statesFrom.add(new State(2,3));
        statesFrom.add(new State(1,3));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(2,3),  0.1);
        expected.put(new State(3,3), 0.8);
        Map<State, Double> actual = down.reachableStates(stateTo, statesFrom, agent);
        // check to see if all the fields in the actual and expected State are true
        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void Right_ReachableStates_Case33() {
        // Enter code here
        Right right = new Right();
        State stateTo = new State(3,3);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(3,3));
        statesFrom.add(new State(2,3));
        statesFrom.add(new State(3,2));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(3,3),  0.1);
        expected.put(new State(2,3), 0.1);
        expected.put(new State(3,2), 0.8);


        Map<State, Double> actual = right.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void Left_ReachableStates_Case33() {
        // Enter code here
        Left left = new Left();
        State stateTo = new State(3,3);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(3,3));
        statesFrom.add(new State(2,3));
        statesFrom.add(new State(3,2));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(3,3),  0.1);
        expected.put(new State(2,3), 0.1);


        Map<State, Double> actual = left.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void Down_ReachableStates_Case33() {
        // Enter code here
        Down down = new Down();
        State stateTo = new State(3,3);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(3,3));
        statesFrom.add(new State(2,3));
        statesFrom.add(new State(3,2));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(3,2), 0.1);


        Map<State, Double> actual = down.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));

        for(State state: expected.keySet()) {

            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void Up_ReachableStates_Case33() {
        // Enter code here
        Up up = new Up();
        State stateTo = new State(3,3);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(3,3));
        statesFrom.add(new State(2,3));
        statesFrom.add(new State(3,2));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(3,3),  0.8);
        expected.put(new State(2,3), 0.8);
        expected.put(new State(3,2), 0.1);


        Map<State, Double> actual = up.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }



    @Test
    public void Down_ReachableStates_Corner14() {
        // Enter code here
        // Enter code here
        Down down = new Down();
        State stateTo = new State(1,4);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,3));
        statesFrom.add(new State(1,4));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,3),  0.1);
        expected.put(new State(1,4), 0.9);


        Map<State, Double> actual = down.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }


    @Test
    public void Up_ReachableStates_Corner14() {
        // Enter code here
        Up goUP = new Up();
        State stateTo = new State(1,4);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,3));
        statesFrom.add(new State(1,4));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,3),  0.1);
        expected.put(new State(1,4), 0.1);


        Map<State, Double> actual = goUP.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void Right_ReachableStates_Corner14() {
        // Enter code here
        Right right = new Right();
        State stateTo = new State(1,4);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,3));
        statesFrom.add(new State(1,4));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,3),  0.8);
        expected.put(new State(1,4), 0.9);


        Map<State, Double> actual = right.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void Left_ReachableStates_Corner14() {
        // Enter code here
        Left left = new Left();
        State stateTo = new State(1,4);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,3));
        statesFrom.add(new State(1,4));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,4), 0.1);


        Map<State, Double> actual = left.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());
    }

    @Test
    public void Up_ReachableStates_CornerCase11() {
        // Enter code here
        // Enter code here
        Up up = new Up();
        State stateTo = new State(1,1);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,1));
        statesFrom.add(new State(1,2));
        statesFrom.add(new State(2,1));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,1), 0.1);
        expected.put(new State(1,2), 0.1);

        Map<State, Double> actual = up.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());

    }

    @Test
    public void Down_ReachableStates_CornerCase11() {
        // Enter code here
// Enter code here
        Down down = new Down();
        State stateTo = new State(1,1);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,1));
        statesFrom.add(new State(1,2));
        statesFrom.add(new State(2,1));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,1), 0.9);
        expected.put(new State(2,1), 0.8);
        expected.put(new State(1,2), 0.1);

        Map<State, Double> actual = down.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());

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


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());

    }

    @Test
    public void Right_ReachableStates_CornerCase11() {
        // Enter code here
        // Enter code here
        Right right = new Right();
        State stateTo = new State(1,1);
        ArrayList<State> statesFrom = new ArrayList<State>();
        statesFrom.add(new State(1,1));
        statesFrom.add(new State(1,2));
        statesFrom.add(new State(2,1));
        Map<State, Double> expected = new HashMap<State, Double>();
        expected.put(new State(1,1), 0.1);
        expected.put(new State(2,1), 0.1);

        Map<State, Double> actual = right.reachableStates(stateTo,
                statesFrom,
                agent);


        assertTrue(actual.keySet().equals(expected.keySet()));
        for(State state: expected.keySet()) {
            assertTrue(actual.get(state).equals(expected.get(state)));
        }
        Assert.assertEquals(expected.size(),actual.size());

    }
}
