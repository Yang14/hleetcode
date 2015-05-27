package com.refactor3;

import com.refactor.Movie;

/**
 * Created by Mryang on 15-5-17.
 */
public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result += 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
