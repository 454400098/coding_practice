class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
public class Solution {
		static ListNode head;
	
	   public  static ListNode reverseList(ListNode head) {
           if(head==null) return null;
	        ListNode cur = head;
	        ListNode next =null;
	        ListNode pre = null;
	        while(cur.next!=null) {
	        	next = cur.next;
	        	cur.next = pre;
	        	pre = cur;
	        	cur = next;
	        }
	      
            cur.next = pre;
	        return cur;
	    }
	   
	   public static ListNode recursion(ListNode cur,ListNode prev ) {
		   //If last node mark it head
		   if(cur.next ==null) {
			   head = cur;
			   
			   //update next to prev node
			   cur.next = prev;
			   System.out.println("here");
			   return head;
		   }
		   
		   
		  
		   
		   // save cur-> next to next for recursion
		   ListNode next = cur.next;
		   
		   //update next;
		   cur.next = prev;
		   recursion(next,cur);
		   
		   return head;
	   }
	   
	
	public static void main(String[]args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		
		ListNode ans = reverseList(root);
		
		recursion(root,null);
	}
}
