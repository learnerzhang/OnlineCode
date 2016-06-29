package com.zz;

public class CanCompleteCircuit {

	/*
	 * Ok
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// write your code here
		int N = gas.length;
		for (int i = 0; i < cost.length; i++) {
			int tank = gas[i] - cost[i];
			int cur = (i+1)%N;
			while(tank>=0 && cur!=i)
			{
				tank+=gas[cur]-cost[cur];
				cur = (cur+1)%N;
			}
			//System.out.println(tank+" ： "+(cur!=i));
			if(tank>=0 && cur == i)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {2,4};
		int[] cost = {3,4};
		int rs = new CanCompleteCircuit().canCompleteCircuit(gas,cost);
		System.out.println(rs);
	}

}
