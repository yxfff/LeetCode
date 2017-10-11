package com.classes.one;

public class MergeTwoSortedList {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(8);
		ListNode e = new ListNode(9);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		ListNode A = new ListNode(2);
		ListNode B = new ListNode(4);
		ListNode C = new ListNode(6);
		ListNode D = new ListNode(7);
		ListNode E = new ListNode(10);
		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		
		ListNode res = new SolutionSeven().mergeTwoLists(a, A);
		while(res.next !=null){
			System.out.print(res.val+"-->");
			res = res.next;
		}
		System.out.print(res.val);
	}
}

class SolutionSeven {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		//定义一个空的临时头节点
		ListNode temp_head = new ListNode(0);
		//定义一个指针指向这个临时节点,用来往后添加节点
		ListNode pre = temp_head;
		
		while(l1 != null && l2 != null){//l1和l2不空时，进行比较
			if(l1.val < l2.val){
				pre.next = l1;
				l1 = l1.next;
			}else{
				pre.next = l2;
				l2 = l2.next;
			}
			pre=pre.next;
		}
		
		if(l1 != null){//如果l1有剩余，将l1接到pre后
			pre.next = l1;
		}else if(l2 != null){//如果l2有剩余，将l2接到pre后
			pre.next = l2;
		}
		return temp_head.next;
		
	}
}