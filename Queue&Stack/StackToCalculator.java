package com.classes.two;

import java.util.Stack;

public class StackToCalculator {
	public static void main(String[] args) {
		String s = "1+1";
		int res = new SolutionFive().calculate(s);
		System.out.println(res);
	}
}

class SolutionFive{
	public int calculate(String s){
		Stack<Integer> number_stack = new Stack<Integer>();
		Stack<Byte> operator_stack = new Stack<Byte>();
		
		final int BEGIN_STATE = 0;
		final int NUMBER_STATE = 1;
		final int OPERATOR_STATE = 2;
		
		int number = 0;
		int STATE = BEGIN_STATE;
		int compute_flag = 0;
		
		byte[] str = s.getBytes();
		for(int i=0;i<str.length;i++){
			if(str[i] == ' '){
				continue;
			}
			
			switch(STATE){
				case BEGIN_STATE:
					if(str[i]>='0' && str[i]<='9'){
						STATE=NUMBER_STATE;
					}else{
						STATE=OPERATOR_STATE;
					}
					i--;
					break;
				case NUMBER_STATE:
					if(str[i]>='0'&&str[i]<='9'){
						number=10*number+str[i]-'0';
					}else{
						number_stack.push(number);
						if(compute_flag == 1){
							compute(number_stack,operator_stack);
						}
						number=0;
						i--;
						STATE=OPERATOR_STATE;
					}
					break;
				case OPERATOR_STATE:
					if(str[i]=='+'||str[i]=='-'){
						operator_stack.push(str[i]);
						compute_flag=1;
					}else if(str[i]=='('){
						STATE=NUMBER_STATE;
						compute_flag=0;
					}else if(str[i]==')'){
						compute(number_stack, operator_stack);
					}else if(str[i]>='0'&&str[i]<='9'){
						STATE=NUMBER_STATE;
						i--;
					}
					break;
			}
		}
		
		if(number!=0){
			number_stack.push(number);
			compute(number_stack, operator_stack);
		}
		
		if(number == 0 && number_stack.isEmpty()){
			return 0;
		}
		return number_stack.pop();
	}
	
	public void compute(Stack<Integer> number_stack,Stack<Byte> operator_stack){
		if(number_stack.size() < 2 || operator_stack.isEmpty()){
			return;
		}
		int number2 = number_stack.pop();
		int number1 = number_stack.pop();
		
		Byte operator = operator_stack.pop();
		int res = -1;
		if(operator=='+'){
			res = number1+number2;
		}else if(operator=='-'){
			res=number1-number2;
		}
		
		number_stack.push(res);
	}
}
