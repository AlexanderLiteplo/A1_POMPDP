package com.company;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class Agent {

    public BeliefState beliefState;
    public int[][] map;

    //1 == normal
    //2 == wall
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

    /*Notes for Deep:
     * we did not have to initialize the belief state ourselves
     * because it's provided to us here.
     * We have forgotten to into account the error in making certain observations.
     * We need to print out the state at each step i.
     * Grid input must have a border of walls == 2
     * I expanded map input to be larger and contain them in the tests
     * */
    public double[][] runPOMPD(BeliefState initialBelief,
                               ArrayList<Action> actionSequence,
                               ArrayList<Observation> observationSequence,
                               State startingState) {
        //initialize current beliefState(startingState)
        BeliefState beliefState = initialBelief;
        for (int i = 0; i < actionSequence.size(); i++) {
            calculateNextBeliefState(actionSequence.get(i),
                    observationSequence.get(i));
        }
        //for(int i = 0; i < actionSequene.size(); i++)
        // calculateNextBeliefState()

        return null;

    }


    public void calculateNextBeliefState(Action action,
                                         Observation obs) {
        //loop through all states b(s) values
        for (int row = 0; row < beliefState.currentState.length; row++) {
            for (int col = 0; col < beliefState.currentState.length; col++) {
                // for each state
                State stateTo = new State(row, col);
                // find its neighbors
                ArrayList<State> neighbors =
                        action.generateNeighbors(stateTo, this);
                // for each neighbor add it to reachbleStates if it's
                // reachable via the current action
                Map<State, Double> reachableStates = generateReachableStates(action,
                        stateTo,
                        neighbors);
                // sum the probabilities multiplied by their
                // respective belief values
                double sum = 0;
                for (Map.Entry<State, Double> state : reachableStates.entrySet()) {
                    sum += beliefState.currentState[state.getKey().row][state.getKey().column]
                            * state.getValue();
                }
                // multiply that by the probability of observation given state
                // also multiply by the normalization constant
                // set nextBelief state value b(s') = the result
                // todo what is the normalization constant???
                double obsProb = beliefState.getObservationProb(obs, stateTo);
                // todo implement this next part
                beliefState.nextState[row][col] = 0;

            }
        }


        //neighbors = action.generatNeighborStates()

        //reachableStates = action.ReachableStates(s, neighbors)

        //reachableStatesLeft = left.reachableStates()

    }

    public Map<State, Double> generateReachableStates(Action action, State stateTo, ArrayList<State> neighbors) {
        Map<State, Double> reachableStates = null;
        if (action instanceof Down) {
            reachableStates = ((Down) action).reachableStates(stateTo,
                    neighbors,
                    this);
        } else if (action instanceof Up) {
            reachableStates = ((Up) action).reachableStates(stateTo,
                    neighbors,
                    this);
        } else if (action instanceof Right) {
            reachableStates = ((Right) action).reachableStates(stateTo,
                    neighbors,
                    this);
        } else if (action instanceof Left) {
            reachableStates = ((Left) action).reachableStates(stateTo,
                    neighbors,
                    this);
        }
        return reachableStates;
    }

}
