package twostack;

import java.util.Arrays;

/**
 * TwostackArray is a class that contrains two stacks that meet top ends when they are full.
 * Author: Øyvind Johannessen
 * Version: 1.0
 * @param <E>
 */
public class TwostackArray<E> implements Twostack<E> {
    // Felt for denne klassen
    // Holder en referanse til et two stack array
    private E[] twostackArray;
    // Holder index til øverste elementet i venstre stabel
    private int leftTopIndex;
    // Holder index til øverste element i høyre stabel
    private int rightTopIndex;
    // Størrelsen til venstre stabel
    private int leftStackSize = 0;
    // Størrelsen til høyre stabel
    private int rightStackSize = 0;
    // Holder standardverdi til stabel. Brukes når stabel størrelse ikke er definert av bruker
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * Constructor1: Konstruerer et two stack array med standard størrelse
     */
    public TwostackArray() {
        this.twostackArray = (E[]) new Object[DEFAULT_CAPACITY];
        this.leftTopIndex = -1;
        this.rightTopIndex = DEFAULT_CAPACITY;
    }

    /**
     * Constructor2: Konstruerer et two stack array med bruker definert størrelse
     * @param stackCapacity Størrelsen på two stack arrayet som skal instansieres
     */
    public TwostackArray(int stackCapacity) {
        this.twostackArray = (E[]) new Object[stackCapacity];
        this.leftTopIndex = -1;
        this.rightTopIndex = stackCapacity;
    }

    /**
     * Sjekker om hele two stack arrayet er tomt, både venstre og høyre side
     * @return boolean Enten tomt (true) eller ikke tomt (false)
     */
    private boolean isEmpty() {
        return leftStackSize == 0 && rightStackSize == 0;
    }

    @Override
    public Integer size(Boolean right) {
        int size = 0;
        if(right) {
            // Sjekk størrelse i høyre stabel
            size = rightStackSize;
        } else {
            // Sjekke størrelse i venstre stabel
            size = leftStackSize;
        }
        return size;
    }

    @Override
    public void push(Boolean right, E element) throws TwostackFullException {
        if(leftStackSize + rightStackSize == twostackArray.length) {
            throw new TwostackFullException("The two stack array is full.\n Left: " + leftStackSize + "\n Right: " + rightStackSize + "\n Max size is: " + this.twostackArray.length);
        }
        if(right) {
            twostackArray[rightTopIndex - 1] = element;
            rightTopIndex--;
            rightStackSize++;
        } else {
            twostackArray[leftTopIndex + 1] = element;
            leftTopIndex++;
            leftStackSize++;
        }
    }

    @Override
    public E pop(Boolean right) throws TwostackEmptyException {
        E topEntry = null;
        if(isEmpty())
            throw new TwostackEmptyException("Two stack is empty. There is nothing to pop");
        if(right) {
            if(size(true) == 0) throw new TwostackEmptyException("Right stack is empty");
            topEntry = twostackArray[rightTopIndex];
            twostackArray[rightTopIndex] = null;
            rightTopIndex++;
            rightStackSize--;
        } else {
            if(size(false) == 0) throw new TwostackEmptyException("Left stack is empty");
            topEntry = twostackArray[leftTopIndex];
            twostackArray[leftTopIndex] = null;
            leftTopIndex--;
            leftStackSize--;
        }
        return topEntry;
    }

    @Override
    public E peek(Boolean right) throws TwostackEmptyException {
        if(isEmpty())
            throw new TwostackEmptyException("Two stack is empty");
        if(right) {
            if(size(true) == 0) throw new TwostackEmptyException("Right stack is empty");
            return twostackArray[rightTopIndex];
        } else {
            if(size(false) == 0) throw new TwostackEmptyException("Left stack is empty");
            return twostackArray[leftTopIndex];
        }
    }

    @Override
    public Boolean contains(E element) {
        for (E entry : twostackArray) {
            if (entry.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        twostackArray = (E[]) new Object[twostackArray.length];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int length = twostackArray.length;
        int index = 0;

        // This cast is safe. New array contains null entries
        @SuppressWarnings("unchecked")
        E[] arr = (E[]) new Object[length];

        for (E entry : twostackArray) {
            if (entry != null) {
                arr[index] = entry;
                index++;
            }
        }

        return (T[]) Arrays.copyOf(arr, length, a.getClass());
    }
}
