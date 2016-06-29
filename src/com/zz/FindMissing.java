package com.zz;

public class FindMissing {

	/**
	 * 给出一个包含 0 .. N 中 N 个数的序列，找出0 .. N 中没有出现在序列中的那个数。
	 * eg N = 4 且序列为 [0, 1, 3] 时，缺失的数为2。
	 * 思路：通过（n-1）* n - sum(num[])
	 * */
	public int findMissing(int[] nums) {
        // write your code here
		int len = nums.length;
		int sum = 0;
		for(Integer i:nums)
			sum+=i;
		return (len+1)*len/2-sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
