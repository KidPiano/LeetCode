# Course Schedule 

Observation: it is possible to finish all courses if and only if the course schedule dependency graph does not contain a cycle.  
In other words, this problem is equivalent to determining whether or not the course schedule graph is acyclic.

## Approach 1: Use DFS to Detect Back Edges
Our algorithm consists of two parts:
1. Store the graph as an [adjacency list]() (each prerequisite pair is a directed edge). This will improve runtime.
2. Use a modified version of [DFS]() to determine if a graph is acyclic.
  - if we encounter a gray vertex during DFS, we have found a cycle (return false)
  - if we do not encounter a gray vertex during DFS, there is no cycle (return true)

Below, I have highlighted the changes we need to make to DFS to determine if a graph is acyclic:

<img src='https://lh3.googleusercontent.com/S1rId_OBDGRVXWMkIWSBbyf38GXxjygVMzbB2L7B4-h8AEO0-Zgy3lyeS4JzOc9k7eNNmWCr4n95mSbwy8ik4SUhdHEKPfy-d71qKzmfvdHmMvoJ7E74usT9pFaIE0oySsg91vPe=w2400' />

Here is the full commented solution:
<iframe src="https://leetcode.com/playground/x7ZQiFoi/shared" frameBorder="0" width="100%" height="730"></iframe>

<div style="display:inline-block; text-align:left">
<h4>DFS (original)</h4>
<pre style="font-size:10.6px"><code>void DFS() {
    for (int i = 0; i < color.length; i++)
        color[i] = 'w';
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

<div style="display:inline-block; text-align:left">
<h4>DFS (modified)</h4>
<pre style="font-size:10.6px"><code>// returns true if the graph is acyclic
<span style="background-color:orange">boolean</span> DFS() {
    for (int i = 0; i < color.length; i++)
        color[i] = 'w';
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
}</code></pre>
</div>

<div style="display:inline-block; text-align:left">
<h4>DFS (modified, rewritten)</h4>
<pre style="font-size:10.6px"><code>// returns true if the graph is acyclic
boolean DFS() {
    for (int i = 0; i < color.length; i++)
        color[i] = 'w';
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

ASDASDA  
OOGA BOOGA ASDASD    
ASDASDASD  

<div style="display:inline-block; text-align:left">
<h4>DFS (original)</h4>
<pre style="font-size:10.7px"><code>void DFS() {
    for (int i = 0; i < color.length; i++)
        color[i] = 'w';
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

<div style="display:inline-block; text-align:left">
<h4>DFS (modified)</h4>
<pre style="font-size:10.7px"><code>// returns true if the graph is acyclic
<span style="background-color:orange">boolean</span> DFS() {
    for (int i = 0; i < color.length; i++)
        color[i] = 'w';
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
}</code></pre>
</div>

<div style="display:inline-block; text-align:left">
<h4>DFS (modified, rewritten)</h4>
<pre style="font-size:10.7px"><code>// returns true if the graph is acyclic
boolean DFS() {
    for (int i = 0; i < color.length; i++)
        color[i] = 'w';
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
