package com.zz;

public class Mindifferential {
	
	public static char[] label = new char[10000];
	public int smallestDifference(int[] A, int[] B) {
		int min = 1000;
		int max = 0;
		for(int i:A)
		{
			if(min>i)
				min = i;
			if(max<i)
				max = i;
			label[i] = 'A';
		}
		
		for(int i:B)
		{
			if(min>i)
				min = i;
			if(max<i)
				max = i;
			
			if(label[i] == 'A')
				return 0;
			label[i] = 'B';
		}
		
		int step = 1000;
		int curr = 0;
		char pch = label[min];
		for(int k=min+1;k<=max;k++)
		{
			curr++;
			if(label[k]!=0)
			{
				if(label[k]!=pch)
				{
					pch = label[k];
					if(curr<step)
						step = curr;
				}
				curr = 0;
			}
		}
		return step;
    }
	public static void main(String[] args) {
		
		int A[] = {1,4,16,7,6,27};
		int B[] = {12,14,18,19,100};
		
		System.out.println(new Mindifferential().smallestDifference(A, B));
	}
}
