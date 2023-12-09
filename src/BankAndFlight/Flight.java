package BankAndFlight;

public class Flight {
    private int number;
    private String destination;

    public Flight(int number, String destination) {
        this();
        if (number > 0) {
            this.number = number;
            this.destination = destination;
        }
    }

    public Flight() {
        number = 0;
        destination = "";
    }

    public void display() {
        System.out.println(number + ", "+destination);
    }

    public int getNumber() {
        return number;
    }

    public String getDestination() {
        return destination;
    }
}
