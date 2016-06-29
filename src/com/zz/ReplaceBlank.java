package com.zz;

public class ReplaceBlank {

	public int replaceBlank(char[] string, int length) {
        // Write your code here
		int spacecount = 0;
		for(int i = 0;i < length;i++)
		{
			if(string[i] == ' ')
				spacecount++;
		}
		int curp = length+2*spacecount-1;
		
		for (int i = length-1; i >= 0; i--) {
			if (string[i]==' ') {
				
				string[curp--] = '0';
				string[curp--] = '2';
				string[curp--] = '%';
				
			}else
				string[curp--] = string[i];
		}
		return length;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch[] = {'a','b','c','\0'};
		char chs[] = new char[100];
		chs[0] = 'a';
		chs[1] = 'a';
		chs[2] = 'a';
		chs[3] = 'b';
		chs[4] = '\0';
		System.out.println(ch.length);
		System.out.println(chs.length);
	}

}
