ArrayList Insert: 66500 ns
LinkedList Insert: 16800 ns
ArrayList get(i): 400 ns
LinkedList get(i): 495000 ns
Retrieved values: 49999, 49999

# Day 7 – Library Waitlist Management System

## Performance Comparison: ArrayList vs LinkedList

### Objective
To compare the execution times of ArrayList and LinkedList for insertion at the beginning and indexed element retrieval using `get(i)`.

### Timing Results

| Operation | ArrayList (ns) | LinkedList (ns) |
|---|---:|---:|
| Insert at Beginning | 66,500 | 16,800 |
| Access Middle Element using get(i) | 400 | 495,000 |

### Test Details
- Programming Language: Java 21
- Number of Elements: 100,000
- Timing Method: System.nanoTime()
- Retrieved Values: 49999, 49999

### Observations

1. **Insertion Performance:** LinkedList completed insertion at the beginning in 16,800 ns, while ArrayList required 66,500 ns.

2. **Retrieval Performance:** ArrayList retrieved the middle element in 400 ns, while LinkedList required 495,000 ns.

3. **ArrayList:** Provides efficient indexed access with O(1) time complexity.

4. **LinkedList:** Provides O(1) insertion at the beginning but requires O(n) time for indexed access.

5. **Performance Difference:** In this test, ArrayList indexed access was approximately 1,237.5 times faster than LinkedList indexed access.

### Conclusion

The results demonstrate the performance characteristics of ArrayList and LinkedList.

ArrayList is generally suitable for applications requiring frequent indexed access, while LinkedList can be useful for frequent insertions at the beginning.

These results represent a single execution of each operation. They are illustrative measurements rather than statistically reliable benchmarks. JVM warm-up, JIT optimization, garbage collection, and system conditions can affect execution times.