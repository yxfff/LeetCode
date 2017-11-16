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
		//气球按照左端点从小到大排序
		Arrays.sort(points,new PointComparator());
		//初始化弓箭手数量
		int shoot_num =1;		
		//初始化射击区域，即第一个气球的两端点
		int shoot_begin = points[0][0];
		int shoot_end = points[0][1];
		
		for(int i=1;i<points.length;i++){
			if(points[i][0]<=shoot_end){
				shoot_begin=points[i][0];
				if(shoot_end > points[i][1]){
					shoot_end=points[i][1];
				}
			}else{
				//保证当前气球被射穿的条件下，射击区间不能更新了，需要再增加一个弓箭手
				shoot_num++;
				shoot_begin = points[i][0];
				shoot_end = points[i][1];
			}
		}
		return shoot_num;
	}
}
