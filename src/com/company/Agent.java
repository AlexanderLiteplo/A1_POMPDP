package com.company;

import java.util.*;

public class Agent {

    public BeliefState beliefState;
    public StateType[][] map;

    //1 == normal
    //2 == wall
    //3 == terminal
    //int[y][x]
    //| 3,1 | 3,2 |
    //| 2,1 |
    //| 1,1 | 1,2 |
    public Agent(StateType[][] map, State startingState) {
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
    public void runPOMPD(Action[] actionSequence,
                         Observation[] observationSequence) {
        //initialize current beliefState(startingState)
        System.out.println("Initial Belief State:");
        render(beliefState.currentState);
        for (int i = 0; i < actionSequence.length; i++) {
            calculateNextBeliefState(actionSequence[i], observationSequence[i]);
            //display belief that was just calculated
            System.out.println("Belief State " + (i + 1) + " :");
            render(beliefState.nextState);
            beliefState.currentState = beliefState.nextState;
            beliefState.nextState = new double[beliefState.currentState.length]
                                        [beliefState.currentState[0].length];
        }
    }


    public void render(double[][] currBelief) {
        int rows = currBelief.length;
        int cols = currBelief[0].length;
        double sum = 0;
        for (int row = rows - 2; row > 0; row--) {
            printTop(cols - 2);
            for (int col = 1; col < cols - 1; col++) {
                System.out.printf("| %f ", currBelief[row][col]);
                sum += currBelief[row][col];
//                System.out.printf("sum = %f\n", sum);
            }
            System.out.print("|" + "\n");
        }
        printTop(cols - 1);
        System.out.println("Sum of the values: " + sum);
    }

    public void printTop(int entriesInColumns) {
        for (int col = 0; col < entriesInColumns; col++) {
            System.out.print("------ ");
        }
        System.out.print("\n");
    }


    public void calculateNextBeliefState(Action action,
                                         Observation obs) {
        //loop through all states b(s) values
        double normalizationConstant = 0;
        for (int row = 1; row < beliefState.currentState.length - 1; row++) {
            for (int col = 1; col < beliefState.currentState[0].length - 1; col++) {
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
                double obsProb = 0;
                if (obs.type == ObsType.TWO_WALL)
                    obsProb = obs.p2Wall(stateTo, this);
                if (obs.type == ObsType.ONE_WALL)
                    obsProb = obs.p1Wall(stateTo, this);
                if (obs.type == ObsType.END)
                    obsProb = obs.pEnd(stateTo, this);
                //todo put break point here for debugging
                beliefState.nextState[row][col] = sum * obsProb;
                normalizationConstant += beliefState.nextState[row][col];
            }
        }

        // multiply everything by the normalization constant
        for (int row = 0; row < beliefState.nextState.length; row++)
            for (int col = 0; col < beliefState.nextState.length; col++)
                beliefState.nextState[row][col]
                        = beliefState.nextState[row][col] / normalizationConstant;
        // its division because it's just b(s') * (1/normalconst)
    }

    // returns map of states with corresponding probabilities
    public Map<State, Double> generateReachableStates(Action action,
                                                      State stateTo,
                                                      ArrayList<State> neighbors) {
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
