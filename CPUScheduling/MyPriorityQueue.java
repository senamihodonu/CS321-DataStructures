/**
 * MyPriorityQueue.java extends the MaxHeap class to provide a priority queue
 * and implements the PriorityQueueInterface.
 * 
 * @author Senami H.
 *
 */
public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {

	/**
	 * Adds a Process to the end of queue, then organizes by priority
	 * 
	 * @param p
	 */
	public void enqueue(Process p) {
		super.maxHeapInsert(p);
	}

	/**
	 * Get the process with the max priority
	 * 
	 * @return the process with the max priority
	 */
	public Process dequeue() {
		return super.heapExtractMax();
	}

	/**
	 * Determines if queue is empty or not
	 * 
	 * @return True if heap is empty, false otherwise
	 */
	public boolean isEmpty() {
		return super.getSize() == 0;
	}

	/**
	 * Updates the priority levels of all processes in the heap
	 * 
	 * @param next
	 * @param timeToIncrementPriority
	 * @param maxPriority
	 */
	public void update(Process next, int timeToIncrementPriority, int maxPriority) {
		if (super.getSize() != 0) {
			for (int i = 0; i < super.getSize(); i++) {
				next = super.getHeap()[i];
				next.incrementWaitingTime();

				if (next.getWaitingTime() >= timeToIncrementPriority) {
					next.resetWaitingTime();
					if (next.getPriority() < maxPriority) {
						next.incrementPriorityLevel();
						try {
							heapIncreaseKey(i, next);

						} catch (HeapException e) {

							e.printStackTrace();
						}

					}
				}

			}
		}
	}
}
