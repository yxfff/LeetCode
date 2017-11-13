package com.classes.three;

public class JumpGameTwo {
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		int jump = new SolutionFive().jump(nums);
		System.out.println(jump);
	}
}

class SolutionFive{
	public int jump(int[] nums){
		//前可达到的最远位置
		int current_max_index = nums[0];
		//各个位置可到达的最远位置
		int pre_max_max_index = nums[0];
		//记录步数
		int jump_min = 1;
		if(nums.length < 2){
			return 0;
		}
		for(int i=0;i<nums.length;i++){
			if(i>current_max_index){
				jump_min++;
				current_max_index=pre_max_max_index;
			}
			if(pre_max_max_index < nums[i]+i){
				pre_max_max_index = nums[i]+i;
			}
		}
		return jump_min;
	}
}
