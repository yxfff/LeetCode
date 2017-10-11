package com.classes.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomList {
	public static void main(String[] args) {
		
		RandomListNode a = new RandomListNode(5);
		RandomListNode b = new RandomListNode(3);
		RandomListNode c = new RandomListNode(6);
		
		a.next = b;
		b.next = c;
		a.random = c;
		b.random = a;
		c.random = c;
		
		//方法1测试
//		RandomListNode res = new SolutionSix().copyRandomList(a);
//		int i = 0;
//		RandomListNode old = a;
//		while(res != null && old != null){
//			System.out.println("复制前的链表--第 "+i+"个节点 label为："+old.label+" random的label为："+old.random.label);
//			System.out.println("复制后的链表--第 "+i+"个节点 label为："+res.label+" random的label为："+res.random.label);
//			res = res.next;
//			old = old.next;
//			i++;
//		}
		
		//方法2测试
		RandomListNode res_two = new SolutionSix().copyRandomList_two(a);
		int k = 0;
		RandomListNode temp = a;
		while(res_two != null && temp != null){
			System.out.println("复制前的链表--第 "+k+"个节点 label为："+temp.label+" random的label为："+temp.random.label);
			System.out.println("复制后的链表--第 "+k+"个节点 label为："+res_two.label+" random的label为："+res_two.random.label);
			res_two = res_two.next;
			temp = temp.next;
			k++;
		}
	}
}

class RandomListNode{
	int label;
	RandomListNode next,random;
	public RandomListNode(int x){
		label = x;
		next = null;
		random = null;
	}
}

class SolutionSix{
	
	//思路1：
	public RandomListNode copyRandomList(RandomListNode head){
		//设置一个map，key为节点地址，value为整型。存储原链表
		Map<RandomListNode,Integer> old_map = new HashMap<RandomListNode,Integer>();
		//List存储节点位置访问地址，下标即可代表位置，相当于新链表。不必使用map
		List<RandomListNode> node_list = new ArrayList<RandomListNode>();
		RandomListNode ptr = head;
		int i=0;
		//遍历原链表，将节点信息填入list和map中
		
		if(head == null){
			return null;
		}
		
		while(ptr != null){
			//新链表中加入节点
			node_list.add(new RandomListNode(ptr.label));
			//map中记录原链表
			old_map.put(ptr, i);
	        ptr = ptr.next;
	        //记录节点位置
	        i++; 
		}
		//回到起点
		ptr = head;
		i = 0;
		while(ptr != null){
			//将list中的节点连起来，组成链表
			if(ptr.next!=null){//防止list越界
				node_list.get(i).next = node_list.get(i+1);
			}
			//连接节点的同时，找到当前节点对应的random值
			if(ptr.random!=null){
				//得到原链表中的当前节点的random的所在位置
				int id = old_map.get(ptr.random);
				node_list.get(i).random = node_list.get(id);
			}
			ptr = ptr.next;
			i++;
		}
		//list的第一个节点即我们需要的新链表头节点
		return node_list.get(0);
	}
	
	//思路2
	public RandomListNode copyRandomList_two(RandomListNode head){
		if (head == null) return null;
		  
		  Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		  
		  // 复制所有节点
		  RandomListNode node = head;
		  while (node != null) {
		    map.put(node, new RandomListNode(node.label));
		    node = node.next;
		  }
		  
		  // 连接节点组成链表并指定random
		  node = head;
		  while (node != null) {
		    map.get(node).next = map.get(node.next);
		    map.get(node).random = map.get(node.random);
		    node = node.next;
		  }
		  
		  return map.get(head);
	}
}
