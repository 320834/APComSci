//package myArrayListCompletedwithErrors;
package myArrayList;

/**
 * 	Criteria 1: Yes
 *  Criteria 2: No
 *  Criteria 3: Yes
 *  Criteria 4: Yes
 *  Criteria 5: Yes
 *  Criteria 6: Yes
 *  Criteria 7: No
 *  Criteria 8: Yes
 *  Criteria 9: No
 *  Criteria 10: No
 */
public class MyArrayList5218<E>
{
	private Object[] a;
	private int size;

	public MyArrayList5218()
	{
		this(10);
	}

	public MyArrayList5218(int initialCapacity)
	{
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		a = new Object[initialCapacity];
		size = initialCapacity;
	}

	public int size()
	{
		return a.length;
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
		
		a[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	public E remove(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Object old = a[index];
		a[index] = null;
		size--;
		return (E) old;
	}

	public boolean remove(Object elem)
	{
		for (int i = 0; i < size; i++)
		{
			if (elem.equals(a[i])) // TODO: TAKE NULL INTO ACCOUNT
			{
				remove(i);
				return true;
			}
		}
		return false;
	}
}
