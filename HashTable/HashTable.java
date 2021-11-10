import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

/**
 * HashTable abstract class of HashObject for linear probing and for double
 * hashing. Contains the common hash table functionalities.
 * 
 * @author Senami H.
 * @param <T>
 *
 */
public abstract class HashTable<T> {

	/* Instance Variables */
	protected T key; // keys to be inserted
	protected int index; // index at which key is inserted
	protected int numProbes; // number of probes for a insertion
	protected int numKeysInserted; // number of keys being inserted into a hash table.
	protected int duplicates; // number of duplicates
	protected int tableSize; // hash table size m.
	protected HashObject<T>[] hashTable; // array of HashObject
	protected int hashOne; // primary hash value
	protected int hashTwo; // secondary hash value
	protected double loadFactor; // ratio of the number of keys to the table size
	private final int RANGE_MAX = 96000; // maximum of given range
	private final int RANGE_MIN = 95500; // minimum of given range
	private TwinPrimeGenerator twinPrime = new TwinPrimeGenerator(RANGE_MIN, RANGE_MAX); // generates the table size
	protected boolean doubleHashing = false; // flag to check if double hashing

	/**
	 * HashTable constructor
	 * 
	 * @param loadFactor
	 */
	@SuppressWarnings("unchecked")
	public HashTable(double loadFactor) {
		this.loadFactor = loadFactor;
		tableSize = twinPrime.getTwinPrimeTableSize();
		hashTable = new HashObject[tableSize];
		index = 0;
	}

	/**
	 * Inserting n keys into a hash table of size m. The load factor defined to be
	 * n/m. For open addressing n >= m, which implies that 0 <= load factor <= 1.
	 * 
	 * @return loadFactor
	 */
	public double getLoadFactor() {
		return (double) numKeysInserted / tableSize;
	}

	/**
	 * Returns the number of non duplicated inserts
	 * 
	 * @return numKeysInserted
	 */
	public int getNumOfInsert() {
		return numKeysInserted;
	}

	/**
	 * Returns the total of non duplicated inserts and duplicates
	 * 
	 * @return totalElements
	 */
	public int getTotalElements() {
		return numKeysInserted + duplicates;
	}

	/**
	 * Returns the hash table size
	 * 
	 * @return tableSize
	 */
	public int getSize() {
		return tableSize;
	}

	/**
	 * Computation of the primary hash value
	 * 
	 * @return hashOne -- primary hash value
	 */
	public int getHashOne(T key) {
		return positiveMod(key.hashCode(), tableSize);
	}

	/**
	 * Computation of the secondary hash value
	 * 
	 * @return hashTwo -- secondary hash value
	 */
	public int getHashTwo(T key) {
		return 1 + positiveMod(key.hashCode(), tableSize - 2);
	}

	/**
	 * Returns number of probes
	 * 
	 * @return the numProbes
	 */
	public int getNumProbes() {
		return numProbes;
	}

	/**
	 * Returns the average number of probes
	 * 
	 * @return aveNumProbes
	 */
	public double avgNumProbes() {
		return (double) numProbes / numKeysInserted;
	}

	/**
	 * Clears all the content of hash table
	 */
	public void clear() {
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = null;
		}

	}

	/**
	 * Helper function to ensure the mod operation in the probing calculation always
	 * returns positive integers.
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	protected int positiveMod(int dividend, int divisor) {
		int value = dividend % divisor;
		if (value < 0)
			value += divisor;
		return value;
	}

	/**
	 * The number of duplicates
	 * 
	 * @return duplicates
	 */
	public int getDuplicates() {
		return duplicates;
	}

	/**
	 * Returns the string representation of the number of duplicates and the number
	 * of probes
	 */
	@Override
	public String toString() {
		return getDuplicates() + " " + getNumProbes();
	}

	/**
	 * HASH-INSERT(T,k) function of the form h(k,i) = (h1(k) + i*h2(k))) mod m
	 * 
	 * @param index
	 */
	@SuppressWarnings("null")
	public int hashInsert(T hashObject) {
		int i = 0;
		int index = 0;

		int h1 = getHashOne(hashObject); // primary hash value
		int h2 = 1; // The secondary hash value is not applicable for Linear Probing
					// This is included for program simplicity
		if (doubleHashing) {
			h2 = getHashTwo(hashObject);
		}

		while (i < tableSize) {
			index = (h1 + i * h2) % tableSize;

			if (hashTable[index] != null && hashTable[index].equals(hashObject)) {
				hashTable[index].incrementFrequencyCount();
				duplicates++;
				return index;

			} else if (hashTable[index] == null) {

				hashTable[index] = new HashObject<T>(hashObject);
				hashTable[index].setProbeCount(i + 1);
				numKeysInserted++;
				numProbes += (i + 1);
				return index;
			}
			i++;

		}
		return (Integer) null;
	}

	/**
	 * File dump method
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void dump(String fileName) throws FileNotFoundException {
		PrintStream ps = new PrintStream(new File(fileName));
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				ps.append("table[" + String.valueOf(i) + "]: " + hashTable[i].toString());
				ps.append("\n");
			}
		}
		System.setOut(ps);
		ps.close();
	}

}
