# Conway's Game of Life

A Java implementation of Conway's Game of Life cellular automation.

Conway's Rules to Game of Life:
- If a cell that is “populated” has <= 1 neighbor, or >= 4 neighbors, it dies. Otherwise, it survives. 
- If an "unpopulated" cell has exactly 3 neighbors, it becomes populated.
- Cells on the edge always remain unpopulated (0).

How to run (assuming inside of ConwayGameofLife directory):
- javac ConwayGameofLife.java
- java ConwayGameofLife

How to use:
- Enter a list of 2-dimensional coordinates
- Enter the number of time steps to be executed
- The program will update the array according to Conway's Rules to Game of Life