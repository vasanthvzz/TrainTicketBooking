package com.vasanthvzz.mainmenu;

import java.util.Scanner;

public class MainMenuView {

    private MainMenuModel mainMenuModel;
    private Scanner sc;

    public MainMenuView(){
        mainMenuModel = new MainMenuModel(this);
        Scanner sc = new Scanner(System.in);
    }

    public String paymentMenu() {
        System.out.println("1. Pay");
        System.out.println("2. Cancel");
        System.out.println("3. Reschedule");
        String choice = sc.next();
        return choice;
    }

    public void init() {
        mainMenuModel.init();
    }

    public void menu() {
        System.out.println("\t\t Welcome to IRCTC \n\n");
        System.out.println(" 1. Booking \n" +
                            "2. Get PNR Status \n" +
                            "3. Booked Tickets \n" +
                            "4. Cancel Ticket \n" +
                            "5. Search Train \n" +
                            "6. Change Ticket Status \n" +
                            "7. List Train Routes \n" +
                            "8. Add Train Routes \n" +
                            "9. Show all trains" );
        String choice = sc.next();
        redirectChoice(choice);
    }

    void redirectChoice(String choice){
        switch (choice){
            case "1":{
                mainMenuModel.bookTicket();
                break;
            }
            case "2":{
                mainMenuModel.showBookedTickets();
                break;
            }
            case "3":{
                mainMenuModel.getPnrStatus();
                break;
            }
            case "4":{
                mainMenuModel.cancelTicket();
                break;
            }
            case "5":{
                break;
            }
            case "6":{
                break;
            }
            case "7":{
                break;
            }
            case "8":{
                break;
            }
            case "9":{
                break;
            }
            case "0":{
                break;
            }
            default:{
                System.out.println("Invalid choice");
            }
        }
        menu();
    }
}
