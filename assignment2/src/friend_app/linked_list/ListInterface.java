package friend_app.linked_list;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Interface for LinkedList. This Interface extends List Interface ( Polymorphism )
 * Author: Roy H. Jensen, Øyvind Johannessen
 * Version 1.0
 * @param <T>
 */
public interface ListInterface<T> {
    /**
     * Adds a new item to the list
     * @param newItem The item to be added
     */
    void add(T newItem);

    /**
     * Remove an item at the given index position
     * @param position
     * @return A refrence to the removed entry
     * @throws IndexOutOfBoundsException
     */
    T remove(int position);

    /**
     * Remove an entry by comparison
     * @return The removed item
     */
    T remove(T item);

    /**
     * Removes all entries from this list.
     */
    void clear();

    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currently in the list.
     */
    int getLength();

    /**
     * Sees whether this list is empty.
     *
     * @return True if the list is empty, or false if not.
     */
    boolean isEmpty();

    /**
     * Used for getting an Iterator Interface so that a list can be iterated
     * @return ListIterator Interface for iterating over a list
     */
    Iterator<T> getIterator();


}
