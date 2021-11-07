
/**
 * 
 * Process.java defines a process. Each process has a priority 
 * level, time remaining to finish,arrival time, and waiting time. 
 * The Process class should implement the ProcessInterface and the 
 * Comparable interface.
 * 
 * @author Senami H.
 * @param <Process>
 *
 */
public class Process implements ProcessInterface, Comparable<Process> {

	private int priorityLevel;
	private int arrivalTime, waitingTime, timeRemaining;

	/**
	 * Constructor to create a process.
	 * 
	 * @param currentTime
	 * @param requiredProcessTime
	 * @param maxPriority
	 */
	public Process(int currentTime, int requiredProcessTime, int maxPriority) {
		this.arrivalTime = currentTime;
		this.priorityLevel = maxPriority;
		this.timeRemaining = requiredProcessTime;
		this.waitingTime = 0;
	}

	/**
	 * Returns the priority of the process.
	 * 
	 * @return The priority
	 */
	public int getPriority() {
		return priorityLevel;
	}

	/**
	 * Sets the priority of the process.
	 * 
	 * @param priority
	 */
	public void setPriority(int priority) {
		this.priorityLevel = priority;
	}

	/**
	 * Returns the time remaining to finish the process.
	 * 
	 * @return timeRemaining
	 */
	public int getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Decrements the time remaining to process.
	 */
	public void decrementTimeRemaining() {
		timeRemaining--;

	}

	/**
	 * Returns whether the job is finished or not.
	 * 
	 * @return True if the time remaining is 0, false otherwise
	 */
	public boolean finished() {
		return timeRemaining == 0;

	}

	/**
	 * Returns the process arrival time
	 * 
	 * @return arrivalTime
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * Returns the waiting time.
	 * 
	 * @return waitingTime
	 */
	public int getWaitingTime() {
		return waitingTime;
	}

	/**
	 * Increments the waiting time.
	 */
	public void incrementWaitingTime() {
		waitingTime++;
	}

	/**
	 * Resets the waiting time to 0.
	 */
	public void resetWaitingTime() {
		waitingTime = 0;
	}

	/**
	 * Increments the priority level.
	 */
	public void incrementPriorityLevel() {
		priorityLevel++;
	}

	/**
	 * Compares the priority levels of different processes to determine 
	 * which priority is greater
	 */
	public int compareTo(Process anotherProcess) {
		int retVal = 0; //return value

		if (priorityLevel > anotherProcess.getPriority()) {
			retVal = 1;
		} else if (priorityLevel < anotherProcess.getPriority()) {
			retVal = -1;
		} else {
			// The process with the lower arrivalTime is greater.
			if (getArrivalTime() < anotherProcess.getArrivalTime()) {
				retVal = 1;
			} else if (getArrivalTime() > anotherProcess.getArrivalTime()) {
				retVal = -1;
			}
		}

		return retVal;
	}

}