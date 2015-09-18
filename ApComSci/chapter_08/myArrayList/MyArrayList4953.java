package myArrayList;

/**
 * Constructs the ArrayList Class Implements methods within the ArrayList Class
 * including size, get, set, contains, trimToSize, add, and remove
 * 
 * Criteria 1: Yes
 * Criteria 2: Yes
 * Criteria 3: Yes
 * Criteria 4: No
 * Criteria 5: Yes
 * Criteria 6: No
 * Criteria 7: Yes
 * Criteria 8: No
 * Criteria 9: Yes
 * Criteria 10: No
 */
public class MyArrayList4953<E> {

	private Object[] a;
	private int size;

	/**
	 * Constructs the ArrayList object
	 */
	public MyArrayList4953() {
		this.a = new Object[10];
		size = 0;
	}

	/**
	 * 
	 * @param initialCapacity
	 */
	public MyArrayList4953(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		}

		this.a = new Object[initialCapacity];
		size = 0;

	}

	/**
	 * 
	 * @return the number of elements in this list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return the element at the specified position in this list.
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return (E) a[index];

		// Note: You must cast the reference from the array to type E.
		// For example, to return element 6 from a: return (E) a[6];
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 * @param element
	 * 
	 */
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		a[index] = element;
		E oldValue = (E) a[index];
		return oldValue;
	}

	/**
	 * 
	 * @param elem
	 * @return the index of the first occurrence of the specified element in
	 *         this list, or -1 if this list does not contain the element. More
	 *         formally, returns the lowest index i such that (o==null ?
	 *         get(i)==null : o.equals(get(i))), or -1 if there is no such
	 *         index.
	 */
	public boolean contains(Object elem) {
		for (int i = 0; i < a.length - 1; i++) {
			if (elem.equals(a[i]))
				return true;
		}
		return false;
	}

	/**
	 * Trims the capacity of this ArrayList instance to be the list's current
	 * size. An application can use this operation to minimize the storage of an
	 * ArrayList instance.
	 */
	public void trimToSize() {
		
		
		if(size<a.length){
			Object[] array = new Object[size];
			
			System.arraycopy(a, 0, array, 0, size);
			a = array;
		}

	}

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param elem
	 */
	public void add(E elem) {

		if(a.length==size){
			Object []array = null;
			if(size!=0)
				array=new Object[2*size];
			else
				array=new Object[10];
			for(int i=0;i<size;i++){
				array[i]=a[i];
			}
			
			a=array;
			a[size]=elem;
		}else
			a[size]= elem;

		size++;
		
	}

	/**
	 * 
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * 
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		if (index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Object []array = null;
		
		if(a.length==size)
			array =new Object[2*size];
		else
			array=new Object[a.length];


		
			for(int i=0;i<size;i++){
				if(i<index)
					array[i]=a[i];
				else if (i==index)
					array[i]=element;
				else
					array[i]=a[i-1];
			}
			a=array;
			size++;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * @param index
	 * @return what is removed
	 */
	@SuppressWarnings("unchecked")
	public E remove(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Object old = a[index];
		System.arraycopy(a, index + 1, a, index, size - (index + 1));
		a[--size] = null;
		return (E) old;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present. If the list does not contain the element, it is unchanged.
	 * More formally, removes the element with the lowest index i. Returns true
	 * if this list contained the specified element (or equivalently, if this
	 * list changed as a result of the call).
	 * 
	 * @param elem
	 * @return if element is inside of the arrayList
	 */
	@SuppressWarnings("unused")
	public boolean remove(Object elem) {
		boolean returnValue = false;
		if (this.contains(elem)) {
			for (int i = 0; i < size; i++) {
				if (elem.equals(a[i])) {
					E ele = this.remove(i);
					returnValue = true;
				}

			}
		}

		return returnValue;

	}
}