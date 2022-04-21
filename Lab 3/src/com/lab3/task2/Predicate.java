package com.lab3.task2;

/**
 * provides predicate interface to compare an object based on a condition
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
public interface Predicate<T> {
    /**
     * Test object based on predicate
     * @param obj object to test
     * @return test result
     */
    public boolean test(T obj);
}
