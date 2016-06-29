package com.zz;

import java.util.ArrayList;

public class LongestWords {
	/**
	 * {"dog","google","facebook","internationalization","blabla"}中, 最长的单词集合为 ["internationalization"]
	 * */
	ArrayList<String> longestWords(String[] dictionary) {
		ArrayList<String> reList = new ArrayList<String>();
		int MaxLength = 0;
		for(String word:dictionary)
		{
			if(word.length() > MaxLength){
				//清除 List 里的数据
				reList.clear();
				//添加首个最长的单词
				reList.add(word);
				//将当前最长单词长度 赋给 MaxLength
				MaxLength = word.length();
			}else if (word.length() == MaxLength) {
				reList.add(word);
			}
		}
		return reList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
