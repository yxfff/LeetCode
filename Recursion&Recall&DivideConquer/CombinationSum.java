package com.classes.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		
	}
}

class SolutionFour {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> temp = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	generate(0,candidates,result,temp,target);
    	return result;
    	
    }
    
    public void generate(int i,int[] candidates,List<List<Integer>>result,List<Integer> temp,int target){
    	if(target == 0){
    		result.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	
    	if(target < 0){return;}
    	
    	for(int pos =i;pos <candidates.length;pos++){
    		if(pos>i&&candidates[pos-1]==candidates[pos]){
    			continue;
    		}
    		temp.add(candidates[pos]);
    		generate(pos+1,candidates,result,temp,target-candidates[pos]);
    		temp.remove(temp.size()-1);
    	}
    }
}
