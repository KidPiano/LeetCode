# Course Schedule II 

Observation: this problem is equivalent to finding a reverse topological sort of the course prerequisite graph (if it exists). A valid course order will exist if the course prerequisite graph is acyclic.

## Approach 1: Modify DFS to Find a Reverse Topological Sort ⭐
Our algorithm consists of two parts:
1. Store the graph as an [adjacency list]() (each prerequisite pair is a directed edge). This will improve runtime.
2. Use a modified version of [DFS]() to find a reverse [topological sort]() of the graph if it is acyclic.

In Approach 1 for Course Schedule, we saw how to modify DFS to determine if a graph if acyclic. Using this as a starting point, we only need to make a minor change to our code to store the reverse topological sort in our answer array. We simply need to append vertices to our answer array as they finish during DFS. I have highlighted these changes below:



