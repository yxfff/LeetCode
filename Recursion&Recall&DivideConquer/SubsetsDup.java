package com.classes.four;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubsetsDup {
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

//ʱ��ϳ�
class SolutionTwo{
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int all_set = 1<<nums.length;//ȫ���������ֵ+1�� 1<<n��Ϊ2^n
		for(int i=0;i<all_set;i++){
			List<Integer> item = new ArrayList<Integer>();
			for(int j=0;j<nums.length;i++){
				//����i�����0��2^n-1��2^n������
				//��1<<j����Ϊ����nums����ĵ�j��Ԫ��
				//��i&(1<<j)=1��nums[j]����item��
				if((i&(1<<j)) == 1){//��������i����ļ��ϣ���Ԫ�ش洢��item��
					item.add(nums[j]);
				}
			}
			result.add(item);
		}
		return result;
	}
	
	
}
