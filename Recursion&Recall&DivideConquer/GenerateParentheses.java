package com.classes.four;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		int n = 3;
		ArrayList<String> result = (ArrayList<String>) new SolutionFive().generateParenthesis(n);
		Iterator itera = result.iterator();
		while(itera.hasNext()){
			System.out.println(itera.next());
		}
		
		
	}
}

class SolutionFive{
	public List<String> generateParenthesis(int n){
		List<String> result = new ArrayList<String>();
		generate("",n,n,result);
		return result;
	}
	
	private void generate(String item,int left,int right,List<String> result){
		if(left==0&&right==0){
			result.add(item);
			return;
		}
		if(left>0){
			generate(item+"(",left-1,right,result);
		}
		if(left<right){
			generate(item+")",left,right-1,result);
		}
		
		
	}
}