package com.zz;

import java.util.ArrayList;
import java.util.List;

public class Airplanes {
	public static int[] proj= new int[100000];
	public static int max = 0;
	public static int min = 10000;
	public void proj(int start,int end) {
		
		if(max<end)
			max = end;
		if(min>start)
			min = start;
		
		for (int i = start; i < end; i++) {
			proj[i]+=1;
			//System.out.print("["+i+","+(i+1)+"]"+proj[i]+" ");
		}
	}
	public int countOfAirplanes(List<Interval> airplanes) {
		int maxCount = proj[min];
		for (Interval air:airplanes) {
			proj(air.start, air.end);
		}
		for (int i = min; i < max; i++) {
			if(proj[i]>maxCount)
				maxCount = proj[i];
		}
		return maxCount; 
	}
	public static void main(String[] args) {
		List lists = new ArrayList<Interval>();
		lists.add(new Interval(1, 10));
		lists.add(new Interval(10, 20));
		lists.add(new Interval(20, 30));
		lists.add(new Interval(30, 40));
		
		System.out.println(new Airplanes().countOfAirplanes(lists));
	}
}
