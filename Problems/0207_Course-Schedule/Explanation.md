## Course Schedule 

Observation: It is possible to finish all courses if and only if the graph does not contain a cycle.
In other words, this problem basically boils down to whether or not the course schedule graph contains a cycle.

## Approach 1: Use DFS to Detect Back Edges
One of the simplest ways to determine whether a graph contains a cycle is by using a small modification of DFS to find back edges.
- If the graph contains a back edge, it contains a cycle (return false)
- If the graph does not contain a back edge, it does not contain a cycle (return true)

Below, I illustrate a standard DFS implementation in Java (left) and the modification to find back edges (right)
