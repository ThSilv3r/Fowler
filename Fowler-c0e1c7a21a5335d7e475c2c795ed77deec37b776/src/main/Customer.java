package main;

import java.lang.*;
import java.util.*;

public class Customer {
    private final String name;
    private final Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    }
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }
    public String getName (){
        return name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount;
            Rental aRental = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = aRental.getCharge();
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && aRental.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + aRental.getMovie().getTitle()+ "\t" + "\t" + aRental.getDaysRented() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }

}
    