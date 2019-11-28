<!-- MathJax -->
<script src="https://polyfill.io/v3/polyfill.min.js?features=es6"></script>
<script id="MathJax-script" async src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>

<!-- Google Prettify -->
<script src="https://cdn.jsdelivr.net/gh/google/code-prettify@master/loader/run_prettify.js"></script>

<!------------------------------------------------------------------------------------------------------------------------------------->

# Course Schedule II

Observation: this problem is equivalent to finding a reverse topological sort of the course prerequisite graph (if it exists). A valid course order will exist if the course prerequisite graph is acyclic.

<!------------------------------------------------------------------------------------------------------------------------------------->

## Approach 1: Modify DFS to Find a Reverse Topological Sort ⭐⭐
Our algorithm consists of two parts:
1. Store the graph as an [adjacency list](){:target="_blank"} (each prerequisite pair is a directed edge). This will improve runtime.
2. Use a modified version of [DFS](){:target="_blank"} to find a reverse [topological sort](){:target="_blank"} of the graph if it is acyclic.

In [Approach 1 for Course Schedule](../0207_Course-Schedule/Explanation.md){:target="_blank"}, we saw how to modify DFS to determine if a graph is acyclic. Using this as a starting point, we only need to make a minor change to our code to store the reverse topological sort in our answer array: simply append vertices to the  answer array as they finish during DFS. I have highlighted these changes below:

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
<pre style="background-color:beige"><code class="prettyprint" style="font-weight:bold">class Solution {
    char[] color;
    List<Integer>[] adjlist;
    int[] answer;
    int index;
</code></pre>

### Complexity Analysis

<details><summary><b>Time: \(O(N)\)</b></summary><div style="margin-left:1rem"><p>
The <a href="" target="_blank">runtime of DFS</a> is \(O(|V|+|E|)\). In this case, the number of vertices (numCourses) is at most \(2N\) (the worst case happens when every prerequisite pair contains two unique courses) and the number of edges (number of prerequisites) is \(N\). Therefore, the total runtime is \(O(2N+N)=O(N)\).
</p></div></details>

<details><summary><b>Space: \(O(N)\)</b></summary><div style="margin-left:1rem"><p>
The <a href="" target="_blank">space required by an adjacency list</a> is \(O(|V|+|E|)\). As stated above, the number of vertices is at most \(2N\) and the number of edges is \(N\). In addition, the color and answer arrays have length \(N\) and recursive calls take \(O(N)\) stack frames. Therefore, the total space required is \(O(N)\).
</p></div></details>

<!------------------------------------------------------------------------------------------------------------------------------------->
