class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
public class Solution {
	
	
	   public static ListNode reverseList(ListNode head) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        
	        ListNode cur = head;
	        ListNode next = head.next;
	        while ( next!=null){
	        	System.out.println("cur val is " + cur.val);
	        	System.out.println("next val is " + next.val);
	            next = next.next;
	            ListNode tmp = cur.next;
	            tmp.next = cur;
	            cur = tmp;
	            cur.next = next;
	     
	        }
	      
	        return cur;
	    }
	   
	   
	
	public static void main(String[]args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		
		reverseList(root);
	}
}
