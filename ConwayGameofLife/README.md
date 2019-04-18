# Conway's Game of Life

A Java implementation of Conway's Game of Life cellular automation.

Conway's Rules to Game of Life:

1. If a cell that is “populated” has <= 1 neighbor, or >= 4 neighbors, it dies. Otherwise, it survives. 
2. If an "unpopulated" cell has exactly 3 neighbors, it becomes populated.
3. Cells on the edge always remain unpopulated (0).

This program will:

1. Prompt the user to enter a list of pairs (i,j), both i and j being non-negative integers 
2. Stop accepting intputs when a negative integer is read for either i or j
3. Initialize the grid based on the (i,j) pairs entered by the user
4. Prompt the user to enter the number of time steps desired
5. Display the initial state of the grid 
6. For each time step, it will update the grid according to Conway’s rules and display the new grid.
