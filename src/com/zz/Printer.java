package com.zz;

public class Printer {

	public static int[] printMatrix(int[][] mat, int n, int m) {
        // write code here
		int[] num = new int[n*m];
		int  cur = 0;
		for (int i = 0; i < n; i++) {
			if (i%2==0) {
				for (int j = 0; j < m; j++) {
					num[cur++] = mat[i][j];
				}
			}else {
				for (int j = m-1; j >= 0; j--) {
					num[cur++] = mat[i][j];
				}
			}
			
		}
		return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int[] r = printMatrix(num, 4, 3);
		for (int i : r) {
			System.out.print(i+" ");
		}
	}

}
