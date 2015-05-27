package com.refactor3;

import com.refactor.*;
import com.refactor.Movie;

/**
 * Created by Mryang on 15-5-17.
 */
public class ChildrenPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result += 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
