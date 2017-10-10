package com.classes.one;


/***
 * 
 * LeetCode 86 Partition List
 * https://leetcode.com/problems/partition-list/description/
 */
public class PartitionList {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(3);
		ListNode f = new ListNode(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		ListNode res = new SolutionFive().partition(a, 3);
		
		while(res.next!=null){
			System.out.print(res.val+ "-->");
			res = res.next;
		}
		System.out.print(res.val);
		
		
	}
}

class SolutionFive{
	public ListNode partition(ListNode head,int x){
		ListNode less_head = new ListNode(0);
		ListNode more_head = new ListNode(1);
		ListNode less_ptr = less_head;
		ListNode more_ptr = more_head;
		
		while(head != null){
			if(head.val < x){
				less_ptr.next = head;
				less_ptr = head;
			}else{
				more_ptr.next = head;
				more_ptr = head;
			}
			
			head = head.next;
		}
		
		less_ptr.next = more_head.next;
		more_ptr.next = null;
		return less_head.next;
	}
}
