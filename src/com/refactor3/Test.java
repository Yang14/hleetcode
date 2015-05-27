package com.refactor3;

/**
 * Created by Mryang on 15-5-16.
 */
public class Test {

    @org.junit.Test
    public void statement(){
        String name = "John";
        Customer c = new Customer(name);
        Movie m1 = new Movie("XMan", Movie.REGULAR);
        Movie m2 = new Movie("Xiyy", Movie.CHILDREN);
        Rental r1 = new Rental(m1,3);
        Rental r2 = new Rental(m2,1);
        c.addRental(r1);
        c.addRental(r2);

        String result = c.statement();
        System.out.println(result);
    }


}
