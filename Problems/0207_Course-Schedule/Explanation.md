# Course Schedule 

Observation: it is possible to finish all courses if and only if the course prerequisite graph does not contain a cycle.  
In other words, this problem is equivalent to determining whether or not the course prerequisite graph is acyclic.

## Approach 1: Modify DFS to Detect Back Edges ⭐

Our algorithm consists of two parts:
1. Store the graph as an [adjacency list]() (each prerequisite pair is a directed edge). This will improve runtime.
2. Use a modified version of [DFS]() to determine if the graph is acyclic.
  - If we encounter a gray vertex during DFS, we have found a back edge and the graph contains a cycle (return false)
  - If we do not encounter a gray vertex during DFS, the graph has no cycles (return true)

Below, I have highlighted the changes we need to make to DFS to determine if a graph is acyclic:

<script src="https://cdn.jsdelivr.net/gh/google/code-prettify@master/loader/run_prettify.js"></script>
<div style="display:inline-block">
<h4 style="margin-top:0">DFS (original)</h4>
<pre style="font-size:10.8px; background-color:whitesmoke"><code class="prettyprint" style="font-weight:bold">void DFS() {
    for (int u = 0; u < numVertices; u++)
        if (color[u] == 'w')
            visit(u);
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

<div style="display:inline-block">
<h4 style="margin-top:0">DFS (acyclic)</h4>
<pre style="font-size:10.8px; background-color:whitesmoke"><code class="prettyprint" style="font-weight:bold">// returns true if the graph is acyclic
<span style="background-color:orange">boolean</span> DFS() {
    for (int u = 0; u < numVertices; u++)
        if (color[u] == 'w')
            <span style="background-color:orange">if (visit(u)) return false;</span>
    <span style="background-color:orange">return true;</span>
}

// returns true if a cycle is found
<span style="background-color:orange">boolean</span> visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        if (color[v] == 'w') {
            <span style="background-color:orange">if (visit(v)) return true;</span> }
        // found back edge
        <span style="background-color:orange">else if (color[v] == 'g') return true;</span>
    color[u] = 'b';
    <span style="background-color:orange">return false;</span>
}
</code></pre>
</div>

<div style="display:inline-block">
<h4 style="margin-top:0">DFS (acyclic) rewritten</h4>
<pre style="font-size:10.8px"><code class="prettyprint" style="font-weight:bold">// returns true if the graph is acyclic
boolean DFS() {
    for (int u = 0; u < numVertices; u++)
        <mark>if (color[u] == 'w' && visit(u))</mark>
            <mark>return false;</mark>
    return true;
}

// returns true if a cycle is found
boolean visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        <mark>if (color[v] == 'w' && visit(v) || color[v] == 'g')</mark>
            <mark>return true;</mark>
    color[u] = 'b';
    return false;
}



</code></pre>
</div>

Here is the full commented solution:
<iframe src="https://leetcode.com/playground/x7ZQiFoi/shared" frameBorder="0" width="100%" height="730"></iframe>

#### Complexity Analysis
- **Time:** O(N)  
- **Space:** O(N)
