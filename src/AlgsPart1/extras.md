# Summary: HashMap, Binary Heap (PriorityQueue), and TreeMap

A comparison of the implementations, characteristics, and performance of `HashMap`, `Binary Heap` (via `PriorityQueue`), and `TreeMap`.

---

## 1. HashMap

- **Implements:** `Map` - internally uses an array
- **Stores:** key → value pairs
- **Ordering:** Not ordered
- **How it works:**
    - Applies a hash function to the key.
    - Computes the index in the internal array using: `hash % array_size`.
    - Collisions are resolved using linked lists (chaining).
- **Expected complexity:**
    - Insert / lookup / remove: `O(1)` average, `O(n)` worst case

---

## 2. Binary Heap (`PriorityQueue`)

- **Implements:** `PriorityQueue`- internally uses an array
- **Stores:** values only (no key)
- **Ordering:** Partial — only the root has guaranteed priority
- **How it works:**
    - Binary heap represented as a complete binary tree in an array.
    - Insertion uses `swim`; removal uses `sink`.
    - Priority is determined by natural order or a provided comparator.
- **Property:** the root always contains the highest (or lowest) priority element.
- **Expected complexity:**
    - Insert and remove: `O(log n)`

> If you remove all elements one by one, you'll get them in order — but the heap does not maintain total visible ordering.

---

## 3. TreeMap

- **Implements:** `Map`, `NavigableMap` - internally uses object
- **Stores:** key → value pairs
- **Ordering:** Fully ordered by keys (natural order or custom comparator)
- **How it works:**
    - Based on a balanced binary search tree (e.g., Red-Black Tree).
    - Maintains all entries in sorted key order.
- **Expected complexity:**
    - Insert / lookup / remove: `O(log n)`
- **Advantages:**
    - Supports ordered operations like `subMap`, `firstKey`, `ceilingEntry`, etc.

---

## Comparison Table

| Structure               | Key-Value? | Ordered?               | Lookup Complexity     | Main Interface         |
|-------------------------|------------|-------------------------|------------------------|-------------------------|
| `HashMap`               | Yes        | No                      | Average: `O(1)`        | `Map`                   |
| `PriorityQueue` (Heap)  | No         | Partial (root only)     | `O(log n)`             | `Queue`                 |
| `TreeMap`               | Yes        | Yes (by key)            | `O(log n)`             | `Map`, `NavigableMap`   |


