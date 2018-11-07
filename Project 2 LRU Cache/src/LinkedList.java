import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class LinkedList<Type>
{
	private Node<Type> _head, _tail;
	private int numberOfElements;
	
	public LinkedList()
	{
		_head = _tail = null;
		numberOfElements = 0;
	}
	
	public void add(Type data)
	{
		final Node<Type> nodeToAdd = new Node<Type>(data, null);
		
		if(_head == null)
		{
			_head = nodeToAdd;
			_tail = nodeToAdd;
		}
		else
		{
			_tail.setNext(nodeToAdd);
			_tail = nodeToAdd;
		}
		
		numberOfElements++;
	}
	
	public void add(Node<Type> nodeToAdd)
	{
		
		if(_head == null)
		{
			_head = nodeToAdd;
			_tail = nodeToAdd;
		}
		else
		{
			_tail.setNext(nodeToAdd);
			_tail = nodeToAdd;
		}
		
		numberOfElements++;
	}
	
	public void remove(Node<Type> nodeToRemove)
	{
		if(_head == nodeToRemove)
		{
			switch(numberOfElements)
			{
				case 1:
					_head = _tail = null;
					
				case 2:
					_head = _tail;
				
				default:
					_head = _head.getNext();
					
			}
		}
		else if(_tail == nodeToRemove)
		{
			switch(numberOfElements)
			{
					
				case 2:
					_head.setNext(null);
					_tail = _head;
				
				default:
					
					Node<Type> cursor = _head;
					for(int i = 0; i < numberOfElements - 1; i++)
					{							
						cursor = cursor.getNext();
					}	
					cursor.setNext(null);
					_tail = cursor;
			}
		}
		else
		{	
			Node<Type> cursorPrevious = _head;
			Node<Type> cursor = _head.getNext();
			Node<Type> cursorNext = _head.getNext().getNext();
			for(int i = 0; i < numberOfElements - 1; i++)
			{
				if(cursor == nodeToRemove)
				{
					cursor.setNext(null);
					cursorPrevious.setNext(cursorNext);
					break;
				}
				
				cursorPrevious = cursor;
				cursor = cursor.getNext();
				cursorNext = cursor.getNext();
			}					
		}
		numberOfElements--;
	}
	
	public Node<Type> getFirst()
	{
		return _head;
	}
	
	public Node<Type> getLast()
	{
		return _tail;
	}
}



DataProvider<String, String> fileDataProvider = new VirtualDatabase<String, String>(new HashMap<String, String>(){{
	put("Documents/MyImages/vacation.jpg", "vacation.jpg");
	put("Videos/MyVideos/video.mp4", "video.mp4");
	put("Videos/Youtube/tutorial.mp4", "tutorial.mp4");
	put("Documents/Cpp/facebuk.cpp", "facebuk.cpp");
	put("Documents/Python/collatz.py", "collatz.py");
	put("Documents/Cpp/facebuk.cpp", "facebuk.cpp");
	put("Documents/MyImages/vacation.jpg", "vacation.jpeg");
}});

DataProvider<Integer, String> webCache = new VirtualDatabase(new HashMap<Integer, String>(){{
	put(0, "www.youtube.com");
	put(1, "www.google.com");
	put(2, "www.github.com");
	put(3, "www.oracle.com");
	put(4, "www.facebook.com");
	put(5, "www.twitter.com");
}});

Cache<Integer, String> emptyCache = new LRUCache<Integer, String>(webCache, 4);
Cache<Integer, String> cacheWithOneKeyValue  = new LRUCache<Integer, String>(webCache, 4);
Cache<Integer, String> fullCache  = new LRUCache<Integer, String>(webCache, 4);





@Test
public void testGetFileFromDataProvider()
{
	/* This is a basic test that evaluates the following:
	 * 	- Does the data-provider's "get" method compile.
	 * 	- Can the "get" method actually get a valid value that is contained within its memory(HashMap). 
	 */
	assertEquals("collatz.py", fileDataProvider.get("Documents/Python/collatz.py"));
}

@Test
public void testGetFileFromDataProvider2()
{
	/* This test evaluates:
	 * 	- What happens if the user requests a piece of data that dosen't even exist within the provider.
	 */
	assertEquals(null, fileDataProvider.get("Documents/C/hello-world.c"));
}

@Test
public void testGetFileFromDataProvider3()
{
	/* This test evaluates:
	 * 	- What happens when there are duplicate key value pairs inserted to the data-provider.
	 */
	assertEquals("facebuk.cpp", fileDataProvider.get("Documents/Cpp/facebuk.cpp"));
	/* Explanation: If you attempt to "put" a particular key into a HashMap twice,
	 *              then the old value associated with the key will be replaced with the new one.
	 *              In this case, because the pair "Documents/Cpp/facebuk.cpp : facebuk.cpp" was "put" twice into the
	 *              HashMap, the value of "Documents/Cpp/facebuk.cpp", will be replaced with "facebuk.cpp" which is the
	 *              exact same as it was before.  
	 */
	
}

@Test
public void testGetFileFromDataProvider4()
{
	/* This test evaluates:
	 * 	- What happens when there is a duplicate key "put" into a HashMap with a different value.
	 */
	assertEquals("vacation.jpeg", fileDataProvider.get("Documents/MyImages/vacation.jpg"));
	/* Explanation: Here, the value of "Documents/MyImages/vacation.jpg" was originally "vacation.jpg",
	 * but was later replaced with "vacation.jpeg".
	 */
}

@Test
public void storeDataInEmptyCache()
{
	emptyCache.get(3);
	HashMap<Integer, String> expectedCacheData = new HashMap<Integer, String>(){{
		put(3, "www.oracle.com");
	}};
	assertEquals(expectedCacheData, emptyCache.getStorage());
}

@Test
public void storeDataInCacheWithDataAlreadyInIt()
{
	cacheWithOneKeyValue.get(3);
	cacheWithOneKeyValue.get(0);
	HashMap<Integer, String> expectedCacheData = new HashMap<Integer, String>(){{
		put(3, "www.oracle.com");
		put(0, "www.youtube.com");
	}};
	assertEquals(expectedCacheData, cacheWithOneKeyValue.getStorage());
}

@Test
public void storeDataInFullCache()
{
	fullCache.get(3);
	fullCache.get(0);
	fullCache.get(2);
	fullCache.get(5);
	fullCache.get(4);
	
	HashMap<Integer, String> expectedEvictedCacheData = new HashMap<Integer, String>(){{
		put(0, "www.youtube.com");
		put(2, "www.github.com");
		put(5, "www.twitter.com");
		put(4, "www.facebook.com");
	}};
	
}

@Test
public void leastRecentlyUsedIsCorrect() 
{
	
}*/
