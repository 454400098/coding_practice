import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
public class Solution {
	private static List<Integer> ans = new LinkedList<>();
	public static void ans (TreeNode node) {
		mean(node);
		
		int len = ans.size();
		if(len %2 == 0) {
			System.out.println("ans is " + (ans.get(len/2) + ans.get(len/2-1))/2);
		}else {
			System.out.println("ans is " + (node.val+1));
		}
	}
	public static void mean(TreeNode node) {
		if(node == null)
			return ;
		mean(node.left);
		ans.add(node.val);
		mean(node.right);
	}

	public static void main(String[]args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		
		
		TreeNode t = new TreeNode(6);
		t.left = new TreeNode(3);
		t.left.left = new TreeNode(1);
		t.left.right = new TreeNode(4);
		t.right = new TreeNode(8);
		t.right.left = new TreeNode(7);
		ans(t);
		
		String s = "asda";
		char[] c = s.toCharArray();
		
	}
}
