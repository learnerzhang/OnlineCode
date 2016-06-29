package com.zz;

import java.math.BigInteger;

public class Sqrt {

	public int sqrt(int x) {
		// write your code here
		if (x == 0)
			return 0;
		if (x == 1 || x == 2)
			return 1;
		if (x == 3 || x == 4)
			return 2;

		int left = 0;
		int right = x;
		int mid = (left + right) / 2;
		BigInteger bigX = new BigInteger(String.valueOf(x));
		while (left != mid) {
			BigInteger bint = new BigInteger(String.valueOf(mid));
			if (mid * mid == x)
				return mid;
			if (bint.multiply(bint).compareTo(bigX)>0)
				right = mid;
			else
				left = mid;
			mid = (left + right) / 2;
		}
		return mid;
	}

	public static void main(String[] args) {
		//测试数据相当诡异啊
		System.out.println(Integer.MAX_VALUE+" "+2147483647);
		int rs = new Sqrt().sqrt(999999999);
		System.out.println(rs);
	}
}
