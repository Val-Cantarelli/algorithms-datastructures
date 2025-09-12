# Hash Tables: Key Concepts

---

- **Definition:** Hash tables are data structures that provide efficient key-value pair storage and retrieval.
- **Hash Function:** Computes an index into an array of buckets or slots, where the value is stored.
- **Main Operations:**
  - Insertion
  - Deletion
  - Lookup
  - All typically have average-case constant time complexity, O(1).

- **Applications:**
  - Used in databases, caches, and sets for fast access and storage.

- **Performance Factors:**
  - Efficiency depends on the hash function and load factor (elements per bucket).
  - Good hash functions distribute keys uniformly, minimizing collisions.
  - When the load factor is too high, resizing is required to maintain performance.

- **Limitations:**
  - Not suitable for ordered data (no key order maintained).
  - Not ideal for frequent resizing or memory-constrained environments (can use more memory than arrays or linked lists).

- **Collisions:**
  - Occur when two keys hash to the same index.
  - **Collision Resolution:**
    - **Separate Chaining:** Store multiple items at the same index using a linked list.
    - **Open Addressing:** Find another open slot in the array for the colliding item.

- **Trade-offs:**
  - Collision resolution strategy affects performance and memory usage.
  - Open addressing is efficient for caching; chaining is flexible for dynamic data.

---


## 1. Hash Functions
- Transform the key into a **32-bit integer**.
- Should be:
    - **Fast to compute**.
    - **Uniform**: each table index should be equally likely.

### Practical Examples
- **Phone Numbers**: Don't use just the area code → too much repetition.Instead: code area+number and other fields that are univocal.
- **Social Security Numbers**: Don't use just the first three digits → geographic bias.
- **Java Strings**: Use a polynomial with base 31.


```java
int hash = 0;
for (int i = 0; i < s.length(); i++) {
    hash = 31 * hash + s.charAt(i);
}
```
Example:

"casa".hashCode() = 3049753.

## 2. equals and hashCode Contract
Fundamental rule:

If `a.equals(b) == true` then `a.hashCode() == b.hashCode()`.

Always use the same fields in `equals` and `hashCode`.

Example in Java:
```java
class Person {
    String name;
    LocalDate birthDate;
    double income;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return Double.compare(p.income, income) == 0 &&
               Objects.equals(name, p.name) &&
               Objects.equals(birthDate, p.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, income);
    }
}
```

## 3. Reducing to Index
`hashCode()` can be negative.

We need to map it to `0..M-1`:

```java
int index = (hash & 0x7fffffff) % M;
```
Typically, `M` is chosen as a prime number or a power of 2.

In Java, `HashMap` uses powers of 2 and applies a bit mix to spread out the values.

## 4. Load Factor and Resizing
Load factor:

𝛼 =𝑁 /𝑀
α= M /N ​
 
Controls performance:

Chaining: cost ≈ 1 + α.

Probing: performance degrades significantly when α > 0.7.

Rehashing: when α exceeds a threshold (Java `HashMap` → 0.75).

The table size doubles.

All elements are rehashed.

## 5. Probability and Distribution
Hashing can be modeled as the problem of balls in urns:

- **Birthday Problem**: collisions occur surprisingly early (~√M elements).
- **Coupon Collector**: to fill all buckets, ~M log M insertions are needed.
- **Maximum Load**: for N ≈ M, the fullest bucket has ~log M / log log M elements.

These results help predict average behavior.

## 6. General Summary
Hashing → expected access in O(1).

No sorting → does not support min, max, range [a,b].

A well-designed hash function and proper resizing are crucial.

Chaining is robust for dynamic data.

Linear probing is excellent for cache, as long as α remains low.
