package friend_app.linked_list;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class LinkedList. Used for storing collections of items of the same type
 * Author: Roy H. Jensen, Øyvind Johannessen
 * Version: 1.0
 * @param <T>
 */
public final class LinkedList<T> implements ListInterface<T> {

    // Fields for this class
    private Node<T> firstNode;
    private int numberOfEntries; // Holds the amount of entries (nodes) in the linked list

    /**
     * Constructor for LinkedList. Set's the firstNode to null and numberOfEntries to 0
     */
    public LinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public void add(T newItem) {
        // Create a new node
        // Add newItem to the newly created node
        // Add the initial node as the new nodes reference
        Node node = new Node(newItem, this.firstNode);
        this.firstNode = node;
        // Increment numberOfEntries
        numberOfEntries++;
    }

    @Override
    public T remove(int position) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getLength() {
        return this.numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ListIterator<T> getIterator() {
        return null;
    }

    @Override
    public void sort() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
