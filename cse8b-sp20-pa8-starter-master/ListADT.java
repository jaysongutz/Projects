/**
 * A List is a general container storing a contiguous collection of items, 
 * that is position-oriented using zero-based indexing and where 
 * duplicates are allowed. ADT stands for Abstract Data Type.
 */
public interface ListADT<T> {
    /**
     * Add item to the end of the List.
     *
     * @param item the item to add
     */
    public void add(T item);

    /**
     * Add item at position pos in the List, moving the items originally 
     * in that position and any subsequent elements to the right 
     * (adds one to their indices)
     *
     * @param  pos                       the position at which to add 
     *                                   the item
     * @param  item                      the item to add
     * @throws IndexOutOfBoundsException if pos is less than 0 or greater 
     *                                   than size()
     */
    public void add(int pos, T item);

    /**
     * Return true if and only if the item is in the List (i.e., there is 
     * an item x in the List such that x.equals(item))
     *
     * @param  item the item to check
     * @return true if item is in the List, false otherwise
     */
    public boolean contains(T item);

    /**
     * Return the number of items in the List.
     *
     * @return the number of items in the List
     */
    public int size();

    /**
     * Return true iff the List is empty.
     *
     * @return true if the List is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Return the item at position pos in the List.
     *
     * @param  pos                       the position of the item to return
     * @return                           the item at position pos
     * @throws IndexOutOfBoundsException if pos is less than 0 or greater 
     *                                   than or equal to size()
     */
    public T get(int pos);

    /**
     * Remove and return the item at position pos in the List. Shifts any
     * subsequent elements to the left (subtracts one from their indices)
     *
     * @param  pos                       the position at which to remove 
     *                                   the item
     * @return                           the item at position pos
     * @throws IndexOutOfBoundsException if pos is less than 0 or greater 
     *                                   than or equal to size()
     */
    public T remove(int pos);

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present. If this list does not contain the element, the 
     * list is unchanged.
     *
     * @param  item element to be removed from this list, if present
     * @return      true if this list contained the specified element,
     *              false otherwise
     */
    public boolean remove(T item);

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param  item the element to search for
     * @return      the index of the first occurrence of the specified 
     *              element in this list, or -1 if this list does not 
     *              contain the element
     */
    public int indexOf(T item);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param  index                     index of the element to replace
     * @param  element                   element to be stored at the 
     *                                   specified position
     * @return                           the element previously at the 
     *                                   specified position
     * @throws IndexOutOfBoundsException if index is less than 0 or greater 
     *                                   than or equal to size()
     */
    public T set(int index, T element);

    /**
     * Removes all of the elements from this list. The list will be empty 
     * after this call returns.
     */
    public void clear();

    /**
     * Returns a copy of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.
     *
     * @param  fromIndex                 low endpoint (inclusive) of the 
     *                                   subList
     * @param  toIndex                   high endpoint (exclusive) of the 
     *                                   subList
     * @return                           a copy of elements in the specified 
     *                                   range within this list
     * @throws IndexOutOfBoundsException if the fromIndex is less than 0 or it 
     *                                   is greater than or equal to size
     *                                   or if the toIndex is greater than size
     *                                   or it is less than 0
     * @throws IllegalArgumentException  when fromIndex > toIndex
     */
    public ListADT<T> subList(int fromIndex, int toIndex);

}
