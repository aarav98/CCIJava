//Approach
//1. Create a HashMap to track the unique elements in linked list
//2.Iterate through linkedlist 
//3. if element exist in hashmap the delete that node and move next
//4. else add that node to map and move next

Node removeDups(Node head){
    Node n = head;
    HashMap<Integer,boolean> map = new HashMap();
    
    while(n.next != null){
        if(map.get(n.val)){
            n = deleteNode(n);
        }else{
            map.put(n.val,true);
        }
        n = n.next;
    }
    return head;
}

//Use HashSet instead
//deleteNode is not necessary. Same functionality can be achieved by using an extra variable to track previous node

void deleteDups(LinkedListNode n){
    HashSet<Integer> set = new HashSet<Integer>();
    LinkedListNode previous = null;
    
    while(n!=null){
        if(set.contains(n.data)){
            previou.next = n.next;
        }else{
            set.add(n.data);
            previous = n;
        }
        n = n.next;
    }
}