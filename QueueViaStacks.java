public class MyQueue{
    Stack<T> stackNewest, StackOldest;
    
    public MyQueue(){
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }
    
    public int size(){
        stackNewest.size() + stackOldest.size();
    }
    
    public void add(T value){
        stackNewest.push(value);
    }
    
    private void shiftStack(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }
    
    public T peek(){
        shiftStack();
        return stackOldest.peek();
    }
    
    public T pop(){
        shiftStack();
        return stackOldest.pop();
    }
}