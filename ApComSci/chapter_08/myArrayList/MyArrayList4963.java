//package myArrayListCompleted;
package myArrayList;

/**
 * Criteria 1: Yes
 * Criteria 2: Yes
 * Criteria 3: Yes
 * Criteria 4: Yes
 * Criteria 5: Yes
 * Criteria 6: Yes
 * Criteria 7: Yes
 * Criteria 8: Yes
 * Criteria 9: Yes
 * Criteria 10: Yes
 */
public class MyArrayList4963<E>
{
	private Object[] a;
	private int size;
	
	public MyArrayList4963()
	{
		this(10);
	}

	public MyArrayList4963(int initialCapacity)
	{
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		a = new Object[initialCapacity];
		size = 0;
	}

	public int size()
	{
		return size;
	}

	@SuppressWarnings("unchecked")
    public E get(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		return (E) a[index];
	}

	@SuppressWarnings("unchecked")
	public E set(int index, E element)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Object old = a[index];
		a[index] = element;
		return (E) old;
	}

	public boolean contains(Object elem)
	{
		for (int i = 0; i < size; i++)
		{
			if (elem == null ? a[i] == null : elem.equals(a[i]))
				return true;
		}
		return false;
	}

	public void trimToSize()
	{
		if (size < a.length)
		{
			Object[] b = new Object[size];
			System.arraycopy(a, 0, b, 0, size);
			a = b;
		}
	}

	public void add(E elem)
	{
		add(size, elem);
	}

	public void add(int index, E element)
	{
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (size < a.length)
			System.arraycopy(a, index, a, index + 1, size - index);
		else
		{
			Object[] b = new Object[a.length * 2 + 1]; // +1 in case a.length == 0
			System.arraycopy(a, 0, b, 0, index);
			System.arraycopy(a, index, b, index + 1, size - index);
			a = b;
		}
		a[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	public E remove(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Object old = a[index];
		System.arraycopy(a, index + 1, a, index, size - (index + 1));
		size--;
		a[size] = null;
		return (E) old;
	}

	public boolean remove(Object elem)
	{
		for (int i = 0; i < size; i++)
		{
		    if((elem == null && a[i] == null) ||
		            (elem != null && elem.equals(a[i]))) 
			{
				remove(i);
				return true;
			}
		}
		return false;
	}
}
