package com.classes.one;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CrossoverList {
	public static void main(String[] args) {
		ListNode A = new ListNode(1);
		ListNode A1 = new ListNode(2);
		ListNode A2 = new ListNode(3);
		ListNode A3 = new ListNode(4);
		
		A.next = A1;
		A1.next = A2;
		A2.next = A3;
	
		ListNode B = new ListNode(5);
		ListNode B1 = new ListNode(2);
		
		B.next = B1;
		B1.next = A2;
		
		
		ListNode t = new SolutionThree().getIntersectionNode(A, B);
		System.out.println(t.val);
	}
}

class SolutionThree{
	//方法1：超时,暴力求解，时间复杂度高
	public ListNode getIntersectionNode(ListNode headA,ListNode headB){
		Set<ListNode> temp = new HashSet<ListNode>();
		while(headA!=null){
			temp.add(headA);
			headA = headA.next;
		}
		while(headB!=null){
			Iterator<ListNode> it = temp.iterator();
			while(it.hasNext()){
				if(it.next().val == headB.val){
					return headB;
				}
			}
			headB = headB.next;
		}
		return null;
	}
	
	//方法2：
	public int get_list_length(ListNode head){//计算链表长度
		int len = 0;
		while(head != null){
			len++;
			head = head.next;
		}
		return len;
	}
	
	public ListNode forward_long_list(int long_len, int short_len,ListNode head){//链表向前移动至多出节点个数后面的位置
		int delta = long_len - short_len;
		while(head!=null && delta>0){
			head = head.next;
			delta--;
		}
		return head;
	}
	
	public ListNode getIntersectionNode_two(ListNode headA,ListNode headB){
		int len_headA = get_list_length(headA);
		int len_headB = get_list_length(headB);
		
		if(len_headA > len_headB){
			headA = forward_long_list(len_headA,len_headB,headA);
		}else{
			headB = forward_long_list(len_headB,len_headA,headB);
		}
		
		while(headA!=null){
			if(headA.val == headB.val){
				return headA;
			}else{
				headA = headA.next;
				headB = headB.next;
			}
		}
		return null;
	}
	
	
	
}
