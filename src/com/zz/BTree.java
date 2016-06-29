package com.zz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BTree {

	public boolean isOpSymbol(String val) {
		if (val == "+" || val == "-" || val == "*" || val == "/"|| val ==")"|| val =="(") {
			return true;
		}
		return false;
	}

	// only think the operator +-*/
	/**
	 * @author zhen
	 * @param op1
	 * @param op2
	 * @return if the op1 priorer than op2
	 */
	public boolean larger(String op1, String op2) {
		
		if(op2 == ")")
		{
			return true;
		}else if (op2 == "(") {
			return false;
		}else {
			if (op1 == "*"|| op1 == "/"||((op1 == "+"||op1 == "-")&&(op2 == "+"||op2 == "-"))) {
				return true;
			}
			return false;
		}
	}
	public static void printStack(Stack<String> s) {
		for (int i = 0; i < s.size(); i++) {
			System.out.print(s.get(i)+" ");
		}
		System.out.println();
	}
	/**
	 * 对于 (2*6-(23+7)/(1+2)) 的表达 可表示为 ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/"
	 * "(" "1" "+" "2" ")"]
	 */
	public ExpressionTreeNode build(String[] expression) {
		// write your code here
		List<String> list = new ArrayList<String>();
		Stack<String> opStack = new Stack<String>();
		Stack<ExpressionTreeNode> treeNode = new Stack<ExpressionTreeNode>();
		for(String op:expression)
		{
			list.add(op);
			//System.out.print(op+" ");
		}
		list.add(")");
		//System.out.println();
		opStack.push("(");
		for(String op:list)
		{
			if(!isOpSymbol(op))
			{//添加数据
				treeNode.add(new ExpressionTreeNode(op));
			}else {
				
				String tmp = opStack.peek();
				while (larger(tmp, op)) {
					//printStack(opStack);
					String ss = opStack.pop();
					if(tmp == "(")
					{
						break;
					}
					ExpressionTreeNode node = new ExpressionTreeNode(ss);
					ExpressionTreeNode rchild = treeNode.pop();
					ExpressionTreeNode lchild = treeNode.pop();
					node.right = rchild;node.left = lchild;
					treeNode.add(node);
					tmp = opStack.peek();
				}
				if(op!=")")
					opStack.push(op);
			}
		}
		return treeNode.pop();
	}

	public void display(ExpressionTreeNode tree) {
		
		if (tree!=null) {
			display(tree.left);
			System.out.print(tree.symbol);
			display(tree.right);
		}
	}
	public static void main(String[] args) {
		String[] ex = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
		BTree tree = new BTree();
		ExpressionTreeNode root = tree.build(ex);
		tree.display(root);
	}
}
class ExpressionTreeNode {

	public String symbol;
	public ExpressionTreeNode left, right;

	public ExpressionTreeNode(String symbol) {
		this.symbol = symbol;
		this.left = this.right = null;
	}
}
