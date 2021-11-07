import java.util.Random;

/**
 * Randomly generates processes with a given probability. At beginning 
 * of each time unit, whether a process will arrive is decided by the 
 * given probability. In addition, while generating a new process, both 
 * its priority and the required time units to finish the process are 
 * randomly generated within given ranges.
 * 
 * @author Senami H.
 */
public class ProcessGenerator implements ProcessGeneratorInterface {

	private double probability;
	private Random rand;

	/**
	 * Constructor to generates processes with a given probability
	 * 
	 * @param probability
	 */
	public ProcessGenerator(double probability) {
		this.probability = probability;
		this.rand = new Random();
	}

	/**
	 * Constructor to generates processes with a given probability with a random
	 * seed
	 * 
	 * @param probability
	 * @param randomSeed
	 */
	public ProcessGenerator(double probability, long randomSeed) {
		this.probability = probability;
		this.rand = new Random(randomSeed);

	}

	@Override
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority) {

		maxPriority = rand.nextInt(maxPriority) + 1;
		maxProcessTime = rand.nextInt(maxProcessTime) + 1;
		Process process = new Process(currentTime, maxProcessTime, maxPriority);

		return process;

	}

	@Override
	public boolean query() {
		return (rand.nextDouble() < probability);
	}

}
