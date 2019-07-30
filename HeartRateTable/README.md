# HeartRateTable

Prints a range of target and maximum heart rates, depending on age and user's target input, as a table.

Learned how to use floating point values and while-loops

How to run (assuming in HeartRateTable directory):
- javac HeartRateTable.java
- java HeartRateTable

How to use:
- The user is prompted to enter an upper bound percentage and a lower bound percentage.
- The target range is calculated as (lower = (lower bound)(max)) and (upper = (upper bound)(max))
- The maximum is calculated  as: (max = 220 - age)
- The printed table consists of 3 columns: Age (which is incremented by 5 years for each row), Target Range, and Maximum heart rate.