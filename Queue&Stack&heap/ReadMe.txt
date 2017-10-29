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

延伸：统计所有可能得出栈序列，卡特兰数（待做）

-----------------------------------------------------------------------------
5.计算器
LeetCode 224 Basic Calculator
https://leetcode.com/problems/basic-calculator/description/

设计一个计算器，输入一个字符串存储的表达式，可以计算包括（，），+，-
四种符号的数学表达式，输入的数学表达式字符串保证是否合法的。输入的数学的表达式中
可能存在空格字符。

思路：
  1.定义两个链表number_stack,operator_stack用来存放数字和符号
  2.定义布尔变量compute_flag记录是否可以计算
  3.遍历字符串，
    NUMBER_STATE
    1）如果为数字 number=number*10+ch-'0';
    2) 否则，数字进数字栈number_stack.push
       根据compute_flag进行计算，并切换至OPERATION_STATE
       并将字符指针退格，number=0
    OPERATION_STATE
    1)如果为+,-
    operation_state.push
    compute_flag=1
    2)如果为（
    compute_flag=0
    切换至NUMBER_STACK
    3)如果为）
     进行计算
    4）如果为数字
     切换到NUMBER_STATE，并将字符指针i退格

 
   注意退格指针i的时机
代码为StackToCalculator.java
-------------------------------------------------------------------------
6.第K大的数字
LeetCode 215. Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/description/
思路：
 使用最小堆存储k个数字，由于堆是最小堆，堆顶是堆中最小元素，
新元素添加时，保证比堆顶小（否则新元素替换堆顶），
故堆中K个元素是已扫描的元素里最大的K个，堆顶即第K大的数。

设数组长度为N，求第K大的数，时间复杂度：N*logK

代码为:MaxKValue.java

-------------------------------------------------------------------------
7.找中位数
LeetCode 295. Find Median from Data Stream
https://leetcode.com/problems/find-median-from-data-stream/description/

设计一个数据结构，该数据结构动态维护一组数据，且支持如下操作：
1）添加元素，将整型num添加到数据结构中
2）返回数据的中位数，返回其维护的数据的中位数

中位数定义：
1）若数据个数为奇数，中位数是该组数排序后中间的数。[1,2,3] 中位数为2
2）若数据个数为偶数，中位数是该组数排序后中间两个数字的平均值[1,2,3,4]中位数为2.5

思路：
  维护一个最大堆和最小堆
  最大堆堆顶比堆内其他元素都大，最小堆堆顶比堆内其他元素都小，且两个堆内元素个数相差<=1
  这样下来，两个堆堆内元素个数相同时，两个堆堆顶平均值即中位数
  如果最大堆元素个数大于最小堆，那么中位数即最大堆堆顶
  如果最小堆元素个数大于最大堆，那么中位数即最小堆堆顶
  
  向堆内添加元素时，
  ①当两个堆都为空时，将num加入到最小堆中
  ②当最小堆大小大于最大堆大小时，
      如果num比最小堆堆顶大，将最小堆的堆顶元素取出放入最大堆中，然后将num放入最小堆中
      否则，直接放入最大堆里
  ③当最小堆大小小于最大堆大小时
      如果num比最大堆堆顶元素小，将最大堆的堆顶元素取出放入最小堆中，然后将num放入最大堆
  ④当最小堆和最大堆大小一样时
    如果num大于最小堆堆顶，放入最小堆中，否则放入最大堆中。
代码为：MediumNumber.java
