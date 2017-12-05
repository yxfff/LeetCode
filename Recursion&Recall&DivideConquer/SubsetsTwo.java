package com.classes.four;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubsetsTwo {
	public static void main(String[] args) {
		int[] nums={1,2,3};
		List<List<Integer>> result = new SolutionOne().getSubsets(nums);
		Iterator itera = result.iterator();
		for(int i=0;i<result.size();i++){
			if(itera.hasNext()){
				System.out.println(itera.next());
			}
		}
	}
}

//时间较长
class SolutionTwo{
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int all_set = 1<<nums.length;//全部集合最大值+1， 1<<n即为2^n
		for(int i=0;i<all_set;i++){
			List<Integer> item = new ArrayList<Integer>();
			for(int j=0;j<nums.length;i++){
				//整数i代表从0到2^n-1这2^n个集合
				//（1<<j）即为构造nums数组的第j个元素
				//若i&(1<<j)=1则nums[j]放入item中
				if((i&(1<<j)) == 1){//构造数字i代表的集合，各元素存储在item中
					item.add(nums[j]);
				}
			}
			result.add(item);
		}
		return result;
	}
	
	
}
