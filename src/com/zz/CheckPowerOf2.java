package com.zz;

public class CheckPowerOf2 {

	public boolean checkPowerOf2(int n) {
		// write your code here
		while (n != 0) {
			int v = n & 1;
			n = n >> 1;
			if (v == 1) {
				if (n == 0)
					return true;
				else
					return false;
			}
		}
		return false;
	}
}
