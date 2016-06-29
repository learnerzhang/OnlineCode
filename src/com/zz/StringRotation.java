package com.zz;

public class StringRotation {

	public static String rotateString(String A, int n, int p) {
		
		StringBuffer sb = new StringBuffer();
		for (int i = p+1; i < n; i++) {
			sb.append(A.charAt(i));
		}
		for (int i = 0; i <= p; i++) {
			sb.append(A.charAt(i));
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		String rString =  rotateString("ABCDEFGH",8,4);
		System.out.println(rString);
	}
}
