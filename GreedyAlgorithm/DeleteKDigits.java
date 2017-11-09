package com.classes.three;

import java.util.ArrayList;
import java.util.List;

public class DeleteKDigits {
	public static void main(String[] args) {
		String num = "10";
		System.out.println(new SolutionThree().removeKdigits(num, 2));
	}
}

class SolutionThree{
	public String removeKdigits(String num,int k){
		List<Integer> list = new ArrayList<Integer>();//使用list代替栈，方便遍历
		String res = "";//存储最终结果
		for(int i=0;i<num.length();i++){//从高位循环扫描
			int number = num.charAt(i)-'0'; //从前往后，取出一个字符转换成数字
			while(list.size()!= 0&&list.get(list.size()-1) > number && k>0){
				list.remove(list.size()-1);  //栈不空，且栈顶元素大于number，仍然可以删除
				k--;
			}
			if(number != 0 ||list.size()!=0){
				list.add(number); //将number压入栈中，解决栈首元素为0的情况
			}
		}
		
		while(list.size() !=0 && k>0){//如果栈不为空，仍然可以删除数字
			list.remove(list.size()-1);
			k--;
		}
		for(int i=0;i<list.size();i++){
			res= res+list.get(i);
		}
		if(res == ""){
			return "0";
		}
		return res.toString();
	}
}