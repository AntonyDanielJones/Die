# Die
Contains a die class, which allows the simulation of an n-sided die, and a tester class.

## DieTester.java
Usage: DieTester NUMBER_OF_SIDES NUMBER_OF_TRIALS

Example:
```
>java DieTester 6 10000000
A 6-sided die was rolled 10000000 times. Here are the results.

DISTRIBUTION:   [1665033, 1666527, 1666899, 1667508, 1668179, 1665854]
 --> (%):       [16.65, 16.67, 16.67, 16.68, 16.68, 16.66, ]
MIN ROLL:       1.0
MAX ROLL:       6.0
AVERAGE ROLL:   3.5004835
MOST COMMON ROLL(S):    5,      (rolled 1668179 times)
LEAST COMMON ROLL(S):   1,      (rolled 1665033 times)