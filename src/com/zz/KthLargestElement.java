package com.zz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class KthLargestElement {

	public static int rs = 0;
	public static int k  = 0;
	public static boolean flag = true;
	public void kthQsort(ArrayList<Integer> numbers,int left,int right) {
		if(left < right && this.flag)
		{
			int i = left;
			int j = right;
			int x = numbers.get(i);
			while(i < j){
				//从左->右	找小于 x的值来填 s[i]
				while (i < j && numbers.get(j) >= x) j--;
				if(i < j){ numbers.set(i++, numbers.get(j));}
				
				// 从左->右     找大于或等于x的数来填s[j]
				while (i < j && numbers.get(i) < x) i++;
				if(i < j){ numbers.set(j--, numbers.get(i));}
			}
			//退出时，i等于j。将x填到这个坑中
			numbers.set(i, x);
			if(i == numbers.size()-k)
			{
				this.rs = x;
				this.flag = false;
				return;
			}
			kthQsort(numbers,left,i-1);
			kthQsort(numbers, i+1, right);
		}
	}
	public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
		this.k = k;
		kthQsort(numbers, 0, numbers.size()-1);
		return rs;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,8,9,10,7};
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		new KthLargestElement().kthLargestElement(10, list);
		System.err.println(new KthLargestElement().rs);
	}

}
