package org.example;

public class CabInvoiceGenerator {

    private static final double COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;

    double calculateFare(double distance, double fare){
       return (MINIMUM_COST_PER_KM*distance)+(COST_PER_TIME*fare);
    }

}