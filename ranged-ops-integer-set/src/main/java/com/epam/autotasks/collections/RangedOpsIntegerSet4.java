package com.epam.autotasks.collections;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class RangedOpsIntegerSet4 extends AbstractSet<Integer> {

    private Integer[] elements;

    private int size;

    @Override
    public boolean add(final Integer integer) {

        if (size == 0) {
            elements = new Integer[10];
            elements[0] = integer;
            size++;
            return true;
        }

        int index = size;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(integer)) {
                return false;
            }
            if (elements[i] > integer) {
                index = i;
                break;
            }
        }
        elementsCopy(index, integer);
        size++;
        return true;
    }

    private void elementsCopy(int index, int integer) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = integer;
    }

    public boolean add(int fromInclusive, int toExclusive) {
        int temp = size;
        for (int i = fromInclusive; i < toExclusive; i++) {
            add(i);
        }
        return temp != size;
    }

    @Override
    public boolean remove(final Object o) {
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                if (size > 10 && size < elements.length / 2) {
                    trimToSize();
                }
                return true;
            }
        }
        return false;
    }

    private void trimToSize() {
        elements = Arrays.copyOf(elements, size);
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        int temp = size;
        for (int i = fromInclusive; i < toExclusive; i++) {
            remove(i);
        }
        return temp != size;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<>() {

            int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor != size;
            }

            @Override
            public Integer next() {
                if (cursor == size)
                    throw new NoSuchElementException();
                return elements[cursor++];
            }
        };
    }

    @Override
    public int size() {
        return size;
    }
}
