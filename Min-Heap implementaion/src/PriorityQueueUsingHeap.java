
public class PriorityQueueUsingHeap<T extends Comparable<T>> {
	T[] arr;
	int N;
	
	public PriorityQueueUsingHeap() {
		arr = (T[]) new Comparable[2];
		N = 0;
	}
	
	
	public void insert(T t) {
		if(N == arr.length - 1)resize(2*N+1);
		arr[++N] = t;
		bubbleup(N);
	}
	
	
	private void resize(int capacity) {
		// input is the initial size
		T[] arr_new =(T[]) new Comparable[capacity];
		for(int i = 1; i <=N ;i++ ) {
			arr_new[i]  = arr[i];
		}
		arr = arr_new;
	}
	
	
	private boolean less(int i, int j) {
		return arr[i].compareTo(arr[j]) > 0;
	}
	
	public void bubbleup(int i ) {
		// if value in parent smllaer than cur / swap up
		if(i>1 && less(i/2,i)) {
			swap(i,i/2);
			bubbleup(i/2);
		}
		return;
	}
	
	
	public void sink(int i) {
//		if(i >= N/2) return;
//		T min  = arr[i];
//		int min_index =i;
//		if(2*i <= N && less(2*i,i)) {
//			min = arr[2*i];
//			min_index = 2*i;
//		}
//		if(2*1 + 1 <= N && less(2*i+1,2*i)) {
//			min = arr[2*i+1];
//			min_index = 2*i+1;
//		}
//		swap(i,min_index);
//		sink(min_index);
		while(2 * i < N) {
			int j = 2 * i;
			if(j < N && less(j,i)) j +=1;
			//if no one of child is less than parent break
			if(less(j,i)) break; //no one is less than its parent
			swap(i,j);
			i = j;
		}
	}
	
	public void swap(int i, int j) {
		T tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}
	// N is the last index in array
	public T delmin() {
		if(isEmpty()) return null;
		T min = arr[1];
		swap(1,N--);
		arr[N+1] = null;  // I omit the steps to null last one
		sink(1);
		// this is the place mistake happens
//		if(N <= (arr.length-1)/2) {
//			resize(N/2+1);
//		}
		if(N == (arr.length -1 ) /4) resize((arr.length-1)/2 + 1);
//		// this is the place mistake happens
		
		return min;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= N; i++) {
			sb.append(arr[i].toString() + " ");
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		PriorityQueueUsingHeap<Integer> minheap = new PriorityQueueUsingHeap<Integer>();
		minheap.insert(1);
		minheap.insert(2);
		minheap.insert(3);
		minheap.insert(3);
		minheap.insert(3);
		minheap.insert(3);
		minheap.insert(3);
		System.out.println(minheap);
		minheap.delmin();
		
		System.out.print(minheap);
	}
}
