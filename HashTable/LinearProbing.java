/**
 * Linear probing hash table implementation
 * 
 * @author Senami H.
 * @param <T>
 *
 */
public class LinearProbing<T> extends HashTable<T> {

	/**
	 * Linear Probing constructor
	 * 
	 * @param loadFactor
	 */
	public LinearProbing(double loadFactor) {
		super(loadFactor);

	}

	/**
	 * HASH-INSERT(T,k) -- linear probing implementation uses a hash function of the
	 * form h(k,i) = (h1(k) + i)) mod m
	 * 
	 * @param hashObject
	 */
	public int linearProbing(T hashObject) {
		return super.hashInsert(hashObject);
	}
}
