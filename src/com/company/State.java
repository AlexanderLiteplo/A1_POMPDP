package com.company;

public class State implements Comparable<State>{
    public int row;
    public int column;

    public State(int row, int column) {
        this.row = row;
        this.column = column;
    }

    //has to pass in a object so I casted it to a state below
    @Override
    public boolean equals(Object o) {
        State s = (State) o;
        if ((this.row == s.row) && (this.column == s.column)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode()
        // return Objects.hash(this.row, this.column);
    }

}