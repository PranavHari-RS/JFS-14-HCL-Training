| Stack Size | Maximum Recursion Depth |
|---|---|
| 256 KB | 2392 |
| 512 KB | 7226 |
| 1 MB | 22372 |
# Day 10 - Java Memory Lab Results

## Experiment 1: StackOverflowError

| Stack Size | Maximum Recursion Depth |
|------------|-------------------------|
| 256 KB | 2392 |
| 512 KB | 7226 |
| 1 MB | 22372 |

Observation:
Increasing stack size generally allows deeper recursion
before StackOverflowError occurs.

## Experiment 2: OutOfMemoryError

### JVM Configuration
-Xmx64m

### Command
java -Xmx64m -cp target/classes com.pgcrp.memorylab.OutOfMemoryDemo

### Results

| Heap Size | Arrays Allocated | Result |
|-----------|------------------|--------|
| 64 MB | 31 | OutOfMemoryError |

### Observation

The JVM successfully allocated 31 arrays of 1 MB each.

When attempting to allocate additional memory, the JVM
threw an OutOfMemoryError.

Although the maximum heap size was 64 MB, the program
could not allocate 64 arrays because the heap also contains
other objects and JVM allocation overhead.

The arrays remained reachable through the ArrayList,
preventing garbage collection from reclaiming them.

## Experiment 3: String vs StringBuilder

| Method | Execution Time (ms) |
|--------|---------------------|
| String += | 173.4728 |
| StringBuilder | 1.8857 |

### Observation

StringBuilder is approximately 92 times faster than
String += in this experiment.

Both methods produced strings of equal length (88890).

String += repeatedly creates new String objects,
increasing memory allocation and execution time.

StringBuilder modifies a reusable buffer, making it
more efficient for repeated concatenation.

### Conclusion

StringBuilder is recommended for repeated string
concatenation inside loops.

## Experiment 4: Garbage Collection

### JVM Configuration

-Xmx64m -Xlog:gc

### Command

java -Xmx64m -Xlog:gc -cp target/classes com.pgcrp.memorylab.GarbageCollectionDemo

### Results

| Parameter | Result |
|-----------|--------|
| JVM Option | -Xmx64m -Xlog:gc |
| Garbage Collector | G1 |
| Maximum Heap Size | 64 MB |
| Total GC Events | 142 |
| Young GC Pauses | 71 |
| Concurrent Undo Cycles | 71 |
| Execution Status | Completed Successfully |

### Sample GC Output

[0.006s][info][gc] Using G1

Garbage Collection Demo Started

[0.047s][info][gc] GC(0) Pause Young (Concurrent Start)
(G1 Humongous Allocation) 30M->0M(64M) 1.048ms

[0.047s][info][gc] GC(1) Concurrent Undo Cycle

[0.047s][info][gc] GC(1) Concurrent Undo Cycle 0.128ms

Garbage Collection Demo Completed

### Observation

The JVM used the G1 Garbage Collector.

The maximum heap size was limited to 64 MB.

A total of 142 unique GC events were recorded.

The logs showed 71 Young GC pauses and
71 Concurrent Undo Cycles.

Temporary byte arrays were allocated during execution.

The garbage collector reclaimed memory occupied by
unreachable objects.

The program completed successfully without
OutOfMemoryError.

### Conclusion

Garbage collection automatically manages heap memory
by reclaiming memory from unreachable objects.

The -Xlog:gc option helps monitor garbage collection
activity and memory usage.

## Experiment 5: Integer Cache

### Command

java -cp target/classes com.pgcrp.memorylab.IntegerCacheDemo

### Results

| Comparison | Result |
|------------|--------|
| Integer 100 == 100 | true |
| Integer 200 == 200 | false |
| Integer 100 equals 100 | true |
| Integer 200 equals 200 | true |

### Observation

Java caches Integer objects from -128 to 127 by default.

When comparing Integer objects containing 100 using ==,
the result is true because both references point to
the same cached object.

When comparing Integer objects containing 200 using ==,
the result is false because they refer to different objects.

The equals() method compares the actual integer values,
so both comparisons return true.

### Conclusion

Use equals() instead of == when comparing the values
of Integer wrapper objects.