# Day 10 - Java Memory Lab

## Objective

To understand Java memory management through five practical experiments involving stack memory, heap memory, garbage collection, string performance, and Integer caching.

## Experiments

1. StackOverflowError using different stack sizes (-Xss)
2. OutOfMemoryError using a limited heap (-Xmx64m)
3. String concatenation vs StringBuilder performance
4. Garbage collection logging using -Xlog:gc
5. Integer caching and reference comparison

## Technologies Used

- Java 21
- Maven
- IntelliJ IDEA

## Experimental Results

| Experiment | Observation |
|------------|-------------|
| StackOverflowError | Increasing stack size generally allows deeper recursion |
| OutOfMemoryError | 31 arrays allocated with 64 MB heap |
| String vs StringBuilder | String += took 173.4728 ms; StringBuilder took 1.8857 ms |
| Garbage Collection | G1 Garbage Collector; 142 GC events |
| Integer Cache | 100 == 100 returned true; 200 == 200 returned false |

## Results

Detailed experimental results, JVM configurations, and observations are documented in [RESULTS.md](RESULTS.md).

## Key Learnings

- Stack memory is used for method execution and recursion.
- Heap memory stores objects and arrays.
- Limited heap memory can cause OutOfMemoryError.
- StringBuilder is more efficient for repeated string concatenation.
- Garbage collection automatically reclaims memory from unreachable objects.
- Integer caching affects reference comparisons using ==.
- The equals() method should be used to compare Integer values.

## Conclusion

The Java Memory Lab successfully demonstrated important Java memory management concepts through five experiments.

The experiments helped in understanding stack and heap limitations, garbage collection behavior, string performance optimization, and Integer caching.

All five experiments were executed successfully.