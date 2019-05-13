package de.haw.javanisten.task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

/**
 * @author Roman Schmidt, Stanislaw Brug
 */
class DequeTest {

    private Deque<String> _deque = new Deque<>();
    private String[] _elements = {"a", "b", "c", "d"};

    @Test
    void addFirst() {
        Assertions.assertTrue(this._deque.isEmpty());
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this._deque.getFirst();
        });
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this._deque.getLast();
        });

        this._deque.addFirst(this._elements[0]);
        Assertions.assertFalse(this._deque.isEmpty());
        Assertions.assertEquals(this._elements[0], this._deque.getFirst());
        Assertions.assertEquals(this._elements[0], this._deque.getLast());

        this._deque.addFirst(this._elements[1]);
        Assertions.assertFalse(this._deque.isEmpty());
        Assertions.assertEquals(this._elements[1], this._deque.getFirst());
        Assertions.assertEquals(this._elements[0], this._deque.getLast());
    }

    @Test
    void addLast() {
        this._deque.addLast(this._elements[0]);
        Assertions.assertEquals(this._elements[0], this._deque.getLast());
        Assertions.assertEquals(this._elements[0], this._deque.getFirst());
        this._deque.addLast(this._elements[1]);
        Assertions.assertEquals(this._elements[1], this._deque.getLast());
        Assertions.assertEquals(this._elements[0], this._deque.getFirst());

        Assertions.assertEquals(this._elements[0], this._deque.removeLast());

        Assertions.assertEquals(this._elements[0], this._deque.getLast());
        this._deque.addLast(this._elements[2]);
        Assertions.assertEquals(this._elements[2], this._deque.getLast());
        Assertions.assertEquals(this._elements[0], this._deque.getFirst());
    }

    @Test
    void removeFirst() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this._deque.removeFirst();
        });
        this._deque.addFirst(this._elements[0]);
        Assertions.assertFalse(this._deque.isEmpty());
        Assertions.assertNull(this._deque.removeFirst());
        Assertions.assertTrue(this._deque.isEmpty());

        this._deque.addFirst(this._elements[1]);
        this._deque.addFirst(this._elements[2]);
        Assertions.assertFalse(this._deque.isEmpty());
        Assertions.assertEquals(this._elements[1], this._deque.removeFirst());
    }

    @Test
    void removeLast() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this._deque.removeLast();
        });
        this._deque.addLast(this._elements[0]);
        Assertions.assertFalse(this._deque.isEmpty());
        Assertions.assertNull(this._deque.removeLast());
        Assertions.assertTrue(this._deque.isEmpty());

        this._deque.addLast(this._elements[1]);
        this._deque.addLast(this._elements[2]);
        Assertions.assertFalse(this._deque.isEmpty());
        Assertions.assertEquals(this._elements[1], this._deque.removeLast());
    }
}