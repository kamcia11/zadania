# Introduction
Author: Kamila Puchała

This file contains key information about the NCDC House of Talents recruitment task.
## The aim of the project
The annual 24 hour race of spaceplanes moving on a torus.
### Technologies
Java 17
#### Assumptions
Parameters for running the program - torus dimensions:
- wielkoscTourosaX is an integer between 1 and 100,000,
- wielkoscTourosaY is an integer between 1 and 100 000;

From the point of view of the spaceplanes, the surface is flat;

Spaceplane move at constant speeds;

All spaceplanes teleport simultaneously;

The program should be robust to erroneous input including:
- problem with file
- not satisfying the criteria of torus size x or torus size y,
  then the program should output only the word "klops";
  Additionally, the program will use the word "klops" when there is a problem in determining the outcome of a race, that is, if there was neither a winner or a draw.

If, after teleportation, there is more than one spaceplane in one cell, they all drop out;

The program verifies the spaceplane names:
- Alphanumeric (A-Za-z0-9),
- Non-empty,
- Not longer than 10 characters,
- Cannot be repeated.

The program verifies the teleportation speed Vx:
- Total,
- not less than -10000
- not greater than 10000

The program verifies the teleportation speed Vy:
- total,
- not less than -10000
- not greater than 10000

The program verifies the starting position x of the spaceplane:
- integer value from 0 to wielkoscTourosaX-1;

The program verifies the y starting position of the spaceplane:
- integer value from 0 to wielkoscTourosaY-1;

The spaceplane which, after 24 hours, has covered the greater distance on the plane, calculated in cells, wins;

Spaceplanes that have fallen off (annihilated) cannot choose;

The program has to write ONLY the name of the winning spaceplane. However, if none of them wins:
- because they all annihilated,
- or the greatest distance was covered by more than one spaceplane
  then the program should write the word draw.
##### Running and compile
To compile program run following command:

    javac *.java

Example command for run this program:

    java Kosmoloty 1000 10000 < plik.txt
###### Verification tests
The tests have been carried out in the Command line in Windows 10.
For the test data a list of 100,000 spaceplanes has been prepared in MS Excel using formulas, which makes the file ready to apply values according to current and future expectations from the program (file attached).
Files plik.txt, plik1.txt and plik2.txt were the test data files. In case of checking is data are correct files were modified for tests purpose (example: duplicates names or start positions).

In 2 minutes, the program was able to evaluate command java Kosmoloty 1000 6000 < plik.txt with 2500 spaceplanes.
According to the task notes, the time limit for the execution of the program is 30 seconds for 100,000 spaceplane, which was not achieved. It can be assumed that aggravating issues are the problem.

###### Additional information
Please note that commented code in files was left for reviewer as clue how was looking debug process in case of errors during development process.