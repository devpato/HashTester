

public class Node
{
	private String data;
	private Node next;

	public Node()
	{
		data = null;
		next = null;
	}

	public Node(String data, Node next)
	{
		this.data = data;
		this.next = next;
	}

	public Node(Node source)
	{
		data = source.data;
		next = source.next;
	}

	public String getData()
	{
		return data;
	}

	public Node getNext()
	{
		return next;
	}

	public String setData(String data)
	{
		return this.data = data;
	}

	public Node setNext(Node next)
	{
		return this.next = next;
	}

}
