package com.lab3.task1;

import java.util.Scanner;

/**
 * Implementation and Tester class for double array functional interface
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
public class DoubleFunctions {

    /**
     * Returns the max value of the given array
     */
    public static final DoubleArrayFunctions max = (double[] arr)->{
        double _max = arr[0];
        for(double d : arr)
            if(d > _max) _max = d;
        return _max;
    };

    /**
     * Returns the min value of the given array
     */
    public static final DoubleArrayFunctions min = (double[] arr)->{
        double _min = arr[0];
        for(double d : arr)
            if(d < _min) _min = d;
        return _min;
    };

    /**
     * Returns the sum value of the given array
     */
    public static final DoubleArrayFunctions sum = (double[] arr)->{
        double _sum = 0;
        for(double d : arr)
            _sum += d;
        return _sum;
    };

    /**
     * Returns the avg value of the given array
     */
    public static final DoubleArrayFunctions avg = (double[] arr)-> sum.applyDouble(arr) / arr.length;

    /**
     * Counts the number of matching values of the given value in an array of doubles passed to its functional interface
     * @param value value to be tested
     * @return count of matching values
     */
    public static DoubleArrayFunctions counter( double value ) {
        return (double[] arr) -> {
            int _cnt = 0;
            for(double d : arr)
                if(d == value) ++_cnt;
            return _cnt;
        };
    }

    /**
     * Tests the functional interface using user input from System.in
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("TASK 1 -->\n");
        System.out.print("How many elements would you like to test? ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        double[] doubleArray = new double[size];
        for (int i = 0; i < size; ++i)
            doubleArray[i] = scan.nextDouble();

        System.out.println("max value is : " + max.applyDouble(doubleArray));
        System.out.println("min value is : " + min.applyDouble(doubleArray));
        System.out.println("sum value is : " + sum.applyDouble(doubleArray));
        System.out.println("avg value is : " + avg.applyDouble(doubleArray));

        System.out.print("check count for element -> ");
        double count = scan.nextDouble();
        System.out.println(count + " has " + ((int)counter(count).applyDouble(doubleArray)) + " copies in the array");

        System.out.println("-------------------------------------\n");
    }

}
