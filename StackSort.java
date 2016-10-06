Stack<Integer> sort(Stack<Integer> s){
    Stack<Integer> r = new Stack<Integer>();
    
    while(!s.isEmpty()){
        int temp = s.pop();
        while(!r.isEmpty() && r.peek()>temp){
            s.push(r.pop());
        }
        r.push(temp);
    }
}