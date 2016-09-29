LinkedListNode partition(LinkedListNode node, int n){
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;
    
    while(node != null){
        LinkedListNode next = node.next;
        node.next = null
        if(node.data < x){
            if(beforeStart == null){
                beforeStart = node;
                beforeEnd = node;
            }else{
                beforeStart.next = node;
                beforeEnd = node;
            }
        }else{
            if(afterStart == null){
                afterStart = node;
                afterEnd = node;
            }else{
                afterStart.next = node;
                afterEnd = node;
            }
        }
        node = next;
    }
    
    if(beforeStart == null){
        return afterStart;
    }
    beforeEnd.next = afterStart;
    return beforeStart;
}