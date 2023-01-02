/* IMPORTANT NOTE: 
 * You should NOT use the Java's ArrayList class to implement this PA.
 * All the method signatures may not be provided in this starter code.
 */
class CustomAL<T> implements ListADT<T> {
    
    T[] data;
    int size;

    /**
     * Construct a default CustomAL. Do this by setting size to 0, and
     * initializing the backing array (i.e., Object[] data) to have an
     * initial capacity of 10
     */
    public CustomAL() {
        this.size = 0;
        this.data = (T[]) new Object[10];
    }

    /**
     * Construct a CustomAL with initial capacity to be the given
     * capacity and size to be zero
     *
     * @param  capacity                 the initial capacity of the 
     *                                  CustomAL
     * @throws IllegalArgumentException if the specified initial 
     *                                  capacity is negative
     */
    public CustomAL(int capacity){
        this.size = 0;
        try {
        	if (capacity < 0 ) {
        		throw new IllegalArgumentException();
        	}
        	this.data = (T[]) new Object[capacity];
        }
        catch (IllegalArgumentException e) {
        	System.out.println("Illegal Argument Exception caused by: " +
        					   capacity);
        }
    }
    

    /**
     * Resize the backing array to create more space. The capacity of the 
     * array is doubled and all the elements from index 0 to size-1 are 
     * copied to the new array.
     */
    public void resize() {        
    	T[] holderArr =  (T[]) new Object[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++) {
        	holderArr[i] = this.data[i];
        }
        this.data = holderArr;
    }

    @Override
    /** 
     * Returns true if and only if the specified object is also a list, both
     * lists have the same size, and all corresponding pairs of elements in the
     * two lists are equal.
     * 
     * @return true if the two CustomALs are equal in size and elements;
     *         false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null) {
        	return false;
        }
        if (!(obj instanceof CustomAL)) {
        	return false;
        }
        CustomAL<T> inObj = (CustomAL<T>) obj;
        if (this.size != inObj.size()) {
        	return false;
        }
        for (int i = 0; i < this.size; i++) {
        	if (!(this.data[i].equals(inObj.data[i]))) {
        		return false;
        	}
        }
        return true;
    }

    @Override
    /**
     * Overridden toString method to print the Custom Array List
     * 
     * @return the string representation of the Custom Array List
     */
    public String toString() {
        // NOTE: Do NOT change this method!
        String str = "[";
        for (int i = 0; i < this.size; i++) {
            if (i == this.size - 1)
                str += this.data[i];
            else
                str += (this.data[i] + ", ");
        }
        str += "]";
        return str;
    }

    /**
     * Print the size, capacity, load, and data of the CustomAL
     *
     * load = size / capacity
     */
    public void printDetails() {
        // NOTE: Do NOT change this method!
        System.out.print("size: " + this.size + " | ");
        System.out.print("capacity: " + this.data.length + " | ");
        System.out.print(
                "load: " + (double) this.size / this.data.length + " | ");
        System.out.println("data: " + this.toString());
    }
 
    
    public void add(T item) {
    	this.size++;
    	if (this.size > this.data.length) {
    		this.resize();
    		for (int i = 0; i < this.data.length; i++) {
    			if (this.data[i] == null) {
    				this.data[i] = item;
    				return;
    			}
    		}
    	}
    	else {
    		for (int i = 0; i < this.data.length; i++) {
    			if (this.data[i] == null) {
    				this.data[i] = item;
    				return;
    			}
    		}
    	}
    }
   
    public void add(int pos, T item) {
		if (pos < 0 || pos > this.size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception caused by: " +
					   pos);
		}
    	this.size++;
    	if (this.size > this.data.length) {
    		this.resize();
    		for (int i = this.data.length - 1; i > pos; i--) {
    			this.data[i] = this.data[i - 1];
    		}
    		this.data[pos] = item;
    	}
    	else {
    		for (int i = this.data.length - 1; i > pos; i --) {
    			this.data[i] = this.data[i -1];
    		}
    		this.data[pos] = item;
    	}
    }
    
    public boolean contains(T item) {
    	for (int i = 0; i < this.data.length; i++) {
    		if (this.data[i] == item) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public int size() {
    	return this.size;
    }
    
    public boolean isEmpty() {
    	for (int i = 0 ; i < this.data.length; i++) {
    		if (this.data[i] != null) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public T get(int pos) {
		if (pos < 0 || pos >= this.size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception caused by: " +
						   pos);
		}
		return this.data[pos];
    }
    
    public T remove(int pos) {
		if (pos < 0 || pos >= size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception caused by: " +
						   pos);
		}
		this.size--;
		T remVal = this.data[pos];
		this.data[pos] = null;
		for (int i = pos; i < this.data.length - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
		this.data[this.data.length - 1] = null;
		return remVal;
    }
    
    public boolean remove(T item) {
    	if (this.contains(item)) {
    		this.remove(this.indexOf(item));
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public int indexOf(T item) {
    	for (int i = 0; i < this.data.length; i++) {
    		if (this.data[i] == item) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public T set(int index, T element) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception caused by: " +
						   index);
		}
		T prevVal = this.data[index];
		this.data[index] = element;
		return prevVal;
    }
    
    public void clear() {
    	this.size = 0;
    	for (int i = 0 ; i < this.data.length; i++) {
    		this.data[i] = null;
    	}
    }
    
    public ListADT<T> subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || fromIndex >= this.size || 
			toIndex < 0 || toIndex > this.size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds Exception caused by: " + 
						   fromIndex + " or " + toIndex);
		}
		if (fromIndex >= toIndex) {
			throw new IllegalArgumentException("Illegal Argument Exception caused by: " + 
						   fromIndex + " or " + toIndex);
		}
		CustomAL<T> subList = new CustomAL<>(toIndex - fromIndex);
		for (int i = fromIndex; i < toIndex; i++) {
			subList.add(this.data[i]);
		}
		return subList;
    }
    
    
    
}


