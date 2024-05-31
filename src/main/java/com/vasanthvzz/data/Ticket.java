package com.vasanthvzz.data;


import java.util.List;

public class Ticket {
    private int PNR;
    private Train train;
    private List<Passenger> passengerList;
    private Status status;

    public Ticket() {

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ticket(List<Passenger> passengerList, int PNR, Train train) {
        this.passengerList = passengerList;
        this.PNR = PNR;
        this.train = train;
        this.status = Status.BOOKED;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void addPassenger(Passenger passenger) {
        this.passengerList.add(passenger);
    }

    public int getPNR() {
        return PNR;
    }

    public void setPNR(int PNR) {
        this.PNR = PNR;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}

