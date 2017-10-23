package com.classes.two;

import java.util.Stack;

public class MinStackBuild {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();   //--> Returns -3.
		minStack.pop();
		minStack.top();      //--> Returns 0.
		minStack.getMin();   //--> Returns -2.

	}
}

class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> min_stack = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
    	stack.push(x);
    	if(min_stack.isEmpty()){
    		min_stack.push(x);
    	}else{
    		if(x > min_stack.peek()){
    			x = min_stack.peek();
    		}
    		min_stack.push(x);
    	}
    }
    
    public void pop() {
        stack.pop();
        min_stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}