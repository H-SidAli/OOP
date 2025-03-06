public class Room {
    private int roomID;
    private int seatingCapacity;
    private Screening[] screenings;
    private int screeningCount;

    // constructor
    public Room(int roomID, int seatingCapacity) {
        this.roomID = roomID;
        this.seatingCapacity = seatingCapacity;  
        this.screenings = new Screening[20];
        this.screeningCount = 0;
    }

    // display schedule
    public void displayScreenings() {
        for (Screening screening : screenings) {
            if (screening != null) {
                screening.getScreeningDetails();
            }
        }
    }

    // addScreening
    public void addScreening(Screening screening) {
        if (screeningCount < screenings.length) {
            screenings[screeningCount++] = screening;
        }
    }

    // getCapacity
    public int getCapacity() {
        return seatingCapacity;
    }


    
}
