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

//�Զ������ݽṹ�洢����վ���յ�ľ��������
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
		//L:��㵽�յ�ľ���
		//P:����ʼ��������
		//HashMap:����վ���յ�ľ��롣����վ������

		//�洢����������
		Comparator<Integer> revCmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer left, Integer right) {
				return right.compareTo(left);
			}
		};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(revCmp);
		//��¼�ӹ�������
		int result = 0;
		//���յ���Ϊһ��ͣ���㣬�����stop��
		stop.add(new MyMap(0,0));
		//��ͣ�������յ�ľ���Ӵ�С����
		Collections.sort(stop,new CMP());
		for(int i=0;i<stop.size();i++){//������������վ
			//��ǰҪ�ߵľ��뼴��ǰλ�þ��յ�ľ���
			int dis = L-stop.get(i).getDistance();
			while(!maxHeap.isEmpty() && P < dis){
				P += maxHeap.poll();
				result++;
			}

			if(maxHeap.isEmpty() && P < dis){
				return -1;
			}
			P = P - dis;
			//����LΪ��ǰͣ���㵽�յ����
			L = stop.get(i).getDistance();
			//��ǰͣ��������������������
			maxHeap.add(stop.get(i).getOil());
		}

		return result;
	}
}