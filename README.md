# Instructions

1. Open vscode or IntelliJ and clone the repository.

2. Ensure you have java installed (you can check up opening terminal and executing `java --version`).

3. Open Terminal.

4. On the command line, cd into "src" directory. You should be in the "Simulator" directory initially (you can check by doing `pwd` on the terminal) hence by executing `cd src` on the terminal you should be able to get there.

5. First, open the terminal and compile the code by executing `javac ./com/company/RunSimulator.java`

6. Then open the terminal and run the program by executing `java com.company.RunSimulator <action> <action> ... <action> <observation> <observation> ... <observation> [<row>,<column>]`                  

    Note: It is optional to include the state.

7. Examples: 

    (1) `java com.company.RunSimulator up up up 2walls 2walls 2walls`

    (2) `java com.company.RunSimulator up up up 1wall 1wall 1wall`

    (3) `java com.company.RunSimulator right right up 1wall 1wall end \\[3,2\\]`

    (4) `java com.company.RunSimulator up right right right 2walls 2walls 1wall 1wall \\[1,1\\]`