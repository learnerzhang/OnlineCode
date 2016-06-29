package com.zz;

public class PalindromeList {

	class ListNode {
	    int val;
	    ListNode next = null;
	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode reverse(ListNode L,ListNode node) {
		node.next = L;
		L = node;
		return L;
	}
	
	public boolean chkPalindrome(ListNode A) {
        // write code here
		ListNode p = A;
		int len = 1;
		while (p.next!=null) {
			p = p.next;len++;
		}
		int start,count=0;
		if (len%2==0) {
			start = len/2;
			count = 1;
			ListNode q = A;
			while (count!=start) {
				q = q.next;
				count++;
			}
			ListNode B = null;
			ListNode r = q.next;
			ListNode l;
			while (r!=null) {
				l = r.next;
				B = reverse(B, r);
				r = l;
			}
			p = A;
			l = B;
			while (p!=null&&l!=null&&p!=B) {
				if (p.val!=l.val) {
					return false;
				}
				p = p.next;
				l = l.next;
			}
		}else {
			start = len/2+1;
			count = 1;
			ListNode q = A;
			while (count!=start) {
				q = q.next;
				count++;
			}
			ListNode B = null;
			ListNode r = q.next;
			ListNode l;
			while (r!=null) {
				l = r.next;
				B = reverse(B, r);
				r = l;
			}
			p = A;
			l = B;
			while (p!=null&&l!=null&&p!=q) {
				if (p.val!=l.val) {
					return false;
				}
				p = p.next;
				l = l.next;
			}
		}
		
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
