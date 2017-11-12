package com.classes.three;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {
	public static void main(String[] args) {
		
	}
}

class SolutionFour{
	public boolean canJump(int[] nums){
		int[] index = new int[nums.length]; //最远可以跳到的位置
		int jump = 0;
		int max_index =nums[0];
		for(int i=0;i<nums.length;i++){
			index[i] = i+nums[i];
		}
		while(jump < index.length && jump <= max_index){
			if(max_index < index[jump]){
				max_index = index[jump];
			}
			jump++;
		}
		if(jump == index.length){//若jump到达了数组尾部，返回真
			return true;
		}
		return false;
	}
}
