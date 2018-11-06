
public class Node<Type> 
{
	private Type _data;
	private Node<Type> _next;
	
	public Node(Type data, Node<Type> next)
	{
		_data = data;
		_next = next;
	}
	
	public void setNext(Node<Type> node)
	{
		_next = node;
	}
	
	public Node<Type> getNext()
	{
		return _next;
	}
}
