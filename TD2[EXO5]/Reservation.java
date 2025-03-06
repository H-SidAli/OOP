public class Reservation {
    public static int counter = 1; // pour generer des numeros de reservation uniques
    private int reservationNumber;
    private Customer customer;
    private Screening screening;
    private double ticketPrice;
    private String status; // can take "confirmed" or "used"

    // constructor
    public Reservation(Customer customer, Screening screening, double ticketPrice) {
        this.reservationNumber = counter++;
        this.customer = customer;
        this.screening = screening;
        this.ticketPrice = ticketPrice;
        status = "confirmed";
    }

    // markAsUsed ; la validation du ticket le jour du movie screening
    public void markAsUsed() {
        if (status.equals("confirmed")) {
            status = "used";
            customer.setAttendedScreeings(customer.getAttendedScreeings() + 1);
        }
        else{
            System.out.println("Reservation already used");
        }
    }

    @Override
    public String toString() {
        return "Reservation# " + reservationNumber + " for Screening " + screening.getScreeningNumber() +
               " | Ticket Price: $" + ticketPrice + " | Status: " + status;
    }


}
