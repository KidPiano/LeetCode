# Subtree of Another Tree 

## Approach 1: Brute Force ⭐
For every node in the big tree s, we want to check if it is the same as the small tree t. We use recursion to accomplish this:
- If the current node in s is equal to the smaller tree t, return true
- Otherwise, recursively check if the current node's left child contains t as a subtree, and then if the current node's right child contains t as a subtree

<iframe src="https://leetcode.com/playground/YxKD2YGD/shared" frameBorder="0" width="100%" height="255"></iframe>

Note that in the isSameTree method, it is possible to replace the first two lines of code with `if (s == null || t == null) return s == t;`
For more details on the isSameTree implementation, check out my explanation for LeetCode problem [Same Tree](../0100_Same-Tree/Explanation.md).

#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- **Time:** O(mn). In the worst case scenario, there are many duplicate values in s and t. We must check every node in t for every node in s.  
- **Space:** O(m). Each recursive call takes up a stack frame, and the worst case scenario occurs when s is skewed. Imagine we are m-x recursive calls deep into isSubtree when isSameTree is called. It takes at most x+1 recursive calls of isSameTree to verify that the current node is not t, because we reach a null child in s.

## Approach 2: Brute Force Optimizations

## Approach 3: Reduction to Substring Problem (Attempt 1: String, indexOf) ⭐

## Approach 4: Reduction to Substring Problem (Attempt 2: StringBuffer, indexOf) ⭐

## Approach 5: Reduction to Substring Problem (Attempt 3: StringBuffer, KMP) ⭐

## Approach 6: HashSet
