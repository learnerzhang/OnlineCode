package com.zz;

public class MaxDivision {

	/*
	 * 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
	 * */
	class Bucked{
		int val;
		Bucked next;
		public Bucked(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
			next = null;
		}
	}
	public  int findMaxDivision(int[] A, int n) {
		//数组中最大的值不超过10000;
		Bucked bucked[] = new Bucked[30];
		for (int i = 0; i < n; i++) {
			int index = A[i]*30/10000;
			if (bucked[index]==null) {
				bucked[index] = new Bucked(A[i]);
			}else {
				Bucked p = bucked[index];
				Bucked q = bucked[index];
				
				while (p!=null && p.val<A[i]) {
					q = p;
					p = p.next;
				}
				if (p==q) {
					bucked[index] = new Bucked(A[i]);
					bucked[index].next = p;
				}else {
					q.next = new Bucked(A[i]);
					q.next.next = p;
				}
			}
		}
		int k = 0;
		for (int i = 0; i < bucked.length; i++) {
			if (bucked[i]!=null) {
				Bucked p = bucked[i];
				do {
					A[k++] = p.val;
					p = p.next;
				} while (p!=null);
			}
		}
		
		int v = A[1]-A[0];
		for (int i = 2; i < n; i++) {
			if (A[i]-A[i-1]>v) {
				v = A[i]-A[i-1];
			}
		}
		return v;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,3,1,10,4,100};
		int rs = new MaxDivision().findMaxDivision(A, 6);
		System.out.println(rs);
	}

}
