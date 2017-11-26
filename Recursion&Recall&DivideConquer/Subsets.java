package com.classes.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Subsets {
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

class SolutionOne{
	public List<List<Integer>> getSubsets(int[] nums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		generate(0,nums,list,new ArrayList<Integer>());
		return list;
	}

	public void generate(int i,int[] nums,List<List<Integer>> list,ArrayList<Integer> tempList){
		list.add(new ArrayList<Integer>(tempList));
		while(i<nums.length){
			tempList.add(nums[i]);
			generate(i+1, nums, list, tempList);
			tempList.remove(tempList.size()-1);
			i++;
		}
	}
}
