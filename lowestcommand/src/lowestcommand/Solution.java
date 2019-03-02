package lowestcommand;

import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x ){
		val = x;
	}
}
public class Solution {


    public static  List<Integer> path1 = new LinkedList<>();
    public static  List<Integer> path2 = new LinkedList<>();
    public static boolean pathfind(TreeNode cur, int goal,List<Integer> path){

        // to do thinkg about return something
        path.add(cur.val);
        if(cur.val == goal){
            return true;
        }
        
        if(cur.left!=null){
            boolean res = pathfind(cur.left,goal,path);
            if(res == true) return true;   //剪枝
        }
        if(cur.right!=null){
            boolean res = pathfind(cur.right,goal,path);
            if(res == true) return true;
        }
        
        path.remove(path.size()-1);
      
        return false;
    }
    
	
	public static void main(String[] args) {
		
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(5);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(6);
//		root.left.right = new TreeNode(2);
//		root.left.right.left = new TreeNode(7);
//		root.left.right.right = new TreeNode(4);
//		root.right.left = new TreeNode(0);
//		root.right.right = new TreeNode(8);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		pathfind(root,1,path1);
		pathfind(root,2,path2);
		
		Iterator<Integer> iterator = path1.listIterator();
		Iterator<Integer> iter2 = path2.listIterator();
		int ans = 0;
		
		while(iterator.hasNext() && iter2.hasNext()) {
			int l = iterator.next();
			int r = iter2.next();
			if(l == r) {
				ans = l;
			}
		}
		System.out.println(path1.toString());
		System.out.println(path2.toString());
		System.out.println(ans);
	}
}
