# Solving Ax=b

```
|1 2 2 2 |  |1|
|2 4 6 8 |x=|5|
|3 6 8 10|  |6|
```

Ax=b is solvable when b is in C(A). Complete solution:

1. Find a particular solution x: set all free variables = 0 and solve Ax=b for pivot variables
2. Add vectors from N(A) 

```
|1     |   |1 2 2 2 |1|   |1 2 2 2  | 1|
|-2 1 0| * |2 4 6 8 |5| = |    2 4  | 3|
|      |   |3 6 8 10|6|   |3 6 8 10 | 6|

|1       |   |1     |   |1 2 2 2 |1|   |1 2 2 2| 1 |
|0  1/2  | * |-2 1 0| * |2 4 6 8 |5| = |    1 2|3/2|
|-3 -1  1|   |      |   |3 6 8 10|6|   |       |   |
                         p f p f        p f p f
p - pivot
f - free
```
```
     | 1 |
xp = |   |     
     |3/2|     
     |   |     
because:

|1 2 2 2|     | 1 | 
|    1 2| xp =|3/2| 
|       |     |   | 
```

```              
        |-2|    |-2|
N(A) = ɑ| 1| + β|  |
        |  |    |-2|
        |  |    | 1|
because
|1 2 2 2|   |-2 -2|
|    1 2| * | 1   | = 0
|       |   |   -2|
            |    1|

```

* `xp` is a solution that satisfies Ax=b, only pivot columns were used. 
* `xn` comes from the Null Space: since `b` in some rows equals 0, then those rows also must be 0-rows, so we're
looking for a combination of `x`'s that produces 0.

So general solution:

```
            | 1 |    |-2|    |-2|
x=xp + xn = | 0 | + ɑ| 1| + β|  |
            |3/2|    |  |    |-2|
            | 0 |    |  |    | 1|  
```