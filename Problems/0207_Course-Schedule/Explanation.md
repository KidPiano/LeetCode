# Course Schedule

<!------------------------------------------------------------------------------------------------------------------------------------->

<!-- MathJax -->
<script src="https://polyfill.io/v3/polyfill.min.js?features=es6"></script>
<script id="MathJax-script" async src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>

<!-- Google Prettify -->
<script src="https://cdn.jsdelivr.net/gh/google/code-prettify@master/loader/run_prettify.js"></script>

<!------------------------------------------------------------------------------------------------------------------------------------->

Observation: it is possible to finish all courses if and only if the course prerequisite graph does not contain a cycle.  
In other words, this problem is equivalent to determining whether or not the course prerequisite graph is acyclic.

<!------------------------------------------------------------------------------------------------------------------------------------->

## Approach 1: Modify DFS to Detect Back Edges ⭐⭐

Our algorithm consists of two parts:
1. Store the graph as an [adjacency list](){:target="_blank"} (each prerequisite pair is a directed edge). This will improve runtime.
2. Use a modified version of [DFS](https://kidpiano.github.io/Algorithms/Graph/DFS.html){:target="_blank"} to determine if the graph is acyclic.
  - If we encounter a gray vertex during DFS, we have found a back edge and the graph contains a cycle (return false)
  - If we do not encounter any gray vertices during DFS, the graph has no cycles (return true)

Below, I have highlighted the changes we need to make to DFS to determine if a graph is acyclic:

<div style="display:inline-block">
<h4 style="margin-top:0">DFS (original)</h4>
<pre style="font-size:0.65rem; background-color:whitesmoke"><code class="prettyprint" style="font-weight:bold">void DFS() {
    for (int u = 0; u < numVertices; u++)
        if (color[u] == WHITE)
            visit(u);
}

void visit(int u) {
    color[u] = GRAY;
    for (int v : adjlist[u])
        if (color[v] == WHITE)
            visit(v);
    color[u] = BLACK;
}







</code></pre>
</div>

<div style="display:inline-block">
<h4 style="margin-top:0">DFS (acyclic)</h4>
<pre style="font-size:0.65rem; background-color:whitesmoke"><code class="prettyprint" style="font-weight:bold">// returns true if the graph is acyclic
<span style="background-color:orange">boolean</span> DFS() {
    for (int u = 0; u < numVertices; u++)
        if (color[u] == WHITE)
            <span style="background-color:orange">if (visit(u)) return false;</span>
    <span style="background-color:orange">return true;</span>
}

// returns true if a cycle is found
<span style="background-color:orange">boolean</span> visit(int u) {
    color[u] = GRAY;
    for (int v : adjlist[u])
        if (color[v] == WHITE) {
            <span style="background-color:orange">if (visit(v)) return true;</span> }
        // found back edge
        <span style="background-color:orange">else if (color[v] == GRAY) return true;</span>
    color[u] = BLACK;
    <span style="background-color:orange">return false;</span>
}

</code></pre>
</div>

<div style="display:inline-block">
<h4 style="margin-top:0">DFS (acyclic) refactored</h4>
<pre style="font-size:0.65rem; background-color:whitesmoke"><code class="prettyprint" style="font-weight:bold">// returns true if the graph is acyclic
boolean DFS() {
    for (int u = 0; u < numVertices; u++)
        <mark>if (color[u] == WHITE && visit(u))</mark>
            <mark>return false;</mark>
    return true;
}

// returns true if a cycle is found
boolean visit(int u) {
    color[u] = GRAY;
    for (int v : adjlist[u])
        <mark>if (color[v] == WHITE && visit(v) || color[v] == GRAY)</mark>
            <mark>return true;</mark>
    color[u] = BLACK;
    return false;
}



</code></pre>
</div>

Here is the full commented solution:
<iframe src="https://leetcode.com/playground/gUYtNtWX/shared" frameBorder="0" width="100%" height="730"></iframe>

### Complexity Analysis

<details><summary><b>
Time: \(O(N)\)
</b></summary><div style="margin-left:1rem"><p>
The <a href="" target="_blank">running time of DFS</a> is \(O(|V|+|E|)\). In this case, the number of vertices (numCourses) is at most \(2N\) (the worst case happens when every prerequisite pair contains two unique courses) and the number of edges (number of prerequisites) is \(N\). Therefore, the total running time is \(O(N)\).
</p></div></details>

<details><summary><b>
Space: \(O(N)\)
</b></summary><div style="margin-left:1rem"><p>
The <a href="" target="_blank">space required by an adjacency list</a> is \(O(|V|+|E|)\). As stated above, the number of vertices is at most \(2N\) and the number of edges is \(N\). In addition, the color array has length \(N\) and recursive calls take \(O(N)\) stack frames. Therefore, the total space required is \(O(N)\).
</p></div></details>

<!------------------------------------------------------------------------------------------------------------------------------------->
