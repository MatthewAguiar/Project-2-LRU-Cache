
import java.util.HashMap;
import java.util.Map;

public class VirtualDatabase<KeyType, ValueType> implements DataProvider<KeyType, ValueType> 
{
	
	private HashMap<KeyType, ValueType> _data = new HashMap<KeyType, ValueType>();
	
	public VirtualDatabase()
	{
		_data.put("smurf", "smurf.png");
		_data.put("sonic", "sonic.py");
		_data.put("pikachu", "pikachu.cpp");
	}
	
	public ValueType get(KeyType key)
	{
		return _data.get(key);
	}
}