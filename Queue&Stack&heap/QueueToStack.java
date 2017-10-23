package com.classes.two;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
	public static void main(String[] args) {

	}
}

//思路1
class MyStack{
	private Queue<Integer> data_queue = new LinkedList<Integer>();
	/** Initialize your data structure here. */
	public MyStack() {

	}

	/** Push element x onto stack. */
	public void push(int x) {
		LinkedList<Integer> temp_queue = new LinkedList<Integer>();
		temp_queue.add(x);
		while(!data_queue.isEmpty()){
			temp_queue.add(data_queue.poll());
		}

		while(!temp_queue.isEmpty()){
			data_queue.add(temp_queue.poll());
		}
		
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return data_queue.poll();
	}

	/** Get the top element. */
	public int top() {
		return data_queue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return data_queue.isEmpty();
	}
}


//思路2：比较麻烦
class MyStack2{
	private Queue<Integer> data_queue = new LinkedList<Integer>();
	/** Initialize your data structure here. */
	public MyStack2() {

	}

	/** Push element x onto stack. */
	public void push(int x) {
		data_queue.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop(){
		LinkedList<Integer> temp_queue = new LinkedList<Integer>();
		int res = data_queue.peek();
		while(!data_queue.isEmpty()){
			res = data_queue.poll();
			if(!data_queue.isEmpty()){
				temp_queue.add(res);
			}else{
				while(!temp_queue.isEmpty()){
					data_queue.add(temp_queue.poll());
				}
				return res;
			}
		}
		return res;
		
	}

	/** Get the top element. */
	public int top() {
		LinkedList<Integer> temp_queue = new LinkedList<Integer>();
		int res = data_queue.peek();
		while(!data_queue.isEmpty()){
			res = data_queue.poll();
			temp_queue.add(res);
			if(data_queue.isEmpty()){
				while(!temp_queue.isEmpty()){
					data_queue.add(temp_queue.poll());
				}
				return res;
			}
		}
		return res;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return data_queue.isEmpty();
	}
}
