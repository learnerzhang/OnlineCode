package com.zz;

public class InvertBinaryTree {

	public static void print(TreeNode root){
		if(root!=null){
			System.out.print(root.val+" ");
			print(root.left);
			print(root.right);
		}
	}
	public void invertBinaryTree(TreeNode root) {
        // write your code here
		if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
		
		if(T2 == null&&T1 == null)
			return true;
		if(T1!=null)
		{
			if(T2!=null&&T1.val == T2.val && isSubtree(T1.left, T2.left) && isSubtree(T1.right, T2.right))
				return true;
			else {
				return isSubtree(T1.left, T2)||isSubtree(T1.right, T2);
			}
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		print(root);
		System.out.println();
		new InvertBinaryTree().invertBinaryTree(root);
		print(root);
	}
}
class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}
