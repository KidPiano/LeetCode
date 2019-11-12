# Course Schedule 

Observation: it is possible to finish all courses if and only if the course schedule dependency graph does not contain a cycle.  
In other words, this problem is equivalent to determining whether or not the course schedule graph is acyclic.

## Approach 1: Use DFS to Detect Back Edges
Our algorithm consists of two parts:
1. Store the graph as an adjacency list (each prerequisite pair is a directed edge). This will improve runtime.
2. Use a modified version of [DFS]() to detect cycles
  - if we encounter a gray vertex during DFS, we have found a cycle (return false)
  - if we do not encounter a gray vertex during DFS, there is no cycle (return true)

Below, I highlight the changes we need to make to DFS:

<div style="display:inline-block; text-align:left">
<h2>DFS (original)</h2>
<pre><code>
void DFS() {
    for (int i = 0; i < color.length; i++) color[i] = 'w';
    for (int u = 0; u < numCourses; u++) {
        if (color[u] == 'w') {
            visit(u);
        }
    }
}

void visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        if (color[v] == 'w')
            visit(v);
    color[u] = 'b';
}
</code></pre>
</div>

<div style="display:inline-block; text-align:left">
<h2>DFS (modified)</h2>
<pre><code>

boolean modified_DFS() {
    for (int i = 0; i < color.length; i++) color[i] = 'w';
    for (int u = 0; u < numCourses; u++)
        if (color[u] == 'w' && visit(u))
            return false;
    return true;
}

boolean modified_visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        if (color[v] == 'w' && visit(v) || color[v] == 'g')
            return true;
    color[u] = 'b';
    return false;
}



</code></pre>
</div>
