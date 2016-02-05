package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		//System.out.println("element=" + element + " size=" + size);
		add(size,element);
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		//System.out.println(size + "  "+ index);
		LLNode<E> temp = head.next;
		if (index < 0 || index >= size)
	    {
	        throw new IndexOutOfBoundsException("Out of bounds!");
	    } else {
	    	for (int i = 0 ; i < index ; i++)
	    	{
	    		temp = temp.next;
	    	}
	    }
		return temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if (index < 0 || index > size)
	    {
	        throw new IndexOutOfBoundsException("Out of bounds!");
	    } else {
	    	if (element == null) {
					throw new NullPointerException ("Value cannot be NULL!!!");
			}
			LLNode<E> n = new LLNode<E>(element);
			LLNode<E> temp = head.next;
			LLNode<E> tempPre = null;
			for (int i = 0; i < index ; i++)
			{
				temp = temp.next;
			}
			
			tempPre = temp.prev;
			
			n.next = temp;
			temp.prev = n;
			tempPre.next = n;
			n.prev = tempPre;
			size++;
	    }
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if (index < 0 || index > size)
	    {
	        throw new IndexOutOfBoundsException("Out of bounds!");
	    } else {
	    	LLNode<E> temp = null;
			LLNode<E> tempPre = null;
			LLNode<E> tempPost = null;
			
			temp = head.next;
			for (int i = 0 ; i < index ; i++)
			{
				temp = temp.next;
			}
			
			tempPre = temp.prev;
			tempPost = temp.next;
			tempPre.next = tempPost;
			tempPost.prev = tempPre;
			size--;
			//System.out.println("Size is :" + size);
			return temp.data;
	    }
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if (index < 0 || index >= size)
	    {
	        throw new IndexOutOfBoundsException("Out of bounds!");
	    } else {
	    	if (element == null) {
				throw new NullPointerException ("Value cannot be NULL!!!");
	    	}
	    	LLNode<E> temp = head.next;
	    	for (int i = 0 ; i < index ; i ++){
	    		temp = temp.next;
	    	}
	    	temp.data = element;
	    	return temp.data;
	    }
	}   

}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E data, LLNode next, LLNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data.toString();
	}

	
}
