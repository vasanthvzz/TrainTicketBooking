package com.vasanthvzz.mainmenu;

import com.vasanthvzz.data.Passenger;
import com.vasanthvzz.data.Ticket;
import com.vasanthvzz.data.Train;
import com.vasanthvzz.datalayer.trainDatabase;
import com.vasanthvzz.service.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenuModel {

    private MainMenuView mainMenuView;
    private trainDatabase trainDb;
    private Scanner sc = new Scanner(System.in);

    public MainMenuModel(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
        trainDb = trainDatabase.getBusDbInstance();
    }

    public void init(){
        if(trainDb.getTrainList().isEmpty()){
            System.out.println("No schedules have been found");
            System.out.println("Creating schedule !");

        }else{
            System.out.println("Schedules have been found");
            System.out.println("Do you want to create schedules(y/n)");
            if(sc.next().equalsIgnoreCase("n")){
                mainMenuView.menu();
                return;
            }
        }
        createSchedules();
    }

    public void createSchedules(){
        //Create schedules for the number of trains at the beginning of the program
        System.out.println("Enter the number of schedules  : ");
        int schedules = sc.nextInt();
        for(int i = 1; i <= schedules; i++){
            Train train = new Train();
            System.out.println("Schedule "+i);
            System.out.println("Enter train number : ");
            int trainNumber = sc.nextInt();
            train.setNumber(trainNumber);
            System.out.println("Enter train name:");
            sc.next();
            String trainName = sc.nextLine();
            train.setName(trainName);
            System.out.println("Enter departure time : ");
            double departureTime = sc.nextDouble();
            train.setDepartureTime(departureTime);
            System.out.println("Enter arrival time : ");
            double arrivalTime = sc.nextDouble();
            train.setArrivalTime(arrivalTime);
            System.out.println("Enter the number of seats :");
            int seats = sc.nextInt();
            train.setTotalSeat(seats);
            System.out.println("Enter the number of stations : ");
            int stations = sc.nextInt();
            List<String> stationNames = new ArrayList<String>();
            for(int j = 1; j <= stations; j++){
                System.out.print("Station "+j+" :");
                String station = sc.next();
                stationNames.add(station);
            }
            train.setTrainRoutes(stationNames);
            System.out.println("Enter the fare :");
            int fare = sc.nextInt();
            train.setFare(fare);
            trainDb.addTrain(train);
        }
        mainMenuView.menu();
    }

    public void bookTicket() {
        System.out.println("Enter the from station");
        String fromStation = sc.next();
        System.out.println("Enter the to Station");
        String toStation = sc.next();
        //Get the list of trains travelling at those stations
        List<Train> trainList = getTrains(fromStation,toStation);
        Printer.train(trainList);
        System.out.println("Enter the train number : ");
        int trainNumber = sc.nextInt();
        if(!isTrainAvailable(trainNumber,trainList)){
            System.out.println("Please enter the proper train number");
            return;
        }
        List<Passenger> passengerList = getPassengers();
        Train train = getTrainByNumber(trainNumber,trainList);
        System.out.println("Total fare : "+train.getFare()*passengerList.size());
        String choice  = mainMenuView.paymentMenu();
        if(choice == "1"){
            confirmTicket(train,passengerList);
        }
    }

    private void confirmTicket(Train train, List<Passenger> passengerList) {
        Ticket ticket = new Ticket();
        ticket.setTrain(train);
        for(Passenger passenger : passengerList){
            ticket.addPassenger(passenger);
            train.addPassenger(passenger);
        }
        trainDb.addTicket(ticket);
        System.out.println("Ticket has been booked with pnr number "+ticket.getPNR());
    }

    private Train getTrainByNumber(int number,List<Train> trainList){
        for(Train train:trainList){
            if(train.getNumber() == number){
                return train;
            }
        }
        return null;
    }

    private List<Passenger> getPassengers() {
        List<Passenger> passengerList = new ArrayList<>();
        System.out.println("Enter the number of passengers : ");
        int passengers = sc.nextInt();
        for(int i=0;i<passengers;i++){
            Passenger passenger = new Passenger();
            System.out.println("Enter passenger name : ");
            String name = sc.next();
            passenger.setName(name);
            System.out.println("Enter passenger age : ");
            int age = sc.nextInt();
            passenger.setAge(age);
            System.out.println("Enter passenger gender ");
            String gender = sc.next();
            passenger.setGender(gender);
            System.out.println("Enter passenger id : ");
            int id = sc.nextInt();
            passenger.setId(id);
            passengerList.add(passenger);
        }
        return passengerList;
    }

    private boolean isTrainAvailable(int number,List<Train> trainList){
        for(Train train:trainList){
            if(train.getNumber() == number){
                return true;
            }
        }
        return false;
    }

    private List<Train> getTrains(String fromStation, String toStation) {
        List<Train> trainList = trainDb.getTrainList();
        for(Train train : trainList){
            List<String> trainRoutes = train.getTrainRoutes();
            int fromIndex = 0;int toIndex = 0;
            for(int i =0;i<trainRoutes.size();i++){
                if(trainRoutes.get(i).equals(fromStation)){
                    fromIndex = i;
                }
                if(trainRoutes.get(i).equals(toStation)){
                    toIndex = i;
                }
            }
            if(fromIndex < toIndex){
                trainList.add(train);
            }
        }
        return trainList;
    }

    public void showBookedTickets() {
        List<Ticket> ticketList = trainDb.getTicketList();
        System.out.println("Total tickets booked : "+ticketList.size());
        for(Ticket ticket : ticketList){
            Printer.ticket(ticket);
        }
    }

    public void getPnrStatus() {
        System.out.println("Enter the PNR number : ");
        int pnr = sc.nextInt();
        Ticket ticket = getTicket(pnr);
        if(ticket == null){
            System.out.println("PNR not found");
            return;
        }
        Printer.ticket(ticket);
    }

    public Ticket getTicket(int pnr){
        List<Ticket> ticketList = trainDb.getTicketList();
        for(Ticket ticket : ticketList){
            if(ticket.getPNR() == pnr){
                return ticket;
            }
        }
        return null;
    }

    public void cancelTicket() {
        System.out.println("Enter the PNR number : ");
        int pnr = sc.nextInt();
        Ticket ticket = getTicket(pnr);
        if(ticket == null){
            System.out.println("PNR not found");
        }
        System.out.println("Do you want to cancel the ticket ?");{
            String choice = sc.next();
            if(choice.equals("yes")){
                trainDb.removeTicket(ticket);
                System.out.println("Ticket has been cancelled");
            }
        }
    }

    public void changeStatus(){
        System.out.println("Enter the PNR number : ");
        int pnr = sc.nextInt();
        Ticket ticket = getTicket(pnr);
        if(ticket == null){
            System.out.println("PNR not found");
        }
        pnrStatusMenu();
    }

    private void pnrStatusMenu() {
        System.out.println("");
    }
}
