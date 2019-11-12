# Course Schedule 

Observation: It is possible to finish all courses if and only if the graph does not contain a cycle.
In other words, this problem is equivalent to determining whether or not the course schedule graph is acyclic.

## Approach 1: Use DFS to Detect Back Edges
One of the simplest ways to determine whether a graph contains a cycle is by using a small modification of DFS to find back edges.
- If the graph contains a back edge, it contains a cycle (return false)
- If the graph does not contain a back edge, it does not contain a cycle (return true)

So how do we modify DFS to detect back edges? It is very simple

I illustrate this below.
On the left hand side is a standard DFS implementation in Java, and on 
Below, I illustrate a standard DFS implementation in Java (left) and the modification to find back edges (right)
