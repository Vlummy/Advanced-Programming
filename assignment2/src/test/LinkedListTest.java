package test;

import friend_app.linked_list.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(10);
        assertEquals(2, linkedList.getLength()); // Should be correct after adding two elements
    }

    @Test
    void remove() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.remove(2);
        assertEquals(3, linkedList.getLength()); // New linkedlist should only contain 2, 3, 4
    }

    @Test
    void clear() {
    }

    @Test
    void getLength() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void getIterator() {
    }

    @Test
    void sort() {
    }

    @Test
    void iterator() {
    }
}