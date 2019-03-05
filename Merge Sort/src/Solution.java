import java.util.Arrays;

public class Solution {
	
	public  static void sort(int[] arr,int l, int r) {
		// find middle point to divide the array
		if(l < r) {
			//find middle point 
			int m = (l+r)/2;
			
			//sort first and second havls;
			sort(arr,l,m);
			sort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	
	
	// meres two subarrays of arr[]
	
	private static void merge(int[]arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int L[] = new int [n1];
		int R[] = new int [n2];
		
		// copy data to tmp array
		for(int i = 0; i < n1; i ++ ) {
			L[i] = arr[l + i];
		}
		for(int j = 0; j < n2; j ++ ) {
			R[j] = arr[m + 1 + j];
		}
		
		//merge two array
		int i = 0, j = 0;
		
		//initial index = merge two array
		int k = l;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		//copy remainng elements to array
		while( i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {3,5,14,45,126,6,31};
		
		sort(a,0,a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}
