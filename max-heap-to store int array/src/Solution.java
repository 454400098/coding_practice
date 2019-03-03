
public class Solution {
	//coert array into heap structure
	
	private static void max_heapify(int Arr[], int i, int N) {
		int left = 2*i;    // left child
		int right = 2*i + 1;
		
		int largest = Integer.MIN_VALUE;
		if(left<= N && Arr[left] > Arr[i]) {
			largest = left;
//			if(i==3) {
//				System.out.println("!!!!");
//			}
		}else {
			largest = i;
		}
		if(right <= N && Arr[right] > Arr[largest]) {
			largest = right;
		}
		if(largest != i) {   // need to re do recusion
			
			int tmp  = Arr[largest];
			Arr[largest] = Arr[i];
			Arr[i] = tmp;
			

			max_heapify(Arr,largest,N);
		}
		

		
	}
	
	public static void build_maxheap(int Arr[] ) {
		int N = Arr.length + 1;
		System.out.println("N is " + N);
		int[] heap = new int[N];
		
		System.arraycopy(Arr, 0, heap, 1, Arr.length);
		
	
		N-=1;
		
		for(int i = N/2;i >=1; i--) {
			max_heapify(heap,i,N);
		}
		
		for (int j = 1 ; j < heap.length ; j++) {
			System.out.print(heap[j] + " ");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		int[] a= {1,4,3,7,8,9,10};
		build_maxheap(a);
	}
}
