# Course Schedule 

Observation: it is possible to finish all courses if and only if the course schedule dependency graph does not contain a cycle.  
In other words, this problem is equivalent to determining whether or not the course schedule graph is acyclic.

## Approach 1: Use DFS to Detect Back Edges
Our algorithm consists of two parts:
1. Store the graph as an adjacency list (each prerequisite pair is a directed edge). This will improve runtime.
2. Use a modified version of [DFS]() to determine if a graph has no cycles.
  - if we encounter a gray vertex during DFS, we have found a cycle (return false)
  - if we do not encounter a gray vertex during DFS, there is no cycle (return true)

Below, I have highlighted the changes we need to make to DFS to determine if a graph has no cycles:

<img src='https://lh3.googleusercontent.com/S1rId_OBDGRVXWMkIWSBbyf38GXxjygVMzbB2L7B4-h8AEO0-Zgy3lyeS4JzOc9k7eNNmWCr4n95mSbwy8ik4SUhdHEKPfy-d71qKzmfvdHmMvoJ7E74usT9pFaIE0oySsg91vPe=w2400' />

Here is the full commented solution:
<iframe src="https://leetcode.com/playground/x7ZQiFoi/shared" frameBorder="0" width="510" height="750"></iframe>
