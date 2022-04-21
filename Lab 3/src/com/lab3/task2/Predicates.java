package com.lab3.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Provides functions that accept predicates and perform tasks based on them
 * @param <T> Generic Type
 *
 * <ul>
 * <li>Workshop 3</li>
 * <li>Course: BTN415</li>
 * <li>Last Name: Hussein</li>
 * <li>First Name: Omar</li>
 * <li>ID: 118073204</li>
 * <li>Section: NBB</li>
 * <li>This assignment represents my own work in accordance with Seneca Academic Policy.</li>
 * <li>Signature OmarHussein</li>
 * <li>Date: 20/Mar/2022</li>
 * </ul>
 */
public class Predicates<T> {

    /**
     * Removes elements form collection that match the predicate
     * @param coll collection
     * @param pred predicate
     * @param <T> Generic Type
     */
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> itr = coll.iterator();
        while(itr.hasNext()) if (pred.test(itr.next())) itr.remove();
    }

    /**
     * Retains elements in a collection that match the predicate
     * @param coll collection
     * @param pred predicate
     * @param <T> Generic Type
     */
    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> itr = coll.iterator();
        while(itr.hasNext()) if (!pred.test(itr.next())) itr.remove();
    }

    /**
     * Collects elements from a collection that match the predicate into a new List
     * @param coll collection
     * @param pred predicate
     * @param <T> Generic Type
     * @return filtered list
     */
    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        for (T e : coll) if (pred.test(e)) list.add(e);
        return list;
    }

    /**
     * Finds and returns the first index of the element that match the predicate
     * @param list list
     * @param pred predicate
     * @param <T> Generic Type
     * @return index
     */
    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        for (int i = 0; i < list.size(); ++i) if (pred.test(list.get(i))) return i;
        return -1;
    }
}
