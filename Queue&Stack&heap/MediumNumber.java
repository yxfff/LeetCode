package com.classes.two;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MediumNumber {

}



class SolutionSeven{
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	public SolutionSeven(){
		Comparator<Integer> comparator = new Comparator<Integer>(){

			@Override
			public int compare(Integer l, Integer r) {
				return r.compareTo(l);
			}

		};

		maxHeap = new PriorityQueue<Integer>(20,comparator);
		minHeap = new PriorityQueue<Integer>(20);
	}

	public void addNumber(int num){
		//最大堆为空时，直接添加num到最大堆
		if(maxHeap.isEmpty()&&minHeap.isEmpty()){
			minHeap.add(num);
		}else if(minHeap.size()>maxHeap.size()){
			//当最小堆的大小大于最大堆的大小时
			//num比最小堆堆顶元素大，将最小堆堆顶元素放入最大堆中，再将num加入最小堆中
			if(num > minHeap.peek()){
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			}else{
				maxHeap.add(num);
			}
		}else if(minHeap.size()<maxHeap.size()){
			//当最小堆大小小于最大堆时，
			//如果num比最大堆的堆顶小，将最大堆的堆顶元素放入最小堆中，再将num放入最大堆中
			if(num < maxHeap.peek()){
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			}else{
				minHeap.add(num);
			}
		}else{//当最大堆和最小堆大小相等时
			if(num < maxHeap.peek()){
				maxHeap.add(num);
			}else{
				minHeap.add(num);
			}
		}
	}

	public double findMedian() {
		if(minHeap.size()==0&&maxHeap.size()==0){
			return 0.0;
		}
		if(maxHeap.size()==minHeap.size()){
			return (double)(maxHeap.peek()+minHeap.peek())/2;
		}else if(maxHeap.size() > minHeap.size()){
			return maxHeap.peek();
		}
		return minHeap.peek();
	}





}



