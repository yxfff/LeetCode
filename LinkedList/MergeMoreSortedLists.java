package com.classes.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeMoreSortedLists {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(8);
		ListNode e = new ListNode(9);
		
		a.next = b;
		b.next = c;
	
		d.next = e;
		
		ListNode A = new ListNode(2);
		ListNode B = new ListNode(4);
		ListNode C = new ListNode(6);
		ListNode D = new ListNode(7);
		ListNode E = new ListNode(10);
		
		A.next = B;
		B.next = C;
		
		D.next = E;
		ListNode[] lists = new ListNode[]{a,d,A,D};
		
		ListNode res = new SolutionEight().mergeKLists_two(lists);
		while(res.next != null){
			System.out.print(res.val+"-->");
			res =res.next;
		}
		System.out.print(res.val);
		
		
	}
}


class SolutionEight {
	//方法2:超时
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> node_list = new ArrayList<ListNode>();
        int len = lists.length;
        int i = 0;
       
        //将所有节点添加到node_list中
        while(len > 0){
        	ListNode ptr = null;
        	if(lists[i] != null){
        		ptr = lists[i];
        	}
        	
        	while(ptr!=null){
        		node_list.add(ptr);
        		ptr = ptr.next;
        	}
        	i++;
        	len--;
        }
        if(node_list.size() == 0){
        	return null;
        }
        //对node_list中节点进行排序
        node_list.sort(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode l1, ListNode l2) {
				if(l1.val == l2.val){
					return 0;
				}
				return l1.val>l2.val?1:-1;
			}
        	
		});
        //连接node_list中的节点
        for(int k =0;k<node_list.size()-1;k++){
        	node_list.get(k).next = node_list.get(k+1);
        }
        return node_list.get(0);
    }
    
    //方法3：分治(使用递归)
    public ListNode mergeKLists_two(ListNode[] lists){
    	if(lists.length == 0){
    		return null;
    	}
    	if(lists.length == 1){
    		return lists[0];
    	}
    	if(lists.length == 2){
    		return mergeTwoLists(lists[0], lists[1]);
    	}
    	
    	int mid = lists.length/2;
    	List<ListNode> sub_list1 = new ArrayList<ListNode>();
    	List<ListNode> sub_list2 = new ArrayList<ListNode>();
    	
    	for(int i=0;i<mid;i++){
    		sub_list1.add(lists[i]);
    	}
    	for(int i=mid;i<lists.length;i++){
    		sub_list2.add(lists[i]);
    	}
    	
    	ListNode l1 = mergeKLists_two(arrayListToArray(sub_list1));
    	ListNode l2 = mergeKLists_two(arrayListToArray(sub_list2));
    	
    	return mergeTwoLists(l1, l2);

    }
    
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
    
    
    //ArrayList转换成数组的辅助方法
    public ListNode[] arrayListToArray(List<ListNode> list){
    	int len = list.size();
    	if(len == 0){
    		return null;
    	}
    	ListNode[] node_list = new ListNode[len];
    	for(int i=0;i<len;i++){
    		node_list[i] = list.get(i);
    	}
    	return node_list;
    }
}