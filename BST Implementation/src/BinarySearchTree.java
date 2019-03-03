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
    
    
    public void deletenode(int key) {
    	//node to be deleted is leaf -- remove
    	root = deleteRec(root,key);
    }
    
    node deleteRec(node root, int key) {
    	/*base case : if tree is empty*/
    	if(root == null) return root;
    	/*otherwise recurs down*/
    	if(key < root.val) {
    		root.left = deleteRec(root.left,key);
    	}
    	else if (key > root.val) {
    		root.right = deleteRec(root.right,key);
    	}
    	
        // if key is same as root's key, then This is the node 
        // to be deleted 
    	else {
    		if(root.left == null)
    			return root.right;
    		else if(root.right == null) {
    			return root.left;
    		}
    		
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
    		
    		root.val = minValue(root.right);
    		//Delete the inorder successor
    		root.right = deleteRec(root.right,root.val);
    	}
    	System.out.println("cur node is " + root.val);
    	return root;
    }
    
    int minValue(node root) {
    	int minv = root.val;
    	while(root.left!=null) {
    		minv = root.left.val;
    		root = root.left;
    	}
    	return minv;
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
//		s.levelorder(s.root);
		s.deletenode(50);
		System.out.println("after deletion");
		s.levelorder(s.root);

	}
	
}
