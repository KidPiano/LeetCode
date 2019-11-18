class Solution {   
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String string_s = serialize(s, new StringBuilder()).toString();
        String string_t = serialize(t, new StringBuilder()).toString();
        return string_s.indexOf(string_t) >= 0;
    }
    
    private StringBuilder serialize(TreeNode node, StringBuilder sb) {
        if (node == null) return sb.append("#N");
        sb.append("#").append(node.val);
        serialize(node.left, sb);
        return serialize(node.right, sb);
    }
}
