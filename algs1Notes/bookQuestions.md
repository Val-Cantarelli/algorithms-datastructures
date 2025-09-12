# Book Questions

## 1. Question 1.5.5 (Open-ended)
Estimate the minimum amount of time (in days) required for quick-find to solve a dynamic connectivity problem with $10^9$ sites and $10^6$ input pairs, on a computer capable of executing $10^9$ instructions per second. Assume that each iteration of the inner for loop requires 10 machine instructions.

**Calculation:**

Total = input pairs × N (sites) × 10 (machine instructions) / CPU ($10^9$)

Total = $10^6 \times (10^9 \times 10) / 10^9 = 10^7$ seconds

$10^7$ seconds $\div$ (60 × 60 × 24) ≈ **115 days**

---

## 2. Which input array property is most effective when using 3-way partitioning with quicksort?

**Answer:**
Few distinct keys.

---

## 3. What is the main advantage of three-way partitioning in Quicksort for arrays with many duplicate keys?

**Answer:**
Three-way partitioning divides the array into three parts: less than, equal to, and greater than the partitioning element. This approach minimizes comparisons and achieves entropy optimality, making it efficient for sorting arrays with many duplicate keys.

---

## 4. Discuss the theoretical significance and practical limitations of the linear time selection algorithm (Median of Medians, 1973). How does this compare to Quickselect in terms of average and worst-case performance?

**Answer:**
Median of Medians (1973) guarantees $O(n)$ linear time complexity, but is slower in practice due to the overhead of finding a good pivot. Quickselect does not guarantee linear time in the worst case (it can be $O(n^2)$), but this is rare. On average, Quickselect runs in expected $O(n)$ time and is faster in practice.

---

## 5. Explain how the partitioning process in the quicksort algorithm works and why it is crucial for the algorithm's efficiency.

**Answer:**
Partitioning in quicksort involves selecting a 'pivot' element and rearranging the array so that all elements less than the pivot are on its left, and all elements greater are on its right. This process places the pivot in its correct position in the sorted array and divides the problem into two smaller subproblems. Although partitioning itself is $O(n)$, it enables the entire quicksort algorithm to run in expected $O(n \log n)$ time due to the logarithmic depth of recursion.

---

## 6. What is the expected running time of randomized quicksort to sort an array of n distinct keys when the array is already sorted?

**Answer:**
Linear-logarithmic $O(n \log n)$.

---

## 7. Discuss the reasoning behind using both quicksort and mergesort in Java's Arrays.sort method. Why does the choice of algorithm depend on the data type being sorted, and what are the implications of this decision in terms of performance and memory usage?

**Answer:**
Java's `Arrays.sort` uses Quicksort for primitives because it is fast and in-place, and primitives do not have associated metadata that needs to be preserved. For objects, it uses Mergesort because it is stable, meaning it maintains the relative order of equal elements. The trade-off is that Mergesort is slightly slower and requires extra memory for a temporary array during merging, but it guarantees $O(n \log n)$ performance, whereas Quicksort can degrade to $O(n^2)$ in the worst case, though it is typically faster.

---

## 8. Why does Arrays.sort() in Java use mergesort instead of quicksort when sorting reference types?

**Answer:**
Mergesort is used for reference types in Java's `Arrays.sort()` because it is a stable sort, meaning that it maintains the relative order of records with equal keys (important for object sorting). Additionally, Mergesort guarantees $O(n \log n)$ time complexity, providing reliable performance regardless of the input data characteristics, unlike Quicksort which can degrade to $O(n^2)$ in the worst case.

