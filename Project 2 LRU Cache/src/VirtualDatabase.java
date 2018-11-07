import java.util.HashMap;

public class VirtualDatabase<KeyType, ValueType> implements DataProvider<KeyType, ValueType>
{

    private HashMap<KeyType, ValueType> _data = new HashMap<KeyType, ValueType>();

    /**
     * Constructor:
     * @param data contains key and the associated value
     */

    public VirtualDatabase(HashMap<KeyType, ValueType> data)
    {
        _data = data;
    }
    /************************************************************************************************************************************************
     * Public Methods:
     ************************************************************************************************************************************************/
    /**
     * Returns the associated value to where it was called
     * @param key the key
     * @return the associated value to where it was called
     */

    public ValueType get(KeyType key)
    {
        return _data.get(key);
    }
}