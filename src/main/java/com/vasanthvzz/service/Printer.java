package com.vasanthvzz.service;

import com.vasanthvzz.data.Passenger;
import com.vasanthvzz.data.Ticket;
import com.vasanthvzz.data.Train;

import java.util.List;

public class Printer {
    public static void passenger(Passenger passenger){
        System.out.println("Passenger name : "+passenger.getName() +
                "Passenger Gender : "+passenger.getGender()+
                "Passenger age : "+passenger.getAge()+
                "Passenger id : "+passenger.getId());
    }

    public static void passenger(List<Passenger> passengerList){
        for(Passenger passenger : passengerList){
            Printer.passenger(passenger);
        }
    }

    public static void ticket(List<Ticket> ticketList){
        for(Ticket ticket1 : ticketList){
            ticket(ticket1);
        }
    }

    public static void ticket(Ticket ticket){
        System.out.println("PNR number : "+ticket.getPNR());
        System.out.println("Status : "+ticket.getStatus());
        System.out.println("Train details : \n\n");
        train(ticket.getTrain());
        passenger(ticket.getPassengerList());
    }


    public static void train(Train train) {
        double travelTime = 0;
        if(train.getDepartureTime() < train.getArrivalTime()){
            travelTime =train.getArrivalTime() - train.getDepartureTime();
        }else{
            travelTime = 24-train.getDepartureTime()+train.getArrivalTime();
        }

        System.out.println("Train no :"+train.getNumber()+"  ||  name:"+train.getNumber()
                +"  ||  departure time :"+train.getDepartureTime() + "  ||  arrival time :"+train.getArrivalTime()
                +"  ||  travel time : "+travelTime+"  ||  fare : "+train.getFare() +"  ||  total seat :"+train.getTotalSeat());

    }

    public static void train(List<Train> trainList){
        for(Train train : trainList){
            train(train);
        }
    }
}
