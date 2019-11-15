# Subtree of Another Tree 

## Approach 1: Brute Force ⭐
The brute force algorithm is simple: for every node in the big tree _s_, check if it is the same as the small tree _t_:
- If the current node in s is equal to t, return true
- Otherwise, check if the current node's left child is equal to t, and then check if its right child is equal to t

Below, I provide two ways to write this:



For more details on the isSameTree implementation, check out my explanation for LeetCode problem [Same Tree](../0100_Same-Tree/Explanation.md).

#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- **Time:** O(mn)  
- **Space:** O(m+n)

## Approach 2: Brute Force Optimizations

## Approach 3: Reduction to Substring Problem (Attempt 1: String, indexOf) ⭐

## Approach 4: Reduction to Substring Problem (Attempt 2: StringBuffer, indexOf) ⭐

## Approach 5: Reduction to Substring Problem (Attempt 3: StringBuffer, KMP) ⭐

## Approach 6: HashSet
