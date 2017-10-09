package com.classes.one;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CycleLinkedList {
	public static void main(String[] args) {
		ListNode A = new ListNode(1);
		ListNode A1 = new ListNode(2);
		ListNode A2 = new ListNode(3);
		ListNode A3 = new ListNode(4);
		ListNode A4 = new ListNode(5);
		
		A.next = A1;
		A1.next = A2;
		A2.next = A3;
		A3.next = A4;
		A4.next = A2;
		
		ListNode res = new SolutionFour().detectCycleTwo(A);
		System.out.println(res.val);
	}
}

class SolutionFour{
	//方法1：超时
	public ListNode detectCycle(ListNode head){
		Set<ListNode> set = new HashSet<ListNode>();
		while(head!=null){
			Iterator<ListNode> it = set.iterator();
			while(it.hasNext()){
				if(it.next().val== head.val){
					return head;
				}
			}
			head = head.next;
		}
		
		return null;
	}
	
	//方法2：快慢指针赛跑
	public ListNode detectCycleTwo(ListNode head){
		ListNode fast = head;//快指针
		ListNode slow = head;//慢指针
		ListNode meet = null;//相遇节点
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow){
				meet = fast;
				break;
			}
		}
		
		while(head != null && meet != null){
			if(head == meet){
				return head;
			}else{
				head = head.next;
				meet = meet.next;
			}
		}
		return null;
	}
}
