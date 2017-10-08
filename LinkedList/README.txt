1.链表逆序
LeetCode 206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/description/

已知链表头节点指针head，将链表逆序（不可申请额外空间）

思路：
	依次遍历链表节点，每遍历一个节点即逆置一个节点
	代码为ReserveLinkedList_one.java

2.链表逆序
LeetCode 92. Reverse LinkedList

已知链表头节点指针head，将链表从位置m到n逆序（不申请额外空间）
https://leetcode.com/problems/reverse-linked-list-ii/description/

思路:
1.与1类似，记录m-1和n+1节点
2.先存储m-1节点为pre_head,第m个为head
3.从head开始逆置change_len = n-m+1个节点
4.将pre_head和new_head连接，modify_list_tail与head连接
代码为ReserveLinkedList_two.java