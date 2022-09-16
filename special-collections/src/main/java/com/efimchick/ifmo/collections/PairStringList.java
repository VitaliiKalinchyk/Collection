package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Collection;

class PairStringList extends ArrayList<String> {
    @Override
    public boolean add(String s) {
        return super.add(s) && super.add(s);
    }

    @Override
    public void add(int index, String element) {
        if (index > 0 && get(index).equals(get(index - 1))) {
            index++;
        }
        super.add(index, element);
        super.add(index + 1, element);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o) && super.remove(o);
    }

    @Override
    public String remove(int index) {
        if (index > 0 && get(index).equals(get(index - 1))) {
            index--;
        }
        super.remove(index);
        return super.remove(index);
    }

    @Override
    public String set(int index, String element) {
        if (index > 0 && get(index).equals(get(index - 1))) {
            index--;
        }
        super.set(index, element);
        return super.set(index + 1, element);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        if (index > 0 && get(index).equals(get(index - 1))) {
            index++;
        }
        for (String s : c) {
            add(index, s);
            index +=2;
        }
        return true;
    }
}
