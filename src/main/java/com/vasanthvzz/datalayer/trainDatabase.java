package com.vasanthvzz.datalayer;

import com.vasanthvzz.data.Passenger;
import com.vasanthvzz.data.Ticket;
import com.vasanthvzz.data.Train;

import java.util.ArrayList;
import java.util.List;


public class trainDatabase {
    private List<Train> trainList ;
    private static trainDatabase trainDatabase;
    private List<Passenger> passengerList;
    private List<Ticket> ticketList;
    private int ticketCounter;

    private trainDatabase(){
        //Add a function to load data.
        //if data is not found create new data.
        trainList = new ArrayList<Train>();
        ticketList = new ArrayList<>();
        ticketCounter += ticketList.size()+34000;
    }

    public static trainDatabase getBusDbInstance(){
        if(trainDatabase == null){
            trainDatabase = new trainDatabase();
        }

        return trainDatabase;
    }

    public List<Passenger> getPassengerList(){
        return passengerList;
    }

    public List<Ticket> getTicketList(){
        return ticketList;
    }

    public List<Train> getTrainList(){
        return trainList;
    }

    public void addTrain(Train train) {
        for(Train tempTrain : trainList){
            if(tempTrain.getNumber() == train.getNumber()){
                System.out.println("Schedule already exist");
                return;
            }
        }
        trainList.add(train);
        System.out.println("Schedule has been created successfully");
    }

    public void addTicket(Ticket ticket){
        ticket.setPNR(ticketCounter++);
        ticketList.add(ticket);
    }

    public void removeTicket(Ticket ticket){
        Train train = ticket.getTrain();
        for(Passenger passenger : ticket.getPassengerList()){
            train.getPassengerList().remove(passenger);
        }
        ticketList.remove(ticket);
    }
}
