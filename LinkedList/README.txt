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
LeetCode 160 Intersection of Two Linked Lists
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
 
 代码为：CrossoverList.java
----------------------------------------------------------------------------
4.链表求环
LeetCode 141 Linked List Cycle
LeetCode 142 Linked List Cycle2
https://leetcode.com/problems/linked-list-cycle-ii/description/

已知链表中可能存在环，若有环返回环起始节点，否则返回null

方法1：
  1.遍历链表，将链表中节点对应的指针，插入set
  2.在遍历时插入节点前，需要在set中查找，第一个在set中发现的节点地址，即链表环的起点
方法2：
  定义两个指针slow和fast
  slow每次移动1个节点，fast每次移动2个节点
  如果存在环，则向前走的某一刻fast和slow一定会相遇，但相遇的点不一定是环的起点。

  设：1->2->3->4->5->6->7->3....
      3为环的起始点
   当fast和slow相遇时，
   slow:2,3,4,5,6
   fast:2,3,4,5,6,7,3,4,5,6
   
   定义2->3段为a，4->5->6段为b,7->3段为c
   slow=a+b
   fast=a+b+c+b
   因为fast速度为slow两倍
   2*(a+b)=a+b+c+b ----> a=c
   
   结论：从head和meet出发，两指针速度相同，相遇时即为环的起点。

代码为：CycleLinkedList.java

-------------------------------------------------------------------------------
5. 链表划分
LeetCode86 Partition List
https://leetcode.com/problems/partition-list/description/

已知链表头指针head与数值x，将所有小于x的节点放在大于或等于x的节点前，且保持这些节点的原来的相对位置。

思路：
  用临时头节点
  设置两个临时节点，less_head和more_head
  定义less_ptr指向less_head
  定义more_ptr指向more_head

  遍历链表head
  比x小的节点放在less_ptr后面
  比x大的节点放在less_ptr后面

  连接less_ptr.next与more_head.next
  
  more_ptr.next置空
  
  返回less_head.next
 
代码为：PartitionList.java

-------------------------------------------------------------------------------
6.复杂链表的深度拷贝
LeetCode 138 Copy List with Random Pointer
https://leetcode.com/problems/copy-list-with-random-pointer/description/

已知一个复杂链表，节点中有一个指向本链表的任意某个节点的随机指针（也可以为空），
求这个链表的深度拷贝（即修改原链表不会影响拷贝后链表，修改拷贝后的链表不会影响原链表）

思路1：
  使用map和list

  原链表：
  用map存储地址和节点所在位置
  示例：
  0x111->0  random 0x123指向2号节点
  0x100->1  random 0x333指向3号节点
  0x123->2  random 0x123 指向2号节点
  0x333->3  random NULL 指向 NULL
  0x500->4  random 0x333 指向3号节点

  新链表：
  用List存储节点所在位置和节点地址（因为节点位置即list的index，所以可以不用map）
  0->0x200 random 2号节点地址(0x202)
  1->0x201 random 3号节点地址(0x210)
  2->0x202 random 2号节点地址(0x202)
  3->0x210 random NULL
  4->0x211 random 3号节点地址(0x210)
思路2（推荐）：
  使用1个map,同时存储新链表和旧链表，省略节点位置的定义
  HashMap<RandomListNode,RandomListNode>

代码为：RandomList.java

  