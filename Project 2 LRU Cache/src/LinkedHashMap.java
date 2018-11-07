import java.util.HashMap;

public class LinkedHashMap<KeyType, ValueType>
{
    private final HashMap<KeyType, Node<KeyType, ValueType>> _map = new HashMap<KeyType, Node<KeyType, ValueType>>();
    private Node<KeyType, ValueType> _head, _tail;
    private int _numberOfElements;

    /**
     * Constructor:
     * Sets the Node: _head and _tail to the default of null.
     * Also sets the _numberOfElements in the list to be 0 to begin with.
     */

    public LinkedHashMap()
    {
        _head = _tail = null;
        _numberOfElements = 0;
    }

    /**
     *
     * Method tests if at the start of the list that both the variables: _head and _tail is null,
     * then set both variables to nodeToAdd, the node that is being added into the list.
     * If there are already elements in the list, set the pointer of the tail to the next node after nodeToAdd
     * and then have the tail be nodeToAdd.
     * After checking through the conditional statements, _map would have its arguments set to the key that was passed
     * in and the Node to nodeToAdd. The list will also increment in size every time it is called.
     *
     * @param key the key
     * @param value  the value of the specified key
     */

    public void put(KeyType key, ValueType value)
    {
        final Node<KeyType, ValueType> nodeToAdd = new Node<KeyType, ValueType>(key, value, _tail, null);

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

        _map.put(key, nodeToAdd);
        _numberOfElements++;
    }

    /**
     * Takes in a key and removes its key and associated value from the list.
     * Checks if the nodeToFind is either null or not. If it is not null, it would check for cases if the nodeToFind is
     * either the head, tail, or in the middle of the list. If the nodeToFind is the head, head would be set to the next
     * node in the list and the previous node to the head would become null. For the case of the tail, tail would be set
     * to the previous node in the list while the next node after previous would be set to null. In the else case, the
     * nodeToFind would be somewhere in the middle of the list, it would then have the nodes point to the next or to
     * the previous one of the node that is being remove from the list. Once the node has been removed from the list
     * the size of the list decrements.
     *
     * @param key the key
     */

    public void remove(KeyType key)
    {
        Node<KeyType, ValueType> nodeToFind = _map.get(key);

        if(nodeToFind != null)
        {
            if(nodeToFind.getNext() == null && nodeToFind.getPrevious() == null)
            {
                _head = _tail = null;
            }
            else if(nodeToFind.getPrevious() == null)
            {
                _head = _head.getNext();
                _head.setPrevious(null);
            }
            else if(nodeToFind.getNext() == null)
            {
                _tail = _tail.getPrevious();
                _tail.setNext(null);
            }
            else
            {
                nodeToFind.getPrevious().setNext(nodeToFind.getNext());
                nodeToFind.getNext().setPrevious(nodeToFind.getPrevious());
            }

            _map.remove(key);
            _numberOfElements--;
        }
    }


    /**
     * Returns the head of the list since it is the least recently used (LRU) cache in the current list
     * @return the head of the list since it is the least recently used (LRU) cache in the current list
     */

    public Node<KeyType, ValueType> getLRU()
    {
        return _head;
    }

    /**
     * Returns the key and associated value of the tail of the list because it is the most recently used (MRU) cache
     * @return the key and associated value of the tail of the list because it is the most recently used (MRU) cache
     */

    public Node<KeyType, ValueType> getMRU()
    {
        return _tail;
    }

    /**
     *
     * Returns a boolean value if the hashmap contains the key that is passed into the method
     * @param key the key
     * @return a boolean value if the hashmap contains the key that is passed into the method
     */

    public boolean containsKey(KeyType key)
    {
        return _map.containsKey(key);
    }

    /**
     * Returns the size of the list
     * @return the size of the list
     */

    public int size()
    {
        return _numberOfElements;
    }

    /**
     * Returns the value of the associated key that is passed in
     * @param key the key
     * @return the value of the associated key that is passed in
     */

    public Node<KeyType, ValueType> get(KeyType key)
    {
        return _map.get(key);
    }
}
