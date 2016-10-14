
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