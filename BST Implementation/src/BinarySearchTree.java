
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
	

	
	public static void main(String[] args) {
		BinarySearchTree s = new BinarySearchTree();
		s.root = new node(8);
		s.root.left = new node(3);
        s.root.right = new node(10);
        s.root.left.left = new node(1);
        s.root.left.right = new node(6);
        s.root.left.right.left = new node(4);
        s.root.left.right.right = new node(7);
        s.root.right.right = new node(14);
        s.root.right.right.left = new node(13);
        
        if(s.Search(s.root, 13)==null) {
        	System.out.println("not found");
        }else {
        	System.out.println("found key");
        }
		
	}
	
}
