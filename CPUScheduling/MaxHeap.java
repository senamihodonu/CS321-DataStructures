import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * MaxHeap class of processes implemented using an array
 * 
 * @author Senami H.
 *
 */
public class MaxHeap {

	private Process[] heap; // heap array of processes
	private int size; // size of maxHeap
	private final int INITIAL_CAPACITY = 100; // starting capacity of heap array

	/**
	 * MaxHeap constructor Sets the initial capacity of the heap to 100 and the heap
	 * size to 0
	 */
	public MaxHeap() {
		this.size = 0;
		this.heap = new Process[INITIAL_CAPACITY];
	}

	/**
	 * Returns the size of the heap
	 * 
	 * @return size of heap
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns the position of parent
	 * 
	 * @param childIndex
	 * @return
	 */
	public int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	/**
	 * Returns the position of left children
	 * 
	 * @param childIndex
	 * @return
	 */
	public int getLeftIndex(int parentIndex) {
		return (2 * parentIndex) + 1;
	}

	/**
	 * Returns the position of right children
	 * 
	 * @param childIndex
	 * @return
	 */
	public int getRightIndex(int parentIndex) {
		return (2 * parentIndex) + 2;
	}

	/**
	 * Swapping nodes
	 * 
	 * @param processOne
	 * @param processTwo
	 */
	public void exchange(int processOne, int processTwo) {
		Process temp = heap[processOne];
		heap[processOne] = heap[processTwo];
		heap[processTwo] = temp;
	}

	/**
	 * Sorts the heap array into a MaxHeap tree structure, meaning the left and
	 * right child are always less than the parent. (Heapification downward)
	 * 
	 * @param heapIndex
	 */
	public void maxHeapify(int heapIndex) {
		int largest = heapIndex;
		int leftIndex = getLeftIndex(heapIndex);
		int rightIndex = getRightIndex(heapIndex);

		if (leftIndex < size && (heap[leftIndex].compareTo(heap[heapIndex]) > 0)) {
			largest = leftIndex;
		} else {
			largest = heapIndex;
		}

		if (rightIndex < size && (heap[rightIndex].compareTo(heap[largest]) > 0)) {
			largest = rightIndex;
		}

		if (largest != heapIndex) {
			exchange(heapIndex, largest);
			maxHeapify(largest);
		}

	}

	/**
	 * BUILD-MAX-HEAP goes through the remaining nodes of the tree and runs
	 * MAX-HEAPIFY on each one.
	 */
	public void buildMaxHeap() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			maxHeapify(i);
		}
	}

	/**
	 * the heapsort algorithm
	 */
	public void heapSort() {
		buildMaxHeap();

		for (int i = size / 2 - 1; i >= 0; i--) {
			maxHeapify(i);
			exchange(0, i);
			maxHeapify(i);
		}

	}

	/**
	 * Removes the highest process from the heap and restores the heap condition. If
	 * the heap is empty, this method should throw a NoSuchElementException
	 * 
	 * @return the highest process from the heap
	 * @throws NoSuchElementException if called on a empty heap
	 */
	public Process heapExtractMax() {
		if (size < 1) {
			throw new NoSuchElementException("heap underflow");
		}

		Process max = heap[0];
		heap[0] = heap[size - 1];
		size--;
		maxHeapify(0);

		return max;
	}

	/**
	 * HEAP-INCREASE-KEY implements the INCREASE-KEY operation
	 * 
	 * @param i
	 * @param process
	 * @throws HeapException
	 */
	public void heapIncreaseKey(int i, Process process) throws HeapException {

		try {
			if (process.compareTo(heap[i]) < 0) {
				throw new HeapException("new process is smaller");
			}

			heap[i] = process;
			while (i > 0 && (heap[getParentIndex(i)].compareTo(heap[i])) < 0) {
				exchange(i, getParentIndex(i));
				i = getParentIndex(i);

			}
		} catch (HeapException e) {
			System.err.println("new process is smaller");
		}

	}

	/**
	 * Inserts a Process object into the heap and sorts it into the correct index
	 * 
	 * @param newProcess
	 */
	public void maxHeapInsert(Process newProcess) {
		Process minProcess = new Process(0, 0, Integer.MIN_VALUE); // Process with the least possible priority
		ensureCapacity();
		heap[size] = minProcess;
		size++;
		try {
			heapIncreaseKey(size - 1, newProcess);
		} catch (HeapException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Doubles the size of heap array when heap capacity reached.
	 */
	private void ensureCapacity() {
		if (size == heap.length) {
			heap = Arrays.copyOf(heap, heap.length * 2);
		}
	}

	/**
	 * Returns heap.
	 * 
	 * @return heap
	 */
	public Process[] getHeap() {
		return heap;
	}
 
 	

}
