/**
 * Class for generating smallest twin primes in a given range.
 * 
 * @author Senami H.
 */
public class TwinPrimeGenerator {

	/* Instance Variable */
	private static int tableSize; // table size, m

	/**
	 * Smallest twin prime generation within a range
	 * 
	 * @param min -- minimum value of range
	 * @param max -- maximum value of range
	 */
	public TwinPrimeGenerator(int min, int max) {
		int i = min;
		boolean flag = false;

		while (flag == false && (i <= max)) {
			if (isPrime(i) && isPrime(i - 2)) {
				if (i >= min) {
					tableSize = i;
					flag = true;
				}
			}
			i++;
		}
	}

	/**
	 * Check if a given integer is prime
	 * 
	 * @param number
	 * @return true, if integer is prime
	 */
	public static boolean isPrime(int number) {
		// corner case check
		if (number <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns Twin prime table size within a given range
	 * 
	 * @return tableSize
	 */
	public int getTwinPrimeTableSize() {
		return tableSize;
	}

	/**
	 * toString method to print out the smallest twin primes generated
	 * 
	 * @return generated twin primes
	 */
	public String toString() {
		return "The smallest twin primes: m = " + tableSize + ", m - 2 = " + (tableSize - 2);
	}

}

//https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/