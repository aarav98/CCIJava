
TreeNode commonAncestor(TreeNode p, TreeNode q){
    if (p == q) return null;
    
    TreeNode ancestor = p;
    while(ancestor != null){
        if(isOnPath(ancestor, q)){
            return ancestor;
        }
        ancestor = ancestor.parent;
    }
    return null;
}

boolean isOnPath(TreeNode ancestor, TreeNode node){
    while(node!= ancestor && node!=null){
        node = node.parent;
    }
    return node == ancestor;
}


////sol 2

TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
    if(!covers(root, p) || !covers(root, q)) return null;
    else if(covers(p,q)) return p;
    else if(covers(q,p)) return q;
    
    TreeNode sibling = getSibling(p);
    TreeNode parent = p.parent;
    while(!covers(sibling, q)){
        sibling  = getSibling(parent);
        parent = parent.parent;
    }
    return parent;
}

boolean covers(TreeNode root, TreeNode p){
    if(root == null)return false;
    if(root == p)return true;
    return covers(root.left,p) || covers(root.right,p);
}

TreeNode getSibling(TreeNode node){
    if(node == null || node.parent == null) return null;
    TreeNode parent = node.parent;
    return parent.left==node?rparent.right:parent.left;
}