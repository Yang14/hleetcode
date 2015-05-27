package com.refactor3;

import com.refactor.Movie;

/**
 * Created by Mryang on 15-5-17.
 */
public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result += daysRented * 3;
        return result;
    }

    @Override
    public int getFrequentRenterPoint(int daysRented){
        return daysRented > 1 ? 2: 1;
    }
}
