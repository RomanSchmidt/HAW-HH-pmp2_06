package de.haw.javanisten.task6;

import de.hawh.kahlbrandt.ss2019bai2pm2.a06.interfaces.IDeque;
import org.jetbrains.annotations.Contract;

import java.util.NoSuchElementException;

/**
 * @author Roman Schmidt, Stanislaw Brug
 */
public class Deque<K> implements IDeque {
    private Element _firstElement;

    @Override
    public void addFirst(Object value) {
        Element first = new Element((K) value);
        Element child = this._firstElement;
        Element parent = null;
        if (null != child) {
            parent = child.getParent();
        }
        first.add(parent, child);
        this._firstElement = first;
    }

    @Override
    public void addLast(Object value) {
        Element newLast = new Element((K) value);
        Element child = this._firstElement;
        Element parent = null;
        if (null == child) {
            this._firstElement = newLast;
        } else {
            parent = child.getParent();
        }
        newLast.add(child, parent);
    }

    @Override
    public Object removeFirst() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        K deletedValue = this._firstElement.getValue();
        Element newFirst = this._firstElement.getChild();
        if (newFirst == this._firstElement) {
            this._firstElement = null;
        } else {
            this._firstElement.delete();
            this._firstElement = newFirst;
        }
        return deletedValue;
    }

    @Override
    public Object removeLast() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Element last = this._firstElement.getParent();
        K deletedValue = last.getValue();
        if (last == this._firstElement) {
            this._firstElement = null;
        } else {
            this._firstElement.getParent().delete();
        }
        return deletedValue;
    }

    @Override
    public Object getFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this._firstElement.getValue();
    }

    @Override
    public Object getLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Element last = this._firstElement.getParent();
        return last.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this._firstElement == null;
    }

    private class Element {
        private Element _child = this;
        private Element _parent = this;
        private K _value;

        Element(K value) {
            this._value = value;
        }

        K getValue() {
            return this._value;
        }

        @Contract(pure = true)
        private Element getChild() {
            return this._child;
        }

        private void setChild(Element child) {
            this._child = child;
        }

        @Contract(pure = true)
        private Element getParent() {
            return this._parent;
        }

        private void setParent(Element parent) {
            this._parent = parent;
        }

        private void add(Element parent, Element child) {
            if (null == parent) {
                parent = this;
            } else {
                parent.setChild(this);
            }
            if (null == child) {
                child = this;
            } else {
                child.setParent(this);
            }
            this.setParent(parent);
            this.setChild(child);
        }

        private void delete() {
            this.getChild().setParent(this.getParent());
            this.getChild().setChild(this.getChild());
        }
    }
}
