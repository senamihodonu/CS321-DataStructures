/**
 * HashObject setup for hash table.
 * @author Senami H.
 *
 */
public class HashObject<T> {
	
	/*Instance variable*/
	private int frequencyCount, //keeps track of the duplicates in the array
	probeCount; //keeps track of the number of probes needed for insertion
	private T key; //generic key object
	
	/**
	 * HashObject constructor
	 * @param key
	 */
	public HashObject(T key) {
		this.frequencyCount = 0;
		this.probeCount = 0;
		this.key = key;
	}
	
	/**
	 * Return the key of an object
	 * @return key
	 */
	public T getKey() {
		return key;	
	}
	
	/**
	 * Returns the number of probes for the objects to be inserted
	 * @return probeCount
	 */
	public int getProbeCount() {
		return probeCount;
	}
	
	/**
	 * Sets the probe count
	 */
	public void setProbeCount(int probeCount) {
		this.probeCount = probeCount;
	}
	
	
	/**
	 * Returns the frequency count of an object in the list
	 * @return frequencyCount
	 */
	public int getFrequencyCount() {
		return frequencyCount;
	}
	
	/**
	 * Increments the frequency count
	 * @return frequencyCount + 1
	 */
	public int incrementFrequencyCount() {
		return frequencyCount++;
	}
	
	/**
	 * String representation of the inserted key, the frequency count
	 * and probeCount
	 */
	@Override
	public String toString() {
		return key + " " + frequencyCount + " " + probeCount ;	
	}
	
	/**
	 * This method checks if some other Object passed to it as an 
	 * argument is equal to the Object on which it is invoked.
	 * @return true if equal, else returns false
	 */
	@Override
	public boolean equals(Object value){
		if(this.getKey().equals(value)){
			return true;
		}else{
			return false;
		}
	}


}