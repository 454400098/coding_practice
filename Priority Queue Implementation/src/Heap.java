import java.util.*;
@SuppressWarnings("unchecked")
public class Heap<AnyType extends Comparable<AnyType>> {
	private static final int CAPACITY = 2;
	
	private int size;    //Number of elements in heap;
	private AnyType[] heap;	//The heap array
	
	
	
	public Heap() {
		size = 0;
		heap = (AnyType[]) new Comparable[CAPACITY];
	}
	
	
	//Construct the binary heap given an arraya of items
	public Heap(AnyType[] array) {
		size = array.length;
		heap = (AnyType[]) new Comparable[array.length + 1] ;
		System.arraycopy(array, 0,heap,1,array.length); // do not use 0 index
		
		buildHeap();
	}
	
	// run at O (size)
	
	
	private void buildHeap() {
		for(int k = size/2; k > 0; k--) {
			percolatingDown(k);
		}
	}
	private void percolatingDown(int k) {
		AnyType tmp = heap[k]; 
		int child;
		
		for(; 2*k <=size; k = child) {
			child = 2*k;
			if(child!= size && heap[child].compareTo(heap[child+1]) > 0) child++;
			if(tmp.compareTo(heap[child]) > 0) heap[k] = heap[child];
			else
				break;
		}
		
		heap[k] = tmp;
	}
	
	// Sorts a given array of items
	public void heapSort(AnyType[] array) {
		size = array.length;
		heap = (AnyType[]) new Comparable[size + 1];
		System.arraycopy(array, 0, heap, 1, size);
		buildHeap();
		
		for(int i = size; i > 0; i--) {
			AnyType tmp = heap[i]; //move top itm to end of heap array  //delete min
			heap[i] = heap[1];
			heap[1] = tmp;
			size--;
			percolatingDown(1);
		}
		
		
		for(int k = 0; k < heap.length-1; k++) {
			array[k] = heap[heap.length -1 -k];
		}
		
	}
	
	
	// delete top itm
	public AnyType deleteMin() throws RuntimeException
	{
		if(size == 0) throw new RuntimeException();
		AnyType min = heap[1];
		heap[1] = heap[size--];
		percolatingDown(1);  // this is actually bubble down dpv p116 steps g - h
		return min;
	}
	
	//Inserts a new item   --- bubble up
	public void insert(AnyType x) {
		if(size == heap.length -1) doubleSize();
		
		//Insert a new item to end of the array
		int pos = ++size;
		//Percolate up
		for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2)
			heap[pos] = heap[pos/2];
		
		heap[pos] = x;
	}
	
	private void doubleSize() {
		AnyType[] old = heap;
		heap = (AnyType []) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}
	
	public String toString() {
		String out = "";
		for(int k = 0; k <=size; k++) out+=heap[k]+" ";
		return out;
	}
	
	public static void main(String[] args) {
		Heap<String> h = new Heap<String> ();
		h.insert("p");
		h.insert("r");
		h.insert("i");
		h.insert("o");
		System.out.println(h);
		h.deleteMin();
		System.out.println(h);
		
		Heap<Integer> tmp = new Heap<Integer> ();
		Integer[] a = {4,7,7,7,5,0,2,3,5,1};
		
		for(int i = 0; i < a.length; i++) {
			tmp.insert(a[i]);
		}
		System.out.println(tmp);
		tmp.deleteMin();
		System.out.println(tmp);
		tmp.deleteMin();
		System.out.println(tmp);
	}
	
	
}
