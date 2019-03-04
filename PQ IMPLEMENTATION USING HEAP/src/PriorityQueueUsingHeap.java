// max heap implementation
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
		swim(N);	//bubble up 
	}
	
	private void resize(int capacity) {
		T[] copy = (T[]) new Comparable[capacity];
		for(int i = 1; i <= N; i++) {
			copy[i] = arr[i];
		}
		arr = copy;
	}
	
	private void swim(int k) {
		while(k >1 && less(k/2,k)) {
			exch(k/2,k);
			k = k/2;
		}
	}
	
	
	private boolean isEmpty() {
		return N==0;
	}
	
	public T delMax() {
		if(isEmpty()) return null;
		T t = arr[1];
		exch(1,N--);
		arr[N+1] = null;
		sink(1);
		
		//resize array
		if(N == (arr.length -1)/4) resize((arr.length -1)/2 + 1);
		
		return t;
	}
	
	private void sink(int k) {
		// bottom down
		while(2*k < N) {
			// find the largest child
			int j = 2 * k;
			if(j < N && less(j, j + 1)) j = j+ 1;
			if(less(j,k)) break;
			exch (k,j);
			k = j;
		}
	}
	private void exch(int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	private boolean less(int i, int j) {
		if(arr[i].compareTo(arr[j]) <0)
			return true;
		else {
			return false;
		}
	}
	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1 ; i <= N; i++) {
			sb.append(arr[i].toString() + " ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		PriorityQueueUsingHeap<Integer> pq = new PriorityQueueUsingHeap<Integer>();
		pq.inser(1);
		pq.inser(2);
		pq.inser(3);
		pq.inser(4);
		
		pq.delMax();
		
		System.out.print(pq);
	}
	
}
