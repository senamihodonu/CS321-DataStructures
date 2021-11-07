/**
 * Runs a set of basic tests for the MaxHeap class
 * 
 * @author Senami H.
 */
public class MaxHeapTest {

	// total test count
	private static int totalTests = 0;

	// instance variables for tracking test results
	private static int passes = 0;
	private static int failures = 0;
	private static int total = 0;

	public static void main(String[] args) throws HeapException {
		System.out.println("--------------------Basic Tests--------------------");

		// methods to be tested
		testHeapInsert();
		testMaxHeapify();
		testExtractMax();
		testGetSizeEmpty();
		testGetSizeOneItem();
		testGetSizeThreeItems();

		// report final verdict
		printLine();
		printFinalSummary();
	}

	/**
	 * Run tests to confirm required functionality of the maxHeapInsert
	 * implementation
	 */
	public static void testHeapInsert() {
		total++;
		totalTests++;
		System.out.print("maxHeapInsert");
		Process p0 = new Process(1, 1, 2);
		Process p1 = new Process(1, 2, 1);
		Process p2 = new Process(1, 1, 0);

		MaxHeap maxHeap = new MaxHeap();

		maxHeap.maxHeapInsert(p0);
		maxHeap.maxHeapInsert(p1);
		maxHeap.maxHeapInsert(p2);

		if (maxHeap.getHeap()[0] != null) {
			if (maxHeap.getHeap()[1] != null) {
				if (maxHeap.getHeap()[2] != null) {
					if (maxHeap.getHeap()[3] == null) {
						System.out.println("                      PASS");
						passes++;
					}
				}
			}

		} else {
			System.out.println("                       FAIL");
			failures++;
		}
	}

	/**
	 * Run tests to confirm required functionality of the maxHeapify implementation
	 */
	public static void testMaxHeapify() {
		total++;
		totalTests++;
		System.out.print("maxHeapify");
		Process p0 = new Process(1, 1, 2);
		Process p1 = new Process(1, 2, 1);
		Process p2 = new Process(1, 1, 0);

		MaxHeap maxHeap = new MaxHeap();

		maxHeap.maxHeapInsert(p0);
		maxHeap.maxHeapInsert(p1);
		maxHeap.maxHeapInsert(p2);

		maxHeap.getHeap();
		Process firstProcess = maxHeap.getHeap()[0];
		Process secondProcess = maxHeap.getHeap()[1];
		Process thirdProcess = maxHeap.getHeap()[2];

		if (firstProcess.compareTo(secondProcess) > 0) {
			if (secondProcess.compareTo(thirdProcess) >= 0) {
				if (firstProcess.compareTo(thirdProcess) > 0) {
					System.out.println("                         PASS");
					passes++;
				}
			}
		} else {
			System.out.println("                          FAIL");
			failures++;
		}
	}

	/**
	 * Testing the implementation of the heapExtractMax method
	 */
	public static void testExtractMax() {
		total++;
		totalTests++;
		System.out.print("heapExtractMax");
		Process p0 = new Process(1, 1, 2);
		Process p1 = new Process(1, 2, 1);
		Process p2 = new Process(1, 1, 0);

		MaxHeap maxHeap = new MaxHeap();

		maxHeap.maxHeapInsert(p0);
		maxHeap.maxHeapInsert(p1);
		maxHeap.maxHeapInsert(p2);

		Process max = p0;

		if (max.equals(maxHeap.heapExtractMax())) {
			System.out.println("                     PASS");
			passes++;
		} else {
			System.out.println("                      FAIL");
			failures++;
		}

	}

	/**
	 * Testing the implementation of the getSize() method with 0 processes
	 */
	public static void testGetSizeEmpty() {
		total++;
		totalTests++;
		System.out.print("getSize (with 0 processes)");

		MaxHeap maxHeap = new MaxHeap();

		if (maxHeap.getSize() == 0) {
			System.out.println("         PASS");
			passes++;
		} else {
			System.out.println("          FAIL");
			failures++;
		}

	}

	/**
	 * Testing the implementation of the getSize() method with 1 process
	 */
	public static void testGetSizeOneItem() {
		total++;
		totalTests++;
		System.out.print("getSize (with 1 process)");
		Process p0 = new Process(1, 1, 2);

		MaxHeap maxHeap = new MaxHeap();

		maxHeap.maxHeapInsert(p0);

		if (maxHeap.getSize() == 1) {
			System.out.println("           PASS");
			passes++;
		} else {
			System.out.println("            FAIL");
			failures++;
		}

	}

	/**
	 * Testing the implementation of the getSize() method with 3 processes
	 */
	public static void testGetSizeThreeItems() {
		total++;
		totalTests++;
		System.out.print("getSize (with 3 processes)");
		Process p0 = new Process(1, 1, 2);
		Process p1 = new Process(1, 2, 1);
		Process p2 = new Process(1, 1, 0);

		MaxHeap maxHeap = new MaxHeap();

		maxHeap.maxHeapInsert(p0);
		maxHeap.maxHeapInsert(p1);
		maxHeap.maxHeapInsert(p2);

		if (maxHeap.getSize() == 3) {
			System.out.println("         PASS");
			passes++;
		} else {
			System.out.println("          FAIL");
			failures++;
		}

	}

	/**
	 * Print a final summary
	 */
	private static void printFinalSummary() {
		System.out.printf("\nTotal Tests Run: %d of %d,  Passed: %d,  " + "Failed: %d\n", total, totalTests, passes,
				failures);
	}

	/**
	 * Prints line between sets of tests
	 */
	private static void printLine() {
		System.out.println("===================================================");

	}

}
