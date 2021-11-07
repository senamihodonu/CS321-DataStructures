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
	 * @param Object
	 */
	public HashObject(T key) {
		this.frequencyCount = 0;
		this.probeCount = 0;
		this.key = key;
	}
	
	/**
	 * Return the key of an object
	 * @return the key
	 */
	public T getKey() {
		return key;	
	}
	
	/**
	 * Returns the number of probes for the objects to be inserted
	 * @return number of probes
	 */
	public int getProbeCount() {
		return probeCount;
	}
	
	/**
	 * increments the probe count
	 * @return probeCount + 1
	 */
	public void setProbeCount(int probeCount) {
		this.probeCount = probeCount;
	}
	
	
	/**
	 * Returns the frequency count of an object in the list
	 * @return the frequency count
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
	
	@Override
	public String toString() {
		return key + " " + frequencyCount + " " + probeCount;	
	}
	
	/**
	 * This method checks if some other Object passed to it as an 
	 * argument is equal to the Object on which it is invoked.
	 * @return
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