package com.company;

public class Observation {

    // assumes state is a legal state
    public double p1Wall(State state, Agent agent) {
        if (isTerminalState(state, agent)) {
            return 0;
        }
        if (isNonTerminalStateInThirdColumn(state, agent)) {
            return 0.9;
        }
        return 0.1;
    }

    // assumes state is a legal state
    public double p2Wall(State state, Agent agent) {
        if (isTerminalState(state, agent)) {
            return 0;
        }
        if (isNonTerminalStateInThirdColumn(state, agent)) {
            return 0.1;
        }
        return 0.9;
    }

    // assumes state is a legal state
    public double pEnd(State state, Agent agent) {
        if (isTerminalState(state, agent)) {
            return 1;
        }
        return 0;
    }

    private boolean isTerminalState(State state, Agent agent) {
        State[] terminalStates = agent.beliefState.terminalStates;
        for (State terminalState : terminalStates) {
            if (state.equals(terminalState)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNonTerminalStateInThirdColumn(State state, Agent agent) {
        if (!isTerminalState(state, agent) && state.column == 3) {
            return true;
        }
        return false;
    }
}

