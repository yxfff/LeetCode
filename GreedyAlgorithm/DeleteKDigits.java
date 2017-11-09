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
		List<Integer> list = new ArrayList<Integer>();//ʹ��list����ջ���������
		String res = "";//�洢���ս��
		for(int i=0;i<num.length();i++){//�Ӹ�λѭ��ɨ��
			int number = num.charAt(i)-'0'; //��ǰ����ȡ��һ���ַ�ת��������
			while(list.size()!= 0&&list.get(list.size()-1) > number && k>0){
				list.remove(list.size()-1);  //ջ���գ���ջ��Ԫ�ش���number����Ȼ����ɾ��
				k--;
			}
			if(number != 0 ||list.size()!=0){
				list.add(number); //��numberѹ��ջ�У����ջ��Ԫ��Ϊ0�����
			}
		}
		
		while(list.size() !=0 && k>0){//���ջ��Ϊ�գ���Ȼ����ɾ������
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