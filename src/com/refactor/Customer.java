package com.refactor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Mryang on 15-5-16.
 */
public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name){
        this.name = name;
    }

    public void addRental(Rental r){
        this.rentals.add(r);
    }

    public String getName(){
        return this.name;
    }


    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoint = 0;
        String result = "Rental record for " + getName() + "\n";
        for(Rental r : this.rentals){
            double thisAmount = 0;
            switch (r.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;
                    if(r.getDaysRented() > 2)
                        thisAmount += (r.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += r.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if(r.getDaysRented() > 3)
                        thisAmount += (r.getDaysRented() - 3) * 1.5;
                    break;
            }
            frequentRenterPoint ++;
            if(r.getMovie().getPriceCode() == Movie.NEW_RELEASE && r.getDaysRented() > 1)
                frequentRenterPoint++;

            result += "\t" + r.getMovie().getTitle() +"\t"+
                    String.valueOf(thisAmount) +"\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) +"\n";
        result += "You earned " + String.valueOf(frequentRenterPoint)+
                " frequent renter points";
        return result;
    }
}
