class FixedMultiStack{
    private int numberOfStacks = 3;             //number of stacks
    private int stackCapacity;                  //stack capacity of individual stack
    private int[] values;                       //values stored in underlying data structure here
    private int[] sizes;                        //to track sizes of 3 stacks
    
    public FixedMultiStack(int stackSize){
        stackCapacity = stackSize;              //Individual stack capacity or size
        values = new int[stackSize * numberOfStacks];   //array of size 3*stackCapacity
        sizes = new int[numberOfStacks];        //array of 3 that will store the current sizes of 3 stacks
    }
    
    //push value value onto stack
    public void push(int stackNum, int value) throws FullStackException{
        //check that we have space for next element
        if(isFull(stackNum)){
            throw new FullStackException();
        }
        //Increment stack pointer and update the top value
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }
    
    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }
    
    public int peek(int stackNum) throws EmptyStackException{
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }
    
    public boolean isEmpty(stackNum){
        return sizes[stackNum] == 0;
    }
    
    public boolean isFull(){
        return sizes[stackNum] == stackCapacity;
    }
    
    private int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size -1;
    }
    
}

