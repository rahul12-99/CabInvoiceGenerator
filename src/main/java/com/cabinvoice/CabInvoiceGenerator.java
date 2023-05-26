package com.cabinvoice;

public class CabInvoiceGenerator {
    public static final double COST_PER_KM = 10.0;
    public static final double COST_PER_MIN = 1.0;
    public static final double MIN_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MIN);
        if (totalFare < 5) {
            return MIN_FARE;
        }
        return totalFare;
    }

    public double invoiceGenerators(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public InvoiceSummary invoiceGeneratorNew(Ride[] rides) {
        int totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public InvoiceSummary invoiceGeneratorList(Ride[] rides, Ride[] ridesTwo) {
        int fareUserOne = 0, fareUserTwo = 0, totalFare;
        for (Ride ride : rides) {
            fareUserOne += this.calculateFare(ride.distance, ride.time);
        }
        for (Ride ride : ridesTwo) {
            fareUserTwo += this.calculateFare(ride.distance, ride.time);
        }
        totalFare = fareUserOne + fareUserTwo;
        return new InvoiceSummary(rides.length, totalFare);
    }
}
