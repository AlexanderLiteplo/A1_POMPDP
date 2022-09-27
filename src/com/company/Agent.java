package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class Agent {

    public BeliefState beliefState;
    public int[][] map;

    //1 == normal
    //2 == blocked off
    //3 == terminal
    //int[y][x]
    //| 3,1 | 3,2 |
    //| 2,1 |
    //| 1,1 | 1,2 |
    public Agent(int[][] map, State startingState) {
        this.map = map;
        //interior walls
        //next state
        this.beliefState = new BeliefState(map, startingState);
    }

    public double[][] runPOMPD(BeliefState initialBelief,
                               ArrayList<Action> actionSequence,
                               ArrayList<Observation> observationSequence,
                               State startingState) {
        //initialize current beliefState(startingState)

        //for(int i = 0; i < actionSequene.size(); i++)
        // calculateNextBeliefState()

        return null;

    }


    public int calculateNextBeliefState(Action action, State s, Observation obs) {

        //neighbors = action.generatNeighborStates()

        //reachableStates = action.ReachableStates(s, neighbors)

        //reachableStatesLeft = left.reachableStates()

        //for(state s : generateState())
        //if (up.Reachable(s))
        //
        return 0;
    }

}
