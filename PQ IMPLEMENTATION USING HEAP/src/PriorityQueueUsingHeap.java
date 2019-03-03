
public class PriorityQueueUsingHeap <T extends Comparable<T>>{
	T[] arr;
	int N;
	
	
	public PriorityQueueUsingHeap() {
		arr = (T[]) new Comparable[2];
		N = 0;
	}
	
	public void inser(T t) {
		if(N == arr.length -1) resize(2*N +1);
		arr[++N] = t;
		swim(N);
	}
	
	private void resize(int capacity) {
		T[] copy = (T[]) new Comparable [capacity];
		for(int i = 1; i <= N; i++) {
			copy[i] = arr[i];
		}
		arr = copy;
	}
	
	
	
}
