package com.company;

public class RunSimulation {
    public static void main(String[] args) {
        StateType[][] map = new StateType[5][6];
        initializeMap(map);

        State startingState = null;

        Agent agent1 = new Agent(map, null);
        Action[] actionSequence1 = {new Up(), new Up(), new Up()};
        Observation[] observationSequence1 = {new Observation(ObsType.TWO_WALL),
            new Observation(ObsType.TWO_WALL),
            new Observation(ObsType.TWO_WALL)};

        Agent agent2 = new Agent(map, null);
        Action[] actionSequence2 = {new Up(), new Up(), new Up()};
        Observation[] observationSequence2 = {new Observation(ObsType.ONE_WALL),
                new Observation(ObsType.ONE_WALL),
                new Observation(ObsType.ONE_WALL)};

        Agent agent3 = new Agent(map, new State(3,2));
        Action[] actionSequence3 = {new Right(), new Right(), new Right()};
        Observation[] observationSequence3 = {new Observation(ObsType.ONE_WALL),
                new Observation(ObsType.ONE_WALL),
                new Observation(ObsType.END)};

        Agent agent4 = new Agent(map, new State(1,1));
        Action[] actionSequence4 = {new Up(), new Right(), new Right(), new Right()};
        Observation[] observationSequence4 = {new Observation(ObsType.TWO_WALL),
                new Observation(ObsType.TWO_WALL),
                new Observation(ObsType.ONE_WALL),
                new Observation(ObsType.ONE_WALL)};

        System.out.println("(up, up, up) (2 walls, 2 walls, 2 walls)");
        agent1.runPOMPD(actionSequence1, observationSequence1);
        System.out.println("(up, up, up) (1 wall,1 wall, 1 wall)");
        agent2.runPOMPD(actionSequence2, observationSequence2);
        System.out.println("(right, right, up) (1 wall, 1 wall, end) with S0 = (3,2)");
        agent3.runPOMPD(actionSequence3, observationSequence3);
        System.out.println("(up, right, right, right) (2 walls, 2 walls, 1 wall, 1 wall) with S_0 = (1,1)");
        agent4.runPOMPD(actionSequence4, observationSequence4);

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
