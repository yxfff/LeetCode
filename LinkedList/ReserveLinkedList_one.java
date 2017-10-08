package com.classes.one;


class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){this.val = val;}
}

class Solution{
	public ListNode reserveListNode(ListNode head){
		ListNode newHead = null;
		ListNode curr = head;
		ListNode temp = null;
		while(curr!=null){
			temp = curr.next;
			curr.next = newHead;
			newHead=curr;
			curr = temp;
		}
		return newHead;
	}
}

public class ReserveLinkedList_one {
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(5);
		
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		e.next=f;
		f.next=null;
		
		SolutionOne s = new SolutionOne();
		ListNode head = s.reserveList(a);
		
		while(head.next != null){
			System.out.print(head.val+"->");
			head=head.next;
		}
		
		System.out.print(head.val);
	}
}
