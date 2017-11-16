package com.classes.three;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumOfArrows {
	public static void main(String[] args) {

	}
}

class PointComparator implements Comparator<int[]>{
	@Override
	public int compare(int[] o1, int[] o2) {
		return o1[0]-o2[0];
	}
}

class SolutionSix{
	public int findMinArrowShots(int[][] points) {
		if(points.length == 0){
			return 0;
		}
		//��������˵��С��������
		Arrays.sort(points,new PointComparator());
		//��ʼ������������
		int shoot_num =1;		
		//��ʼ��������򣬼���һ����������˵�
		int shoot_begin = points[0][0];
		int shoot_end = points[0][1];
		
		for(int i=1;i<points.length;i++){
			if(points[i][0]<=shoot_end){
				shoot_begin=points[i][0];
				if(shoot_end > points[i][1]){
					shoot_end=points[i][1];
				}
			}else{
				//��֤��ǰ�����䴩�������£�������䲻�ܸ����ˣ���Ҫ������һ��������
				shoot_num++;
				shoot_begin = points[i][0];
				shoot_end = points[i][1];
			}
		}
		return shoot_num;
	}
}
