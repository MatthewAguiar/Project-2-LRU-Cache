import java.util.HashMap;

/**
 * CS 2103 2018 B-term (Whitehill)
 * A cache that associates keys with values.
 */
interface Cache<KeyType, ValueType> extends DataProvider<KeyType, ValueType> {
	/**
	 * Returns the number of cache misses since the object's instantiation.
	 * @return the number of cache misses since the object's instantiation.
	 */
	int getNumMisses ();
}
