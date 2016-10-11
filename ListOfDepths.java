// Using DFS
// we need to know what level we are on
// we can achieve this by passing the level while doing preorder traversal
void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
    if(root == null) return;//base case
    
    LinkedList<TreeNode> list = null;
    if(lists.size() == level){ // level not contained in the list
        list = new LinkedList<TreeNode>();
        lists.add(list);
    }else{
        list = lists.get(level);
    }
    
    list.add(root);
    createLevelLinkedList(root.left, lists, level+1);
    createLevelLinkedList(root.right, lists, level+1);
}

ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
    ArrayList<LisnkedList<TreeNode>> lists = new ArrayList<ListLinked<TreeNode>>();
    createLevelLinkedList(root, lists, 0);
    return lists;
}

// BFS

ArrayList<LinkedList<TreeNode>> createLevelLinked(TreeNode root){
    ArrayList<LinkedList<TreeNode>> result  = new ArrayList<LinkedList<TreeNode>>();
    
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    if(root != null){
        current.add(root);
    }
    while (current.size()>0){
        result.add(current);//add prev level
        LinkedList<TreeNode> parents = current;
        current = new LinkedList<TreeNode>();
        for(TreeNode parent : parents){
            if(parent.left!=null)current.add(parent.left);
            if (parent.right!=null)current.add(parent.right)
        }
    }
    return result;
}