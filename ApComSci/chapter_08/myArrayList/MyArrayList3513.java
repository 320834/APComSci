package myArrayList;

/**
 * Criteria 1: Yes
 * Criteria 2: Yes
 * Criteria 3: Yes
 * Criteria 4: Yes
 * Criteria 5: Yes
 * Criteria 6: Yes
 * Criteria 7: Yes
 * Criteria 8: No
 * Criteria 9: Yes
 * Criteria 10: No
 */
public class MyArrayList3513<E> {
	private Object[] a;
	private int size;

	public MyArrayList3513() {
		size = 0;
		a = new Object[100];
	}

	public MyArrayList3513(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException();

		a = new Object[initialCapacity];

		size = 0;
	}

	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		return (E) a[index];
	}

	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		Object oldValue = a[index];
		a[index] = element;

		return (E) oldValue;
	}

	public boolean contains(Object elem) {

		for (int x = 0; x < size; x++)
			if (elem == null)
				if (a[x] == elem)
					return true;
			else 
				if (a[x].equals(elem))
					return true;
				
		return false;
	}

	public void trimToSize() {
		Object[] temp = new Object[size];
		System.arraycopy(a, 0, temp, 0, size);

		a = temp;
	}

	public int getLength() {
		return a.length;
	}

	public void add(E element) {
		add(size, element);
	}

	public void add(int index, E element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (size < a.length) {
			System.arraycopy(a, index, a, index + 1, size - index);
		} else {
			Object[] temp = new Object[size + 1];
			System.arraycopy(a, 0, temp, 0, size);
			a = temp;
		}

		a[index] = element;
		size++;
	}

	@SuppressWarnings({ "unchecked" })
	public E remove(int index) {
		
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		Object oldValue = a[index];

		System.arraycopy(a, index + 1, a, index, size - (index + 1));

		a[size] = null;
		size--;

		return (E) oldValue;
	}

	public boolean remove(Object elem) {
		{
			for (int x = 0; x < size; x++) {
				if (elem == null)
					if (a[x] == elem){
						remove(x);
						return true;
					}
					else 
						if (a[x].equals(elem)){
							remove(x);
							return true;
						}
			}
			return false;
		}

	}
}
