<!-- MathJax -->
<script src="https://polyfill.io/v3/polyfill.min.js?features=es6"></script>
<script id="MathJax-script" async src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>

<!-- Google Prettify -->
<script src="https://cdn.jsdelivr.net/gh/google/code-prettify@master/loader/run_prettify.js"></script>

<!------------------------------------------------------------------------------------------------------------------------------------->

# Course Schedule II 

Observation: this problem is equivalent to finding a reverse topological sort of the course prerequisite graph (if it exists). A valid course order will exist if the course prerequisite graph is acyclic.

<!------------------------------------------------------------------------------------------------------------------------------------->

## Approach 1: Modify DFS to Find a Reverse Topological Sort 🌟
Our algorithm consists of two parts:
1. Store the graph as an [adjacency list]() (each prerequisite pair is a directed edge). This will improve runtime.
2. Use a modified version of [DFS]() to find a reverse [topological sort]() of the graph if it is acyclic.

In [Approach 1 for Course Schedule](../0207_Course-Schedule/Explanation.md), we saw how to modify DFS to determine if a graph is acyclic. Using this as a starting point, we only need to make a minor change to our code to store the reverse topological sort in our answer array: simply append vertices to the  answer array as they finish during DFS. I have highlighted these changes below:

<div style="display:inline-block">
<h4 style="margin-top:0">Modified DFS (determines if a graph is acyclic)</h4>
<pre style="background-color:whitesmoke"><code class="prettyprint" style="font-weight:bold">// returns true if the graph is acyclic
boolean DFS() {
    for (int u = 0; u < numVertices; u++)
        if (color[u] == 'w' && visit(u))
            return false;
    return true;
}

// returns true if a cycle is found
boolean visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        if (color[v] == 'w' && visit(v) || color[v] == 'g')
            return true;
    color[u] = 'b';
    return false;
}



</code></pre>
</div>

<div style="display:inline-block">
<h4 style="margin-top:0">Modified DFS (returns a reverse topological sort)</h4>
<pre style="background-color:whitesmoke"><code class="prettyprint" style="font-weight:bold">// returns a reverse topological sort
<mark>int[]</mark> DFS() {
    for (int u = 0; u < numVertices; u++)
        if (color[u] == 'w' && visit(u))
            <mark>return new int[0];</mark>
    <mark>return answer;</mark>
}

// returns true if a cycle is found
boolean visit(int u) {
    color[u] = 'g';
    for (int v : adjlist[u])
        if (color[v] == 'w' && visit(v) || color[v] == 'g')
            return true;
    color[u] = 'b';
    // as vertices finish, store them in the answer array
    <mark>answer[index++] = u;</mark>
    return false;
}
</code></pre>
</div>

Here is the full commented solution:
<iframe src="https://leetcode.com/playground/W8tuhxVr/shared" frameBorder="0" width="100%" height="835"></iframe>

#### Complexity Analysis
- <div><b>Time:</b>\(O(N)\)</div>
- <div><b>Space:</b>\(O(N)\)</div>

<!------------------------------------------------------------------------------------------------------------------------------------->
