class Solution {
    char[] color;
    List<Integer>[] adjlist;
    int[] answer;
    int index;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adjlist = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adjlist[i] = new ArrayList<>();
        
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adjlist[u].add(v);
        }

        color = new char[numCourses];
        for (int i = 0; i < color.length; i++) color[i] = 'w';
        
        index = 0;
        answer = new int[numCourses];
        for (int u = 0; u < numCourses; u++)
            if (color[u] == 'w' && visit(u))
                return new int[0];
        return answer;
    }

    private boolean visit(int u) {
        color[u] = 'g';
        for (int v : adjlist[u])
            if (color[v] == 'w' && visit(v) || color[v] == 'g')
                return true;
        color[u] = 'b';
        answer[index++] = u;
        return false;
    }
}
