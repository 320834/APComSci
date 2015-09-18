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
public class MyArrayList<E>
{
	private Object[] a;
	private int size;

	public MyArrayList()
	{
	    size = 0;
	    a = new Object[10];
	}

	public MyArrayList(int initialCapacity)
	{
		if (initialCapacity < 0)
			throw new IllegalArgumentException();
		else{
			size = 0;
			a = new Object[initialCapacity];
		}
	}

	public int size()
	{
		return size;
	}

    @SuppressWarnings("unchecked")
	public E get(int index)
	{
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		
		return (E) a[index];
	}

	public E set(int index, E element)
	{
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		@SuppressWarnings("unchecked")
		E returnValue = (E)a[index];
		a[index] = element;
		return returnValue;
	}

	public boolean contains(Object elem)
	{
		if(elem == null)
			for(int i = 0; i < size; i++)
				if(a[i] == null)
					return true;
		for(int i = 0; i < size; i++)
			if(a[i].equals(elem))
				return true;
		return false;
	}

	public void trimToSize()
	{
		Object[] temp = new Object[size];
		System.arraycopy(a, 0, temp, 0, size);
		a = new Object[size];
		System.arraycopy(temp, 0, a, 0, size);
	}

	public void add(E elem)
	{
		add(size, elem);
	}

	public void add(int index, E element)
	{
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		Object[] temp = new Object[a.length + 1];
		System.arraycopy(a, 0, temp, 0, index);
		temp[index] = element;
		System.arraycopy(a, index, temp, index + 1, a.length - index);
		if(temp.length > a.length)
			a = new Object[a.length + 1];	//(2*a.length + 1)  gave OutOfMemoryException so I changed it to a.length + 1;
		System.arraycopy(temp, 0, a, 0, temp.length);
		size++;
	}

	@SuppressWarnings("unchecked")
	public E remove(int index)
	{
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		E removed = (E) a[index];

		Object[] temp = new Object[a.length - 1];
		System.arraycopy(a, 0, temp, 0, index);
		System.arraycopy(a, index + 1, temp, index, size - index - 1);
		System.arraycopy(temp, 0, a, 0, temp.length);

		size--;
		return removed;
	}

	public boolean remove(Object elem)
	{
		for(int i = 0; i < size; i++)
			if(elem == null){
				if(a[i] == null){
					remove(i);
					return true;
				}
			}
			else
				if(a[i].equals(elem)){
					remove(i);
					return true;
				}
		return false;
	}
}
