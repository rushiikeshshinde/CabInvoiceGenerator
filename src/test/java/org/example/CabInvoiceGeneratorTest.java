package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTimeShouldReturnFare(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 2;
        double time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        assertEquals(25,fare);
    }

}