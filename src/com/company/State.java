package com.company;

public class State {
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
        return super.hashCode();
        // return Objects.hash(this.row, this.column);
    }

}