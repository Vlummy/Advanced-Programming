package test;

import friend_app.linked_list.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

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
        assertEquals(3, linkedList.getLength()); // New linkedlist should only contain 1, 3, 4
    }

    @Test
    void clear() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.clear();
        assertEquals(0, linkedList.getLength());
        assertEquals(true, linkedList.isEmpty());
    }

    @Test
    void getLength() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        assertEquals(1, linkedList.getLength());
    }

    @Test
    void isEmpty1() {
        // Checks if list is empty after one item has been added. Should not detect any error
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        assertEquals(false, linkedList.isEmpty());
    }

    @Test
    void isEmpty2() {
        // Checks if list is empty when no element is added. Should not detect any error
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertEquals(true, linkedList.isEmpty());
    }

    @Test
    void sort() {
    }

    @Test
    void iterator() {
    }
}