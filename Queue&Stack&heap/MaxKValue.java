package com.classes.two;

public class MaxKValue {
	public static void main(String[] args) {
		int[] nums = {7,6,5,4,3,2,1};
		int res = new SolutionSix().findKthLargest(nums, 5);
		System.out.println(res);
	}
}

//最小堆实现
class MinHeap{
	private int[] data;
	
	public MinHeap(int[] data){
		this.data = data;
		buildHeap();
	}
	
	//数组转换成最小堆
	private void buildHeap(){
		//完全二叉树只有数组下标小于或者等于(data.length)/2-1的元素有孩子节点，遍历这些节点
		for(int i=(data.length)/2-1;i>=0;i--){
			heapify(i);
		}
	}
	
	private int left(int i){
		return ((i+1)<<1)-1;
	}
	
	private int right(int i){
		return (i+1)<<1;
	}
	private void swap(int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	public int getRoot(){
		return data[0];
	}
	public void setRoot(int root){
		data[0]=root;
		heapify(0);
	}
	private void heapify(int i){
		//获取左右节点的数组下标
		int l = left(i);
		int r = right(i);
		//设置一个临时变量，表示根几点，左节点，右节点中最小值的节点的下标
		int smallest = i;
		//存在左节点，且左节点的值小于根节点
		if(l < data.length && data[l]<data[i]){
			smallest = l;
		}
		//存在右节点，且右节点的值小于根节点
		if(r < data.length && data[r]<data[smallest]){
			smallest = r;
		}
		//如果根节点即最小值，则直接返回不做任何操作
		if(i == smallest){
			return;
		}
		//交换根节点和左右节点中最小值,把根节点的值替换下去
		swap(i,smallest);
		//由于替换后的左右子树会被影响，所以要对受影响的子树再进行heapify()
		heapify(smallest);
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i =0;i<data.length;i++){
			str = str+"->"+data[i];
		}
		return str;
	}
}

class SolutionSix{
	public int findKthLargest(int[] nums,int k){
		int[] topK = new int[k];
		for(int i=0;i<topK.length;i++){
			topK[i] = nums[i];
		}
		
		
		
		MinHeap minHeap = new MinHeap(topK);
		System.out.println(minHeap.toString());
		for(int i=k;i<nums.length;i++){
			int root = minHeap.getRoot();
			if(nums[i]>root){
				minHeap.setRoot(nums[i]);
			}
		}
		return minHeap.getRoot();
	}
	
}