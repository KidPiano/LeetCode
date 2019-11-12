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

<div style="display:inline-block; text-align:left">
<h4>DFS (original)</h4>
<pre><code>void DFS() {
    for (int u = 0; u < numCourses; u++)
        if (color[u] == 'w')
            visit(u);
}

void visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        if (color[v] == 'w')
            visit(v);
    color[u] = 'b';
}</code></pre>
</div>

<div style="display:inline-block; text-align:left">
<h4>DFS (modified)</h4>
<pre><code><mark>boolean hasCycle()</mark> {
    for (int u = 0; u < numCourses; u++)
        <mark>if (color[u] == 'w' && visit(u))</mark>
            <mark>return false;</mark>
    <mark>return true;</mark>
}

<mark>boolean</mark> visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        <mark>if (color[v] == 'w' && visit(v) || color[v] == 'g')</mark>
            <mark>return true;</mark>
    color[u] = 'b';
    <mark>return false;</mark>
}</code></pre>
</div>

asdfasdf
asdf
asdf

<div style="display:inline-block; text-align:left">
<h4>DFS (original)</h4>
<pre><code>void DFS() {
    for (int u = 0; u < numCourses; u++)
        if (color[u] == 'w')
            visit(u);
}

void visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        if (color[v] == 'w')
            visit(v);
    color[u] = 'b';
}</code></pre>
</div>
