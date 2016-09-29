LinkedListNode nthToLast(LinkedListNode head, int k){
    LinkedListNode p1 = head;
    LinkedListNode p2 = head;
    for(int i = 0; i<k; i++){
        if(p2 == null) return null;
        p2 = p2.next;
    }
    while(p2 != null){
        p1 = p1.next;
        p2 = p2.next;
    }
    return p1;
}