package friend_app.linked_list;
import java.util.Iterator;

/**
 * Class LinkedList. Used for storing collections of items of the same type
 * Author: Roy H. Jensen, Øyvind Johannessen
 * Version: 1.0
 * @param <T>
 */
public final class LinkedList<T> implements ListInterface<T> {

    // Fields for this class
    private Node<T> firstNode;
    private Node<T> lastNode; // the tail of the chain
    private int numberOfEntries; // Holds the amount of entries (nodes) in the linked list

    /**
     * Constructor for LinkedList. Set's the firstNode to null and numberOfEntries to 0
     */
    public LinkedList() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public void add(T newItem) {
        if(firstNode == null) {
            Node<T> firstNode = new Node<>(newItem, lastNode);
            this.firstNode = firstNode;
            this.lastNode = firstNode;
        } else {
            Node<T> nextNode = new Node<>(newItem, null);
            lastNode.next = nextNode;
            lastNode = nextNode;
        }
        numberOfEntries++;
    }

    @Override
    public T remove(int position) {
        if(position < 1 || position > getLength()) throw new IndexOutOfBoundsException();
        T data = null;
        Node currentNode = firstNode;
        for(int i = 1; i < position - 1; i++) {
            currentNode = currentNode.next;
        }
        data = (T) currentNode.next;
        currentNode.next = currentNode.next.next;
        numberOfEntries--;
        return data;
    }

    @Override
    public T remove(T entry) {
        T data = null;
        if(firstNode.dataItem == entry) {
            data = firstNode.dataItem;
            firstNode = firstNode.next;
            numberOfEntries--;
        } else {
            Node currentNode = firstNode;
            for(int i = 1; i < numberOfEntries; i++) {
                if(currentNode.next.dataItem == entry) {
                    data = (T) currentNode.next.dataItem;
                    currentNode.next = currentNode.next.next;
                    numberOfEntries--;
                } else {
                    currentNode = currentNode.next;
                }
            }
        }
        return data;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getLength() {
        return this.numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public Iterator<T> getIterator() {
        return new Iterator<T>() {
            private Node currentNode = firstNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    Node returnNode = currentNode;
                    currentNode = currentNode.next;
                    return (T) returnNode.dataItem;
                }
                return null;
            }
        };
    }

    @Override
    public void sort() {

    }
}
