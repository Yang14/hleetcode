package com.refactor3;

/**
 * Created by Mryang on 15-5-16.
 */
public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private String title;
    private Price price;

    public Movie(String title,int priceCode){
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case Movie.CHILDREN:
                price = new ChildrenPrice();
                break;
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
        }
    }

    public String getTitle(){
        return this.title;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoint(int daysRented){
        return price.getFrequentRenterPoint(daysRented);
    }
}
