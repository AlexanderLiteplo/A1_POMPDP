package com.company;

import java.io.*;

class Main {

  public static void main(String[] args) {

    State[][] testArray = new State[3][3];

    for(State[] arr : testArray) {
      for(State s : arr) {
        s = new State(1,2);
      }
    }

  }

  // Once we enter can we leave it?
  // If we can then can stateFrom ever equal a terminal state?

  public void render(Agent agent) {
    finalState = agent.beliefState.nextState;
    int rows = finalState.length;
    int cols = finalState[0].length;
    for (int row = rows - 1; row > 0; row--) {
      printTop(cols - 1);
      for (int col = 1; col < cols; col++) {
        double probability = finalState[row][col];
        System.out.print("| " + probability + " ");
      }
      System.out.print("|" + "\n");
    }
    printTop(cols - 1);
  }

  public void printTop(int entriesInColumns) {
    for (int col = 0; col < entriesInColumns; col++) {
      System.out.print("--");
    }
    System.out.print("\n");
  }


}
