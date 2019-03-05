package quick_sort;
//quick sort explanation
/*
 * 1. always pick first element as pivot
 * 2. always pick last element as pivot
 * 3. pic ka random elment as pivot
 * 4. pick median as pivot
 */

import java.util.Arrays;

public class Solution {
	
	public static void quickSort(int[] arr, int low,int  high) {
		if(low < high) {
			int pi = partition(arr,low,high);
			quickSort(arr,low,pi-1); //Before pi
			quickSort(arr,pi+1,high);
		}
	}
	
	
	static int partition(int[] arr, int low, int high) {
		// takes last elmenet as pivot
		int pivot = arr[high];
		int i = low - 1;   //index of smaller element??
		
		for(int j = low; j<= high-1; j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}
	
	private static void swap (int[]arr,int i ,int j ) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] a = {10,2,5,3,7,13,1,6};
		quickSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
