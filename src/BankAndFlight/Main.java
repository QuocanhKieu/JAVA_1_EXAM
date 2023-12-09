package BankAndFlight;

public class Main {
    public static void main(String[] args) {
        Bank mb = new Bank(1000, 10);
        System.out.println(mb.calculateInterest());


        Flight myFlight = new Flight(3, "Toronto");
        myFlight.display();
        System.out.println(myFlight.getDestination());
        System.out.println(myFlight.getNumber());
    }
}
