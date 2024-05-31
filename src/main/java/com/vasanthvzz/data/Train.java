package com.vasanthvzz.data;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private int number;
    private String name;
    private double departureTime;
    private double arrivalTime;
    private List<String> trainRoutes;
    private int totalSeat;
    private int fare;
    private List<Passenger> passengerList;

    public Train(double arrivalTime, double departureTime, int fare, String name, int number, int totalSeat, List<String> trainRoutes) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.fare = fare;
        this.name = name;
        this.number = number;
        this.totalSeat = totalSeat;
        this.trainRoutes = trainRoutes;
        this.passengerList = new ArrayList<>();
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void addPassenger(Passenger passenger){
        this.passengerList.add(passenger);
    }

    public Train() {
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(double departureTime) {
        this.departureTime = departureTime;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public List<String> getTrainRoutes() {
        return trainRoutes;
    }

    public void setTrainRoutes(List<String> trainRoutes) {
        this.trainRoutes = trainRoutes;
    }
}
