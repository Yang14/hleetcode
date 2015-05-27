package com.refactor2;

import java.util.ArrayList;
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

        String result = "Rental record for " + getName() + "\n";

        for(Rental e : this.rentals){
            result += "\t" + e.getMovie().getTitle() +"\t"+
                    String.valueOf(e.getCharge()) +"\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalAmount()) +"\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoint())+
                " frequent renter points";
        return result;
    }

    private double amountFor(Rental aRental){
        return aRental.getCharge();
    }

    private double getTotalAmount(){
        double result = 0;
        for(Rental e : this.rentals){
            result += e.getCharge();
        }
        return result;
    }

    private double getFrequentRenterPoint(){
        int result = 0;
        for(Rental e : this.rentals){
            result +=e.getFrequentRenterPoint();
        }
        return result;
    }
}
