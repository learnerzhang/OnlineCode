package com.zz;

public class TreeToSequence {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	public String toSequence(TreeNode root) {
        // write code here
		if (root.left==null&&root.right==null) {
			return "()";
		}else if (root.left!=null&&root.right==null) {
			return "("+toSequence(root.left)+")";
		}else if (root.left==null&&root.right!=null) {
			return "("+toSequence(root.right)+")";
		}else {
			return "("+toSequence(root.left)+toSequence(root.right)+")";
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sss");
	}

}
