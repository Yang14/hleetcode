package com.refactor3;

/**
 * Created by Mryang on 15-5-17.
 */
public abstract class Price {
    public abstract int getPriceCode();
    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoint(int daysRented){
        return 1;
    }

}
