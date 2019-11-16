# Subtree of Another Tree 

## Approach 1: Brute Force ⭐
The brute force algorithm: for every node in the big tree _s_, check if it is the same as the small tree _t_. We use recursion to accomplish this:
- If the current node in _s_ is equal to the smaller tree _t_, return true
- Otherwise, recursively check if the current node's left child contains _t_ as a subtree, and then if the current node's right child contains _t_ as a subtree

The brute force algorithm: for every node in the big tree s, check if it is the same as the small tree t. We use recursion to accomplish this:
- If the current node in s is equal to the smaller tree t, return true
- Otherwise, recursively check if the current node's left child contains t as a subtree, and then if the current node's right child contains t as a subtree

<iframe src="https://leetcode.com/playground/YxKD2YGD/shared" frameBorder="0" width="100%" height="255"></iframe>

Note that in the isSameTree method, it is possible to replace the first two lines of code with `if (s == null || t == null) return s == t;`
For more details on the isSameTree implementation, check out my explanation for LeetCode problem [Same Tree](../0100_Same-Tree/Explanation.md).

#### Complexity Analysis
Let m = number of nodes in _s_  
Let n = number of nodes in _t_
- **Time:** O(mn). In the worst case scenario, there are many duplicate values in _s_ and _t_. We must check every node in _t_ for every node in _s_.  
- **Space:** O(m). Each recursive call takes up a stack frame, and the worst case scenario occurs when _s_ is skewed. Imagine we have m-x recursive calls of isSubtree when isSameTree is called. It takes at most x recursive calls to verify that the current node is not _t_.

## Approach 2: Brute Force Optimizations

## Approach 3: Reduction to Substring Problem (Attempt 1: String, indexOf) ⭐

## Approach 4: Reduction to Substring Problem (Attempt 2: StringBuffer, indexOf) ⭐

## Approach 5: Reduction to Substring Problem (Attempt 3: StringBuffer, KMP) ⭐

## Approach 6: HashSet
