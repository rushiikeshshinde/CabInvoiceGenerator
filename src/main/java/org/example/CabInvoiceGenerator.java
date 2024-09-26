package org.example;

public class CabInvoiceGenerator {

    private static final double COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, double fare){
       double totalFare = (MINIMUM_COST_PER_KM*distance)+(COST_PER_TIME*fare);
       return Math.max(MINIMUM_FARE,totalFare);
    }

    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride : rides){
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

}