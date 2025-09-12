
---
# Summary
- **FIND:** rapid answer → “Is there a path between A and B?”

1. Quick-Find (arrays): `find` O(1); `union` O(N)
2. Quick-Union (trees): `find` O(h); `union` O(1)
    - Improvements:
        - **Path compression:** during `find`, intermediate nodes are directly linked to the root.
        - **Union by rank:** tracks the size of the trees and, during `union`, attaches the smaller tree to the root
      of the larger one.
---
# Union Find - Disjoint Set Union


Think about real-world objects, such as islands(objects) and bridges(connections).

Union-Find is a data structure that models connected components — basically, objects and the
connections between them. 

Union-Find answers a central question:

**_“Is there a path between p and q?”_** If so, they are in the same connected component.

It supports two main operations:
1. **Find(p):** finds the root of the set containing p. The root is like the “representative” of that group.
2. **Union(p, q):** joins the sets containing p and q.

The goal of Union-Find is to be able to answer **very** quickly whether two elements are connected or not.

---

# 1. Quick-Find (arrays)

Quick-Find is one of the classic implementations of Union-Find. The idea is that each position in
the array stores the ID of the set to which the element belongs.

- **Find(p):** just compare: `id[p] == id[q]`. If they are equal, they are connected.  
  Cost: O(1), very fast.

- **Union(p, q):** we need to go through the entire array and update all elements with the ID of p to the ID of q.  
  Cost: O(N), because in the worst case we have to modify all elements.

In other words:

- **FIND** is very cheap (just one comparison).
- **UNION** is expensive, as it may require updating the entire array.

This is the essence of Quick-Find: fast to check, slow to merge.

---

# 2. Quick-Union (trees)

- **Union:** We use a method that, given an object, returns its root (using recursion or iteration). To unite
  two objects, we compare their roots. If they are different, we make one root point to the other.
- **Find:** This operation becomes slower. Long, thin trees can be form on union, which increases traversal time.

---

# Improvements

## 1. Weighted Union (see `algorithms.WeightedQU.java`)

- Avoids creating tall, thin trees.
- Keeps track of the size of each tree.
- Always attaches the smaller tree under the larger one (so the structure grows laterally instead of vertically).

### Complexity

Quick-Find:
- `connected` → O(1)
- `union` → O(N)

Quick-Union:
- `connected` → O(N)
- `union` → O(N)

Weighted Union:
- Both operations improve to O(log N).

**Proof:**

**Goal:** Show that `union` runs in O(log N) after applying weighting.

Observation: the dominant cost lies in finding the root. Therefore, we need root-finding to be O(log N).

To guarantee this, the distance from any node to its root must be at most log N.

Reasoning:
- Suppose in the worst case a node in tree T1 is at distance r from the root.
- With each `union`, the distance can increase by 1, but only if |T2| ≥ |T1|.
- In that case, the resulting tree T3 will be at least twice as large as T1 (|T3| ≥ 2 × |T1|).
- This doubling can repeat at most log N times.

Thus, the distance satisfies:  
O(d) = O(r + log N) = O(log N).

---

## 2. Path Compression

During `find`, all intermediate nodes are updated to point directly to the root, flattening the 
structure and drastically reducing future search times.

---


