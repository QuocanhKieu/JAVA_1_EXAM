package Flight;

import BankAndFlight.Flight;

public class Main {
    public static void main(String[] args) {
        Flight myFlight = new Flight(3, "Toronto");
        myFlight.display();
        System.out.println(myFlight.getDestination());
        System.out.println(myFlight.getNumber());

    }
}
