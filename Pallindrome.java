//Approach 1
//Reverse and Compare
//Reverse the list and compare the first half to original list

class HeadAndTail{
    LinkedListNode head;
    LinkedListNode tail;
    
    public HeadAndTail(LinkedListNode h, LinkedListNode t){
        head = h;
        tail = t;
    }
}

boolean isPallindrome(LinkedListNode head){
    HeadAndTail reversed = reverse(head); // reverses the linked list and return HeadAndTail obj
    LinkedListNode reversedHead = reversed.head; // this assigns pointer to head member of HeadAndTail obj
    return isEqual(head,reversedHead);
}


//??Study this function: How does it work???
HeadAndTail reversed(LinkedListNode head){
    if(head == null){
        return null;  // check if null: return null
    }                                       //1->2|| head 1 
    HeadAndTail ht = reversed(head.next); //recursively call on head.next node|| reversed(2)
    LinkedListNode clonedHead = head.clone();//clone the current node|| cloned head 1
    
    if(ht == null){
        return new HeadAndTail(clonedHead,clonedHead); // base case: if null the return a new node with head and tail set to that node
    }
    
    ht.tail.next = clonedHead; //2
    return new HeadAndTail(ht.head, clonedHead);
}


//Below function is easy 
//takes in two linked list node and checks if the data values for each node is equal
// at the end it returns in such way that both the lists are completely iterated ..

boolean isEqual(LinkedListNode one, LinkedListNode two){
    LinkedListNode head1 = one;
    LinkedListNode head2 = two;
    
    while(head != null && head2 != null){
        if(head1.data != head2.data){
            return false;
        }
        head1 = head1.next;
        head2 = head2.next;
    }
    
    return head1 == null && head2 == null; // this checks that the both lists have no member left unvisited ie, one list is not longer than the other
}

//////////////////////Approach 2/////////////////
////////////////////Iterative approach //////////
//Use stack 
// add values of first half nodes on stack and compare those values with rest of the list

boolean isPallindrome(LinkedListNode head){
    LinkedListNode fast = head;
    LinkedListNode slow = head;
    
    while(fast != null || fast.next != null){    //This loop and the loop below can be combined
        fast = fast.next.next;                   //Just push the data of each node through slow node during first pass and the second loop won't be needed
        slow = slow.next;    
    }    
    Stack<Integer> stack = new Stack<Integer>();    
    LinkedListNode fast = head;    
    while(fast != slow){    
        stack.push(fast.data);    
        fast = fast.next;
    }
    if (fast != null) slow = slow.next;
    
    while(slow != null){
        if(slow.data != stack.pop()) return false;
        slow = slow.next;
    }
    
    return stack.isEmpty();
}



