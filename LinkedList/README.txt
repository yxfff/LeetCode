1.链表逆序
LeetCode 206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/description/

已知链表头节点指针head，将链表逆序（不可申请额外空间）

思路：
	依次遍历链表节点，每遍历一个节点即逆置一个节点
	代码为ReserveLinkedList_one.java
---------------------------------------------------------------------
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
----------------------------------------------------------------------
3.求两个链表的交点
LeetCode 160
已知链表A的头节点指针headA，链表B的头节点指针headB，两个链表相交，
求两个链表交点对应的节点

1.如果两个链表没有交点，则返回NULL
2.在求交点过程中，不可以破坏链表的结构或者修改链表的数据域
3.可以确保传入的链表A与链表B没有任何环
4.时间复杂度O(n),空间复杂度O(1)
https://leetcode.com/problems/intersection-of-two-linked-lists/description/


方法1：
思路：
 使用set集合
 遍历链表A，将A中节点对应的地址插入到set中
 遍历链表B，将B中节点对应的地址，在set中查找，发现在set中的第一个节点位置即
 两个链表的交点。   
方法2：
 计算headA的长度和headB的长度，较长的链表多出的长度
 将较长的链表指针移动到和较短的链表指针对齐的位置
 headA和headB同时移动，当两指针指向同一节点时即找到了。