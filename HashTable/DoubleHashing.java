/**
 * Double hashing implementation
 * @author Senami H.
 *
 * @param <T>
 */
public class DoubleHashing<T> extends HashTable<T> {

	public DoubleHashing(double loadFactor) {
		super(loadFactor);
	}
	
	
	/**
	 * HASH-INSERT(T,k) -- double hashing implementation Double hashing uses a hash
	 * function of the form h(k,i) = (h1(k) + i*h2(k))) mod m
	 * 
	 * @param hashObject
	 */
	public int doubleHashingInsert(T hashObject) {
		doubleHashing = true;
		return super.hashInsert(hashObject);
	}

}


