<div class="row">
  <div class="col-md-8" markdown="1">
  Some text.
  </div>
  <div class="col-md-4" markdown="1">
  asdf
  </div>
</div>

<pre><code class="language-c">int foo (void) {
    int i;
}  
<span style="background-color:yellow">test</span>
</code></pre>

<pre><code>int foo (void) {
    int i;
}  
<span style="background-color:cyan">foo</span>
</code></pre>


# Rule 1123123
Description for rule 1.

<div style="column-count: 2; column-rule: 1px dotted #e0e0e0;">
    <div style="display: inline-block;" width="50%">
        <h2>Good</h2>
        <pre><code class="language-c">int foo (void) 
{
    int i;
}
</code></pre>
    </div>
    <div style="display: inline-block;">
        <h2>Bad</h2>
        <pre><code class="language-c">int foo (void) {
    int i;
}  
<span style="background-color:cyan">test</span>
</code></pre>
    </div>
</div>


# Rule 1
Description for rule 1.

<div style="-webkit-column-count: 2; -moz-column-count: 2; column-count: 2; -webkit-column-rule: 1px dotted #e0e0e0; -moz-column-rule: 1px dotted #e0e0e0; column-rule: 1px dotted #e0e0e0;">
    <div style="display: inline-block;">
        <h2>Good</h2>
        <pre><code class="language-c">int foo (void) 
{
    int i;
}
</code></pre>
    </div>
    <div style="display: inline-block;">
        <h2>Bad</h2>
        <pre><code class="language-c">int foo (void) {
    int i;
}  
<span style="background-color:cyan">test</span>
</code></pre>
    </div>
</div>

<details open>
   test1  
   test2
</details>

<details>
   	<summary>Arrays</summary>

#### Easy:

1. Contains Duplicate: https://leetcode.com/problems/contains-duplicate/
1. Missing Number: https://leetcode.com/problems/missing-number/
1. Find All Numbers Disappeared in an Array: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
1. Single Number: https://leetcode.com/problems/single-number/

#### Medium:

1. Product of Array Except Self: https://leetcode.com/problems/product-of-array-except-self/
1. Find the Duplicate Number: https://leetcode.com/problems/find-the-duplicate-number/
1. Find All Duplicates in an Array: https://leetcode.com/problems/find-all-duplicates-in-an-array/

#### Hard:

1. First Missing Positive: https://leetcode.com/problems/first-missing-positive/
1. Longest Consecutive Sequence: https://leetcode.com/problems/longest-consecutive-sequence/

</details>

| Unchecked | Checked |
| --------- | ------- |
| &#9744;   | &#9745; |

[:smile:](http://github.com)
[&#9745;](http://github.com)

<mark>Highlight test</mark>

<span style="color:blue">some *This is Blue italic.* text</span>
<br>
<span style="background-color:blue">some *This is Blue italic.* text</span>
<br>




<span style="color:cyan">`test`</span>
<span style="background-color:cyan">`test`</span>

<br>
`test``test`
<br>
`test``test`
<br>

```
test test
test test
```

<mark>`test1test2`</mark>
 
 
 `test`
 
 `<mark>test</mark>`
 <mark>`test`</mark>

LaTeX test
https://stackoverflow.com/questions/35498525/latex-rendering-in-readme-md-on-github
![equation](http://latex.codecogs.com/gif.latex?O_t%3D%5Ctext%20%7B%20Onset%20event%20at%20time%20bin%20%7D%20t)

<br><br>
- [ ] test1  
- [x] test2  


LC code test
<iframe src="https://leetcode.com/playground/rWuvY2hN/shared" frameBorder="0" width="400" height="300"></iframe>

<br><br>
* [ ] unchecked # [checkbox:unchecked]
* [x] checked   # [checkbox:checked]
* [X] checked   # [checkbox:checked]
* .
- [ ]          # [checkbox:unchecked]
- [-]          # '[-]'
- [o]          # '[o]'
- [O]          # '[O]'
- .
- \[ ]         # [checkbox:unchecked]
- /[ ]         # '/[ ]'
- \\[ ]        # '\[ ]'
- \[-]         # '\[-]' 
- \[o]         # `\[o]'
- \[x]         # [checkbox:checked]
- \[X]         # [checkbox:checked]
- .
- \\[ ]        # '\[ ]'
- \\[x]        # '\[x]'
- .
- [[ ]]        # ''
- [[x]]        # [link]
- [[o]]        # [link]
- .
- ][ ]         # '][ ]'
- ][x]         # '][x]'
- .
- ] [          #  '] ['
- ]x[          #  ']x['
- .
- .[ ]         #  '.[ ]'
- .[x]         #  '.[x]'
