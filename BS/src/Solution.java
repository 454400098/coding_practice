
public class Solution {
	public static boolean bs(int[] a,int target,int l, int r) {
		int m = (l+r)/2;
		if(a[m] == target) return true;
		if(l==m || r == m) return false;
		if(a[m] > target) return bs(a,target,l,m);
		else return bs(a,target,m+1,r);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		
		System.out.print(bs(a,7,0,a.length-1));
	}
}
