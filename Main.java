import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Create a movie for testing
        Movie movie = new Movie("Test Movie", 2025, "Test Director",
                                new String[]{"Actor A", "Actor B"}, "Test Synopsis");

        // Create a room with ample capacity for most tests
        Room room = new Room(1, 100);

        // Create a screening in that room
        Screening screening = new Screening(201, LocalDate.now(), 
                                             LocalTime.of(18, 0), LocalTime.of(20, 0), 
                                             20.0, movie, room);
        room.addScreening(screening);

        // ------------------------------------------
        // Test 1: Customer with fewer than 25 past screenings (full price)
        System.out.println("Test 1: Customer with < 25 past screenings (full price)");
        Customer customer1 = new Customer(101, 10);  // attended 10 screenings
        Reservation res1 = customer1.reserveScreening(screening);
        // when calling res1 here it is calling the overriden toString method in Reservation class
        System.out.println("Reservation Details: " + res1 + "\n");

        // ------------------------------------------
        // Test 2: Customer with 30 past screenings (5% discount)
        System.out.println("Test 2: Customer with 30 past screenings (5% discount)");
        Customer customer2 = new Customer(102, 30);  // attended 30 screenings
        Reservation res2 = customer2.reserveScreening(screening);
        System.out.println("Reservation Details: " + res2 + "\n");

        // ------------------------------------------
        // Test 3: Customer attempting to book a screening that is already fully booked.
        System.out.println("Test 3: Screening already fully booked");
        // Create a room with capacity 1 for this test.
        Room smallRoom = new Room(2, 1);
        Screening screeningSmall = new Screening(202, LocalDate.now(), 
                                                   LocalTime.of(21, 0), LocalTime.of(23, 0), 
                                                   15.0, movie, smallRoom);
        smallRoom.addScreening(screeningSmall);
        // First customer reserves the only seat.
        Customer customer3 = new Customer(103, 5);
        Reservation res3 = customer3.reserveScreening(screeningSmall);
        // Second customer tries to reserve a seat but none are available.
        Customer customer4 = new Customer(104, 5);
        Reservation res4 = customer4.reserveScreening(screeningSmall); // Expected to fail (null)
        System.out.println("Reservation Details (should be null): " + res4 + "\n");

        // ------------------------------------------
        // Test 4: Customer trying to reserve a ticket with an invalid customer number.
        System.out.println("Test 4: Invalid customer (null)");
        Reservation resInvalid = screening.reserveSeat(null);  // Passing null to simulate invalid customer.
        System.out.println("Reservation Details (should be null): " + resInvalid + "\n");

        // ------------------------------------------
        // Test 5: Customer trying to validate a reservation with an existing (valid) reservation number.
        System.out.println("Test 5: Validate an existing reservation");
        // Create a new reservation.
        Reservation res5 = customer1.reserveScreening(screening);
        if (res5 != null) {
            // Validate (mark as used) for the first time.
            res5.markAsUsed();
            // Attempt to validate the same reservation again.
            res5.markAsUsed();  // Expected to print a message indicating it’s already used.
        }
        System.out.println();

        // ------------------------------------------
        // Test 6: Customer trying to validate a reservation with a non-existent or already used reservation number.
        System.out.println("Test 6: Validate a non-existent reservation");
        Reservation res6 = null; // Simulate a non-existent reservation.
        try {
            res6.markAsUsed();
        } catch (NullPointerException e) {
            System.out.println("Cannot validate a non-existent reservation (null reference).");
        }
    }
}
