public class Customer {
    private int customerID;
    private int attendedScreenings;

    // constructor
    public Customer(int customerID, int attended) {
        this.customerID = customerID;
        this.attendedScreenings = attended;
    }

    double getDiscount(){
        if (attendedScreenings > 25){
            return 0.05; // 5% discount
        }
        return 0;
    }

    // reserveScreening :Reserving a seat
    public Reservation reserveScreening(Screening screening){
        return screening.reserveSeat(this);
    }

    // Getters
    public int getCustomerID() {
        return customerID;
    }

    public int getAttendedScreeings() {
        return attendedScreenings;
    }

    // Setters
    public void setAttendedScreeings(int attendedScreeings) {
        this.attendedScreenings = attendedScreeings;
    }


    
}
