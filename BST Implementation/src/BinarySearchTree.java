import java.util.*;
public class BinarySearchTree {
	static class node{
		int val;
		node left;
		node right;
		public node (int x){
			val = x;
			left = right = null;
		}
	}
	
	
	node root;
	
	
	//constructor
	BinarySearchTree(){
		root = null;
	}
	
	public node Search(node root, int key) {
		
		if(root == null || root.val == key)return root;
		
		if(root.val > key) return Search(root.left,key);
		else {
			return Search(root.right,key);
		}
		
	}
	
	public boolean isintree(node root, int key) {
		if(root == null ) return false;
		if(root.val == key) return true;
		return isintree(root.left,key) || isintree(root.right,key);
	}
	
    public void insert(node cur,int val){
        if(cur == null) {
        	root = new node(val);
        	return;
        }
        if(cur.val > val && cur.left == null){
        	cur.left = new node(val);
            return;
        }
        if(cur.val < val && cur.right == null){
        	cur.right = new node(val);
            return;
        }
        if(cur.left!=null && cur.val > val) insert(cur.left,val);
        if(cur.right!=null && cur.val < val) insert(cur.right,val);

    }
    
    public void preorder(node root) {
    	if(root == null) return;
    	System.out.println(root.val);
    	preorder(root.left);
    	preorder(root.right);
    }
    
    public void levelorder(node root) {
    	Queue<node> queue = new LinkedList<>();
    	
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {
    		node cur = queue.poll();
    		System.out.println(cur.val);
    		if(cur.left !=null) queue.add(cur.left);
    		if(cur.right != null) queue.add(cur.right);
    	}
    	
    }
    
    public void postorder(node root) {
    	if(root == null) return;
    	postorder(root.left);
    	postorder(root.right);
    	System.out.println(root.val);
    }

	
	public static void main(String[] args) {
		BinarySearchTree s = new BinarySearchTree();
		s.insert(s.root, 50);
		s.insert(s.root, 30);
		s.insert(s.root, 20);
		s.insert(s.root, 40);
		s.insert(s.root, 70);
		s.insert(s.root, 60);
		s.insert(s.root, 80);
		
		
		s.levelorder(s.root);

	}
	
}
