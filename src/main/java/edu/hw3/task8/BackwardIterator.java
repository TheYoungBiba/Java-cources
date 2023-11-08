package edu.hw3.task8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private List<T> elements;
    private int reverseIndex;

    public BackwardIterator(List<T> elements) {
        this.elements = new LinkedList<>(elements);
        this.reverseIndex = this.elements.size() - 1;
    }

    @Override
    public T next() {
        T temp = elements.get(reverseIndex);
        reverseIndex--;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return reverseIndex >= 0;
    }
}
