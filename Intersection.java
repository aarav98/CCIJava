LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2){
    if(list1 == null || list2 == null) retur null;
    
    Result result1 = getTailAndSize(list1);
    Result result2 = getTailAndSize(list2);
    
    if(result1.tail != result2.tail) return false;
    
    LinkedListNode shorter = result1.size < result2.size?list1:list2;
    LinkedListNode longer = result1.size < result2.size?list2:list1;
    
    longer = getKthNode(longer,Math.abs(result2.size-result1.size));
    
    while(longer!=shorter){
        longer = longer.next;
        shorter = shorter.next;
    }
    
    return longer; // Could also return shorter
}

class Result{
    public LinkedListNode tail;
    public int size;
    public Result(LinkedListNode tail, int size){
        this.tail = tail;
        this.size = size;
    }
}

Result getTailAndSize(LinkedListNode list){
    if(list == null) return null;
    int size =1;
    LinkedListNide curr = list;
    while(curr.next != null){
        size++;
        curr=curr.next;
    }
    
    return Result(curr,size);
}

LinkedListNode getKthNode(LinkedListNode head, int k){
    LinkedListNode curr = head;
    for(int i= 0; i<k; i++){
        curr = curr.next;
    }
    return curr;
}