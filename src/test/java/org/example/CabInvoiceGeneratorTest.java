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
    public void givenMultipleRidesShouldReturnTotalFare(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride [] rides = {new Ride(2.0,5),new Ride(0.1,1)};
        cabInvoiceGenerator.calculateFare(rides);
    }

}