package main;

public class NewMovie extends Movie{
    public NewMovie(String newTitle, int newPriceCode) {
        super(newTitle, newPriceCode);
    }

    public double calculateCharge(int daysRented) {
        return daysRented * 3;
    }
}
