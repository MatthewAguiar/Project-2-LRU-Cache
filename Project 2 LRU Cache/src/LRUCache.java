/**
 * An implementation of <tt>Cache</tt> that uses a least-recently-used (LRU)
 * eviction policy.
 */
public class LRUCache<KeyType, ValueType> implements Cache<KeyType, ValueType>
{
    private final int _capacity;
    private int _misses = 0;
    private final DataProvider<KeyType, ValueType> _provider;
    private final LinkedHashMap<KeyType, ValueType> _data = new LinkedHashMap<KeyType, ValueType>();



    public LRUCache (DataProvider<KeyType, ValueType> provider, int capacity)
    {
        /**
         * Constructor:
         * @param provider the data provider to consult for a cache miss
         * @param capacity the exact number of (key, value) pairs to store in the cache
         */
        _provider = provider;
        _capacity = capacity;
    }

    /************************************************************************************************************************************************
     * Private Methods:
     ************************************************************************************************************************************************/

    /**
     * Removes the key of the head of the list in the Cache
     */

    private void performEviction()
    {
        KeyType key = _data.getLRU().getHashKey();
        _data.remove(key);
    }

    /**
     * Sets key and inserts the associated value of the key from the DataProvider
     * @param key the key
     */

    private void insertFromProviderToCache(KeyType key)
    {
        _data.put(key, _provider.get(key));
    }

    /**
     * Returns a boolean value to see if the list size has reached the capacity limit
     * @return a boolean value to see if the list size has reached the capacity limit
     */

    private boolean atMaxCapacity()
    {
        return _data.size() == _capacity;
    }
    /************************************************************************************************************************************************
     * Public Methods:
     ************************************************************************************************************************************************/
    /**
     * Returns the value associated with the specified key. Also checks if the DataProvider interface has
     * the same key in the list. If the test is true, it would get both the key and the value in the list and then
     * replaces it with the current one that was passed in. If the key is not in the list, it would increment
     * _misses and checks if the list is at maximum capacity or not. If it is true, it would execute the eviction method
     * so it can make "space" for the newly inserted key and value into the list. If it is false, it would get the value
     * from the associated key and return that value.
     *
     * @param key the key
     * @return the value associated with the key
     */
    public ValueType get (KeyType key)
    {
        if(_data.containsKey(key))
        {
            ValueType value = _data.get(key).getValue();
            _data.remove(key);
            _data.put(key, value);
            return value;
        }
        else
        {
            _misses++;
            if(atMaxCapacity())
            {
                performEviction();
            }
            insertFromProviderToCache(key);
            return _provider.get(key);
        }
    }

    public int getNumMisses ()
    {
        /**
         * Returns the number of cache misses since the object's instantiation.
         * @return the number of cache misses since the object's instantiation.
         */
        return _misses;
    }
}
