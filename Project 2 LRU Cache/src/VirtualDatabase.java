
import java.util.HashMap;

public class VirtualDatabase<KeyType, ValueType> implements DataProvider<KeyType, ValueType> 
{
	
	private HashMap<KeyType, ValueType> _data = new HashMap<KeyType, ValueType>();
	
	public VirtualDatabase()
	{
	}
	/************************************************************************************************************************************************
	 * Public Methods:
	 ************************************************************************************************************************************************/
	public ValueType get(KeyType key)
	{
		return _data.get(key);
	}
}
