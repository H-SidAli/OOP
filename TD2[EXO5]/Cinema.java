public class Cinema {
    private String name;
    private String address;
    // an array of Rooms
    private Room[] rooms;
    private int roomCount;

    // constructor
    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.rooms = new Room[20];
        this.roomCount = 0;
    }

    //addRoom
    public void addRoom(Room room) {
        rooms[roomCount++] = room;
    }

    // displaySchedule
    public void displaySchedule() {
        System.out.println("Cinema: " + name + " | Address: " + address);
        for (Room room : rooms) {
            if (room != null) {
                room.displayScreenings();
            }
        }
    }
}
