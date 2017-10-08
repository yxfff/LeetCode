package com.classes.one;

public class ReserveLinkedList_two {
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
		
		SolutionTwo s = new SolutionTwo();
		ListNode head = s.resverseBetween(a,2,3);
		
		while(head.next != null){
			System.out.print(head.val+"->");
			head=head.next;
		}
		
		System.out.print(head.val);
	}
}

class SolutionTwo{
	
	
	public ListNode resverseBetween(ListNode head,int m,int n){
		int change_len = n-m+1;//记录需要逆置的节点长度
		ListNode pre_head = null;//初始化开始逆置的节点的前驱
		ListNode result = head;//最终转换后的链表头节点，非特殊情况即为head
		while(head != null && --m > 0){
			pre_head = head; //记录head的前驱
			head = head.next;
		} 
		//将modify_list_tail指向当前的head，即转置后的链表尾
		ListNode modify_list_tail = head;
		ListNode new_head = null;
		
		while(head!=null&&change_len>0){
			ListNode next = head.next;
			head.next = new_head;
			new_head = head;
			head = next;
			change_len--; //每完成一个节点逆置，change_len--;
		}
		
		modify_list_tail.next = head; //连接逆置后的链表尾与逆置段的后一个节点
		//如果pre_head不空，说明不是从第一个节点开始逆置的m>1
		if(pre_head != null){
			pre_head.next = new_head; //将逆置链表开始的节点前驱与逆置后的头节点连接
		}else{
			result = new_head; //如果pre_head为空，说明m=1从第一个节点开始逆置。结果即逆置后的头节点.
		}
		
		return result;
	}
}