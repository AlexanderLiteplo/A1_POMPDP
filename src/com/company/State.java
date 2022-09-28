package com.company;

import java.util.Objects;

public class State implements Comparable<State>{
    public int row;
    public int column;

    public State(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        State s = (State) o;
        if ((this.row == s.row) && (this.column == s.column)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
//        return super.hashCode();
        return Objects.hash(this.row, this.column);
    }


    @Override
    public int compareTo(State o) {
        if(this.column == o .column && this.row == o.row)
            return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return "State{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}