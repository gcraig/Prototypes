package com.csr.common.util;

public interface ValueListIterator
{
	/* Inserts the specified element into the list (optional operation). */
	public void add(Object o);

	/* Returns true if this ValueListIterator has more elements when traversing the list in the forward direction. */
	public boolean hasNext();

	/* Returns true if this list iterator has more elements when traversing the list in the reverse direction. */
	public boolean hasPrevious();

	/* Returns the next element in the list.  */
	public Object next();

	/* Returns the index of the element that would be returned by a subsequent call to next. */
	public int nextIndex();

	/* Returns the previous element in the list. */
	public Object previous();

	/* Returns the index of the element that would be returned by a subsequent call to previous. */
	public int previousIndex();

	/* Removes from the list the last element that was returned by next or previous (optional operation). */
	public void remove();

	/* Replaces the last element returned by next or previous with the specified element (optional operation). */
	public void set(Object o);
}