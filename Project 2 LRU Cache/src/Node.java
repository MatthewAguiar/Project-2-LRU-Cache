public class Node<KeyType, ValueType>
{
    private KeyType _hashKey;
    private ValueType _value;
    private Node<KeyType, ValueType> _next;
    private Node<KeyType, ValueType> _previous;

    /**
     * Constructor:
     * @param hashKey the key
     * @param value the value of the associated key
     * @param previous a Node that holds the previous key and associated value in the list
     * @param next a Node that holds the next key and associated value in the list
     */

    public Node(KeyType hashKey, ValueType value, Node<KeyType, ValueType> previous, Node<KeyType, ValueType> next)
    {
        _hashKey = hashKey;
        _value = value;
        _next = next;
        _previous = previous;
    }

    /**
     * Returns the key
     * @return the key
     */

    public KeyType getHashKey()
    {
        return _hashKey;
    }

    /**
     * Returns the value of the associated key
     * @return the value of the associated key
     */

    public ValueType getValue()
    {
        return _value;
    }

    /**
     * Sets the pointer to the next node in the list
     * @param node the next node in the list
     */

    public void setNext(Node<KeyType, ValueType> node)
    {
        _next = node;
    }

    /**
     * Returns the next node in the list
     * @return the next node in the list
     */

    public Node<KeyType, ValueType> getNext()
    {
        return _next;
    }

    /**
     * Sets the pointer to the previous node in the list
     * @param node the previous node in the list
     */

    public void setPrevious(Node<KeyType, ValueType> node)
    {
        _previous = node;
    }

    /**
     * Returns the previous node in the list
     * @return the previous node in the list
     */

    public Node<KeyType, ValueType> getPrevious()
    {
        return _previous;
    }
}
