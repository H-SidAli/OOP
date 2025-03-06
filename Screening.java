// importing LocalDate and LocalTime classes from java.time package
import java.time.*;


public class Screening {
    private int screeningNumber;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double ticketPrice;
    private Room room;
    private Movie movieBeingShown;
    private Reservation[] reservations;
    private int reservationsCount;


    // constructor
    public Screening(int screeningNumber, LocalDate date, LocalTime startTime, LocalTime endTime, double ticketPrice, Movie movieBeingShown, Room room) {
        this.screeningNumber = screeningNumber;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.room = room;
        this.movieBeingShown = movieBeingShown;
        this.reservations = new Reservation[room.getCapacity()];
        this.reservationsCount = 0;
    }

    // checkAvailability
    public boolean checkAvailability() {
        return reservationsCount < room.getCapacity();
    }

    public void getScreeningDetails() {
        System.out.println("--------------------------------------------------");
        System.out.println("Screening Number: " + screeningNumber);
        System.out.println("Date: " + date + " | Start: " + startTime + " | End: " + endTime);
        System.out.println("Ticket Price: $" + ticketPrice);
        System.out.println(movieBeingShown.getMovieDetails());
        System.out.println("Available seats: " + (room.getCapacity() - reservationsCount));
        System.out.println("--------------------------------------------------");
    }

    // reserveSeat
    public Reservation reserveSeat(Customer customer) {
        if (customer == null) {
            System.out.println("Invalid customer.");
            return null;
        }
        if (checkAvailability()) {
            double discount = customer.getDiscount();
            double finalPrice = ticketPrice * (1 - discount);
            Reservation res = new Reservation(customer, this, finalPrice);
            reservations[reservationsCount++] = res;
            System.out.println("Reservation confirmed: " + res);
            return res;
        } else {
            System.out.println("No seats available for screening " + screeningNumber);
            return null;
        }
    }
    // Getters
    public int getScreeningNumber() {
        return screeningNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public Room getRoom() {
        return room;
    }

    public int getReservedSeats() {
        return reservationsCount;
    }

    public Movie getMovieBeingShown() {
        return movieBeingShown;
    }
 
}
