package com.company;
import com.company.*;

public class RunSimulation {
    public static void main(String[] args) {
        try {
            StateType[][] map = new StateType[5][6];
            initializeMap(map);
            State startingState = null;
            int numOfActionsAndObservations = args.length / 2;
            Action[] actions = new Action[numOfActionsAndObservations];
            Observation[] observations = new Observation[numOfActionsAndObservations];
            int isInitialStateSpecified = args.length % 2;
            if (isInitialStateSpecified == 1) {
                String startState = args[args.length - 1];
                int row = Character.getNumericValue(startState.toCharArray()[1]);
                int column = Character.getNumericValue(startState.toCharArray()[3]);
                startingState = new State(row, column);
            }

            for (int i = 0; i < numOfActionsAndObservations; i++) {
                String action = args[i].toLowerCase();
                switch (action) {
                    case "up":
                        actions[i] = new Up();
                        break;
                    case "left":
                        actions[i] =  new Left();
                        break;
                    case "down":
                        actions[i] = new Down();
                        break;
                    case "right":
                        actions[i] = new Right();
                        break;
                }
            }

            for (int i = 0; i < numOfActionsAndObservations; i++) {
                String observation = args[i + numOfActionsAndObservations].toLowerCase();
                switch (observation) {
                    case "1wall":
                        observations[i] = new Observation(ObsType.ONE_WALL);
                        break;
                    case "2walls":
                        observations[i] = new Observation(ObsType.TWO_WALL);
                        break;
                    case "end":
                        observations[i] = new Observation(ObsType.END);
                        break;
                }
            }

            Agent agent = new Agent(map, startingState);
            agent.runPOMPD(actions, observations);

        } catch (Exception e) {
            System.out.println("Incorrect input. Please follow ReadMe instruction.");
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void initializeMap(StateType[][] map) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                map[row][col] = StateType.NORMAL;
            }
        }
        map[2][2] = StateType.WALL;
        map[3][4] = StateType.TERMINAL;
        map[2][4] = StateType.TERMINAL;
        //adding walls that are in spots like 0,0 and 4,5
        for (int column = 0; column < map[0].length; column++) {
            map[0][column] = StateType.WALL;
            map[4][column] = StateType.WALL;
        }

        for (int row = 0; row < map.length; row++) {
            map[row][0] = StateType.WALL;
            map[row][5] = StateType.WALL;
        }
    }

}
