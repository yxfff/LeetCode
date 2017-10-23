package com.classes.two;

import java.util.Stack;

public class StackToQueue {
	public static void main(String[] args) {

	}
}

//˼·1
class MyQueue{
	private Stack<Integer> data_stack = new Stack<Integer>();
	/** Initialize your data structure here. */
	public MyQueue() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		Stack<Integer> temp_stack = new Stack<Integer>();
		while(!data_stack.empty()){
			temp_stack.push(data_stack.pop());
		}
		temp_stack.push(x);
		while(!temp_stack.empty()){
			data_stack.push(temp_stack.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return data_stack.pop();
	}

	/** Get the front element. */
	public int peek() {
		return  data_stack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return data_stack.empty();
	}
}


//˼·2
class MyQueue2{
	private Stack<Integer> data_stack = new Stack<Integer>();
	/** Initialize your data structure here. */
	public MyQueue2() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		data_stack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		Stack<Integer> temp_stack = new Stack<Integer>();
		while(!data_stack.empty()){
			temp_stack.push(data_stack.pop());
		}
		int res = temp_stack.pop();
		while(!temp_stack.empty()){
			data_stack.push(temp_stack.pop());
		}
		return res;
	}

	/** Get the front element. */
	public int peek() {
		Stack<Integer> temp_stack = new Stack<Integer>();
		while(!data_stack.empty()){
			temp_stack.push(data_stack.pop());
		}
		int res = temp_stack.peek();
		while(!temp_stack.empty()){
			data_stack.push(temp_stack.pop());
		}
		return res;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return data_stack.empty();
	}
}
