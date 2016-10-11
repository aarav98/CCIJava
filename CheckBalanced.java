int getHeight(TreeNode root){
    if(root == null) return 0;
    return Math.max(getHeight(root.left),getHeigth(root.right))+1;
}

boolean isBalanced(TreeNode root){
    if(root==null) return true;
    int heightDiff = getHeight(root.left)-getHeight(root.right);
    if(Math.abs(heightDiff)>1) return false;
    else isBalanced(root.left) && isBalanced(root.right);
}

//better approach

int checkHeight(TreeNode root){
    if(root == null) return 0;
    
    int leftHeight =checkHeight(root.left);
    if (leftHeight == -1) return -1;
    
    int rightHeight = checkHeight(root.right);
    if (rightHeight == -1) return -1;
    
    if(Math.abs(leftHeight-rightHeight)>1) return -1;
    else return Math.max(leftHeight,rightHeight)+1;
}

boolean isBalanced(TreeNode root){
    if(checkHeight(root) == -1) return false;
    return  true;
}