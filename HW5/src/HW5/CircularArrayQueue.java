package HW5;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E> 
{
	public int head;
	public int tail;
	public int size;
	public int capacity;
	public static final int DEFAULT_CAPACITY = 10;
	public E[] data;
	
	public CircularArrayQueue() 
	{
		 this(DEFAULT_CAPACITY);
	}
	
	public CircularArrayQueue(int capacity) 
	{
		 this.capacity = capacity;
		 data = (E[]) new Object[capacity];
		 size = 0;
		 head = 0;
		 tail = capacity -1;
	}

	@Override
	public int size() 
	{
		return 0;
	}

	@Override
	public boolean isEmpty() 
	{
		return false;
	}

	@Override
	public boolean contains(Object o) 
	{
		return false;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return null;
	}

	@Override
	public Object[] toArray()
	{
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) 
	{
		return null;
	}

	@Override
	public boolean remove(Object o)
	{
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) 
	{
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) 
	{
		return false;
	}

	@Override
	public void clear() 
	{
		
	}

	@Override
	public boolean add(E e) 
	{
		if(size == capacity)
		{			
			throw new NoSuchElementException();		
		}
		size++;
		tail = (tail + 1) % capacity;
		data[tail] = e;
		return true;
	}

	@Override
	public boolean offer(E item) 
	{
		if (size == capacity) 
		{
			 reallocate();
		}
			 size++;
			 tail = (tail + 1) % capacity; 
			 data[tail] = item;
			 return true;

	}

	private void reallocate() 
	{
		 int newCapacity = 2 * capacity;
		 E[] newData = (E[]) new Object[newCapacity];
		 int j = head;
		 
		 for (int i = 0; i < size; i++) 
		 {
			 newData[i] = data[j];
			 j = (j + 1) % capacity;
		 }
		 data = newData;
		 capacity = newCapacity;
		 head = 0;
		 tail = size -1;	 		 
	}

	@Override
	public E remove() 
	{
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		else
		{
			E result = data[head];
			head = (head + 1) % capacity;
			size--;
			return result;
		}
	}
	
	@Override
	public E poll()
	{
		if (size == 0)
		{
			return null;
		}
		E result = data[head];
		head = (head + 1)% capacity;
		size--;
		return result;

	}

	@Override
	public E element() 
	{
		if(size == 0) 
		{
			throw new NoSuchElementException();
		}
		
		return data[head];
	}
	
	@Override
	public E peek()
	{
		if (size == 0)
		{
			return null;
		} 
		 else
		 {
			 return data[head];
		 }
	}	
	
}