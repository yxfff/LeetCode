package com.classes.three;

import java.util.Arrays;

public class AssignCookies {
	public static void main(String[] args) {
		int[] g = {1,2,3};
		int[] s = {1,1};
		int num = new SolutionOne().findContentChildren(g, s);
		System.out.println(num);
	}
}

class SolutionOne{
	public int findContentChildren(int[] g,int[] s){
		Arrays.sort(g);
		Arrays.sort(s);
		int child = 0;
		int cookie = 0;
		while(child < g.length && cookie < s.length){
			if(s[cookie]>=g[child]){
				child++;
			}
			cookie++;
		}
		return child;
	}
}
