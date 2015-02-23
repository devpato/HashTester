public class LinkedList_t{
private Node first;
	private int size;

	public LinkedList_t()
	{
		first = null;
		size = 0;
	}
	public static void main(String args[]){
		LinkedList_t myList =  new LinkedList_t();
		myList.insert("apple");
		myList.insert("banana");
		myList.insert("carrot");
		System.out.printf("The linkedList contains",myList);
		System.out.printf("The locatio of the banana",myList.find("banana"));
		System.out.printf("The linkedList contains",myList.find("danish"));
		System.out.printf("The linkedList contains",myList.search("banana"));
		System.out.printf("The linkedList contains",myList.search("danish"));
		if(!myList .remove("danish")){
			System.out.printf("Failed to remove,there is not danish\n ");
		}
		LinkedList_t copyList = new LinkedList_t(myList);
		myList.remove("apple");
		System.out.printf("The linkedList contains",myList);
		myList.remove("carrot");
		System.out.printf("The linkedList contains",myList);
		System.out.printf("The linkedList contains",copyList);



	}
	public String toString(){
		String retval = "";
		Node at =  first;

		while(at != null){
			retval += at.getData() + " ";
			at = at.getNext();
		}
 		return retval.trim();
	}
	public int find(String toFind){
		int retval = find(first,toFind);
		if(retval == size){
			return -1;
		}
		return retval;
	}
	public int find(Node source,String toFind){
		if(source == null){
			return 0;
		}
		if(source.getData().equals(toFind)){
			return 0;
		}
		return 1 + find(source.getNext(),toFind);
	}
	public boolean search(String toFind){
		return search(first,toFind);
	}
	 private boolean search(Node source,String toFind){
                if(source == null){
			return false;
		}
		if(source.getData().equals(toFind)){
		 	return true;
		}
		return search(source.getNext(),toFind);
        }
	public boolean insert(String data){
		Node toInsert = new Node(data,null);
		first = insert(first,toInsert);
		return true;
	}

	private Node insert(Node at,Node toAdd){
		if(at == null){
			size++;
			return toAdd;
		}
		Node next = insert(at.getNext(),toAdd);
		at.setNext(next);
		return at;
	}
	public boolean insertInOrder(String data){
		Node toInsert =new Node(data,null);
		first = insertInOrder(first,toInsert);
		size++;
		return true;

	}

	private Node insertInOrder(Node at,Node toAdd){
		if(at == null){
			return toAdd;
		}
		if(at.getData().compareTo(toAdd.getData())<=0){
			Node next = insertInOrder(at.getNext(),toAdd);
			at.setNext(next);
			return at;
		}
		else{
			toAdd.setNext(at);
			return toAdd;
		}
	}
	public boolean remove(String toFind){
		return remove(first,null,toFind);
	}
	private boolean remove(Node at,Node prior, String toFind){
		if(at == null){
			return false;
		}
		if(at.getData().equals(toFind)){
			if(prior == null){
				first = at.getNext();
				return true;
			}
			prior.setNext((at.getNext()));
			return true;
		}
		return remove(at.getNext(),at,toFind);
	}
	public static Node insertFront(Node at,String data){
		return new Node(data,at);
	}
	public LinkedList_t(LinkedList_t source)
	{
		Node at = source.first;
		while(at != null){
			insert(at.getData());
			at = at.getNext();
		}
}

			//}
		//}
 //}

}
