package com.zz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedSet {

	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
		// Write your code here

		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		List<UndirectedGraphNode> currNode = new ArrayList<UndirectedGraphNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (UndirectedGraphNode node : nodes) {
			List<Integer> sublist = null;
			if(!currNode.contains(node))
			{
				sublist = new ArrayList<Integer>();
				queue.add(node);
				while (!queue.isEmpty()) {
					UndirectedGraphNode tmp = queue.poll();
					if (!currNode.contains(tmp)) {
						currNode.add(tmp);
						sublist.add(tmp.label);
						for (UndirectedGraphNode nGraphNode : tmp.neighbors) {
							queue.add(nGraphNode);
						}
					}
				}
			}
			if(sublist!=null)list.add(sublist);
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}