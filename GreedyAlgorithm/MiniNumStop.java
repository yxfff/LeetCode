package com.classes.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MiniNumStop {
	public static void main(String[] args) {
		List<MyMap> list = new ArrayList<MyMap>();
		list.add(new MyMap(5,3));
		list.add(new MyMap(7,3));
		list.add(new MyMap(6,3));
		list.add(new MyMap(3,3));
		list.add(new MyMap(4,3));

		int res = new SolutionSeven().get_minimum_stop(10, 5, list);
		System.out.println(res);
	}
}

class CMP implements Comparator<MyMap>{
	@Override
	public int compare(MyMap o1, MyMap o2) {
		return o2.getDistance()-o1.getDistance();
	}
}

//自定义数据结构存储加油站至终点的距离和油量
class MyMap {
	private int distance;
	private int oil;

	public MyMap(int distance,int oil){
		this.distance =distance;
		this.oil = oil;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}
}
class SolutionSeven{
	public int get_minimum_stop(int L,int P,List<MyMap> stop ){
		//L:起点到终点的距离
		//P:起点初始的汽油量
		//HashMap:加油站至终点的距离。加油站汽油量

		//存储油量的最大堆
		Comparator<Integer> revCmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer left, Integer right) {
				return right.compareTo(left);
			}
		};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(revCmp);
		//记录加过几次油
		int result = 0;
		//将终点作为一个停靠点，添加至stop中
		stop.add(new MyMap(0,0));
		//以停靠点至终点的距离从大到小排序
		Collections.sort(stop,new CMP());
		for(int i=0;i<stop.size();i++){//遍历各个加油站
			//当前要走的距离即当前位置距终点的距离
			int dis = L-stop.get(i).getDistance();
			while(!maxHeap.isEmpty() && P < dis){
				P += maxHeap.poll();
				result++;
			}

			if(maxHeap.isEmpty() && P < dis){
				return -1;
			}
			P = P - dis;
			//更新L为当前停靠点到终点距离
			L = stop.get(i).getDistance();
			//当前停靠点的汽油量添加至最大堆
			maxHeap.add(stop.get(i).getOil());
		}

		return result;
	}
}