/**
 * CS 2103 2018 B-term (Whitehill)
 * A data provider that associates keys with values.
 */
interface DataProvider<KeyType, ValueType> {
	/**
	 * Returns the value associated with the specified key.
	 * @param key the key
	 * @return the value associated with the key
	 */
	ValueType get (KeyType key);
}
