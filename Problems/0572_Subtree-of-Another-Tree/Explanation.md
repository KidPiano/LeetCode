<!-- MathJax -->
<script src="https://polyfill.io/v3/polyfill.min.js?features=es6"></script>
<script id="MathJax-script" async src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>

# Subtree of Another Tree 

## Approach 1: Brute Force
For every node in the bigger tree s, we want to check if it is the same tree as the smaller tree t. We use recursion to accomplish this:
- If the current node in s is equal to the smaller tree t, return true
- Otherwise, recursively check if the current node's left child contains t as a subtree, and then if the current node's right child contains t as a subtree

<iframe src="https://leetcode.com/playground/YxKD2YGD/shared" frameBorder="0" width="100%" height="255"></iframe>

Note that in the isSameTree method, it is possible to replace the first two lines of code with `if (s == null || t == null) return s == t;`
For more details on the isSameTree implementation, check out my explanation for LeetCode problem [Same Tree](../0100_Same-Tree/Explanation.md).

#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- <div><b>Time:</b> \(O(mn)\). In the worst case scenario, there are many duplicate values in s and t and we must check every node in t for every node in s.</div>
- <div><b>Space:</b> \(O(m)\). Each recursive call takes up a stack frame, and the worst case scenario occurs when s is skewed. Imagine we are \(m-x\) recursive calls deep into isSubtree when isSameTree is called. It takes at most \(x+1\) recursive calls of isSameTree to reach a null child in s and verify that the current node is not t. Therefore, we will never use more than \(m+1\) stack frames.</div>

## Approach 2: Brute Force Optimization

#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- <div><b>Time:</b> \(O(mn)\)</div>
- <div><b>Space:</b> \(O(m)\)</div>

## Approach 3: Reduction to Substring Problem (Attempt 1: String, indexOf) ⭐
Another approach to this problem is to reduce it to the substring problem first. The algorithm for this approach consists of 3 steps:
1. Serialize s - traverse the bigger tree s and store the order of the traversal in `string_s`
2. Serialize t - traverse the smaller tree t and store the order of the traversal in `string_t`
3. Return whether or not `string_t` is a substring of `string_s`

Things to note:
- When we serialize a tree, we will use the letter "N" to represent a null child (see picture below).
- When we serialize a tree, we will use the "#" symbol as a delimiter in the strings to separate node values (see picture below).
- When we serialize a tree, we will traverse the nodes using a [preorder traversal](). If an [inorder traversal]() or a [postorder traversal]() was used instead, we would need to differentiate between left null children and right null children.
- When checking whether `string_t` is a substring of `string_s`, we will use Java's built in library function `indexOf()`, which returns the index of the first occurrence of `string_t` in `string_s`, and -1 otherwise.

Insert picture here.asdfasdf

asdfasdf
<iframe src="https://leetcode.com/playground/YfqkE2mS/shared" frameBorder="0" width="100%" height="255"></iframe>

#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- <div><b>Time:</b> \(O(m^2+n^2+mn)\). With the code above, traversing the bigger tree s takes \(O(m^2\) time. This is because strings are immutable in Java. Therefore, when we append to the string m times, we are actually creating m new strings, each with length \(O(m)\). The same reasoning is why traversing the smaller tree t takes \(O(n^2\) time. Lastly, the Java library function indexOf takes mn time.</div>
- <div><b>Space:</b> \(O(m+n)\)</div>

## Approach 4: Reduction to Substring Problem (Attempt 2: StringBuffer, indexOf) ⭐

<iframe src="https://leetcode.com/playground/LcwEF8ZC/shared" frameBorder="0" width="100%" height="425"></iframe>

#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- <div><b>Time:</b> \(O(mn)\)</div>
- <div><b>Space:</b> \(O(m)\)</div>

## Approach 5: Reduction to Substring Problem (Attempt 3: StringBuffer, KMP) ⭐

#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- <div><b>Time:</b> \(O(mn)\)</div>
- <div><b>Space:</b> \(O(m)\)</div>

## Approach 6: Reduction to Substring Problem (Attempt 4: StringBuffer, KMP, Morris Traversal) ⭐

#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- <div><b>Time:</b> \(O(mn)\)</div>
- <div><b>Space:</b> \(O(m)\)</div>

## Approach 6: HashSet


#### Complexity Analysis
Let m = number of nodes in s  
Let n = number of nodes in t
- <div><b>Time:</b> \(O(mn)\)</div>
- <div><b>Space:</b> \(O(m)\)</div>
