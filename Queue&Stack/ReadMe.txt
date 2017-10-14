1.使用队列实现栈
LeetCode 225 Implement Stack using Queues
https://leetcode.com/problems/implement-stack-using-queues/description/

思路1：
    关键在于pop和push方法
    维护一个data_queue队列对象，
    在push(x)时，创建一个临时队列temp_queue,
    将x push到temp_queue中
    再将data_queue所有元素pop到temp_queue中
    再将temp_queue中所有元素放回到data_queue中

    pop方法同queue的poll方法
思路2：
    维护一个data_queue队列对象
    push方法同queue的add方法
   
    pop时，创建一个临时队列，当data_queue不等于空时，记录poll值为res，
    如果没有到达队尾元素即（poll之后data_queue依然不为空）
    就将res添加到temp_queue中。
    如果到达了队尾元素，将temp_queue中的元素放回到data_queue中，并返回res。

    
    top时，当data_queue不为空，弹出队列头部元素记录为res。
    将res添加到temp_queue中，
    如果此时到达了队尾（即data_queue.isEmpty()==true），将temp_queue中元素放回到data_queue中
    返回res；
代码为QueueToStack.java
-------------------------------------------------------------------------------------

2.使用栈实现队列
LeetCode 232 Implement Queue using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/description/

思路1：
  关键在于pop和push两个方法
  维护一个data_stack栈用来存储元素
  在push(x)的时候，使用一个临时栈temp_stack, 先将x push到temp_stack中先将原有数据一一push到临时栈temp_stack中
  再将xpush到temp_stack中
  再将temp_stack中元素全部放回data_stack中，这样最新push的x就放入了栈底

  pop方法同栈的pop方法

思路2：
  维护一个data_stack栈来存储元素
  push(x)方法同栈的push(x)方法

  在pop时，创建一个临时栈temp_stack,将data_stack中的所有元素push到temp_stack中
  temp_stack.pop()即为需要的值，然后将temp_stack中元素放回data_stack中

  peek方法与pop方法思路类似

代码为：StackToQueue.java
------------------------------------------------------------------------------------
3.包含min函数的栈
LeetCode 155 Min Stack
https://leetcode.com/problems/min-stack/description/

设计一个栈，支持如下操作，这些操作的算法复杂度是常数级，O(1)时间复杂度
1）push(x)将元素x压入栈中
2）pop弹出栈顶元素
3）top返回栈顶元素
4）返回栈内最小元素

思路：
  想要以O(1)的时间复杂度得到栈内最小元素
  则需要在每一次操作时记录最小值
  考虑到pop操作，则可以维护一个栈来存储最小值，每次getMin()时返回栈顶元素

代码为MinStackBuild.java

-------------------------------------------------------------------------------
4.合法出栈序列
已知从1到n的数字序列，按顺序入栈，每个数字入栈后即可出栈，也可在栈中停留，等待后面的数字
入栈出栈后，该数字再出栈，求该数字序列的出栈序列是否合法

 poj 1363 Rails
http://poj.org/problem?id=1363

思路：
1）构建一个队列order，存储出栈结果
2）按元素顺序，将元素push进入栈
3）每push一个元素，即检查是否与队列首部元素相同，若相同则弹出队首元素，弹出栈顶元素
直到两元素不同结束
4）若最终栈为空，说明序列合法，否则不合法

代码为：RightOutOrder.java
