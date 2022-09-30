package com.company;

public class Observation {

    ObsType type;

    public Observation(ObsType type) {
        this.type = type;
    }

    // assumes state is a legal state
    public double p1Wall(State state, Agent agent) {
        if (agent.beliefState.isTerminal(state)) {
            return 0;
        }
        if (isNonTerminalStateInThirdColumn(state, agent)) {
            return 0.9;
        }
        return 0.1;
    }

    // assumes state is a legal state
    public double p2Wall(State state, Agent agent) {
        if (agent.beliefState.isTerminal(state)) {
            return 0;
        }
        if (isNonTerminalStateInThirdColumn(state, agent)) {
            return 0.1;
        }
        return 0.9;
    }

    // assumes state is a legal state
    public double pEnd(State state, Agent agent) {
        if (agent.beliefState.isTerminal(state)) {
            return 1;
        }
        return 0;
    }



    private boolean isNonTerminalStateInThirdColumn(State state, Agent agent) {
        if (!agent.beliefState.isTerminal(state) && state.column == 3) {
            return true;
        }
        return false;
    }
}

