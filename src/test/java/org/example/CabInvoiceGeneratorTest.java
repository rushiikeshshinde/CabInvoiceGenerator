package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator cabInvoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTimeShouldReturnFare(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 2;
        double time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        assertEquals(25,fare);
    }

    @Test
    public void givenLessDistanceOrTimeShouldReturnMinFare(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        double time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        assertEquals(5,fare);
    }

    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummary(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

        Ride [] rides = {new Ride(2.0,5),new Ride(0.1,1)};
        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
        assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserIDShouldReturnRides(){

        cabInvoiceGenerator = new CabInvoiceGenerator();

        Ride[] rides1 = {
                new Ride(2.0,5),
                new Ride(0.1,1),
                new Ride(3.0,6)
        };
        Ride[] rides2 = {
                new Ride(4.0,5),
                new Ride(2.0,1),
                new Ride(5.0,6)
        };

        cabInvoiceGenerator.listOfRides(rides1,1);
        cabInvoiceGenerator.listOfRides(rides2,2);

        cabInvoiceGenerator.invoicePerId(1);
        cabInvoiceGenerator.invoicePerId(2);

    }

}