package com.classes.three;

public class MaxWiggle {
	public static void main(String[] args) {
		int[] nums = {1,7,4,9,2,5};
		int res = new SolutionTwo().wiggleMaxLength(nums);
		System.out.println(res);
		
	}
}

class SolutionTwo{
	public int wiggleMaxLength(int[] nums){
		if(nums.length<2){
			return nums.length;
		}
		//扫描序列的三种状态
		final int BEGIN = 0;
		final int UP = 1;
		final int DOWN = 2;
		//摇摆序列的最大长度至少为1
		int STATE = BEGIN;
		int max_length = 1;
		for(int i=1;i<nums.length;i++){
			switch(STATE){
				case BEGIN:
					if(nums[i-1]<nums[i]){
						STATE = UP;
						max_length++;
					}else if(nums[i-1] > nums[i]){
						STATE=DOWN;
						max_length++;
					}
					break;
				case UP:
					if(nums[i-1]> nums[i]){
						STATE = DOWN;
						max_length++;
					}
					break;
				case DOWN:
					if(nums[i-1]<nums[i]){
						STATE=UP;
						max_length++;
					}
					break;
			}
		}
		return max_length;
	}
}
