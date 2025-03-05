public class Student {
    private String firstname;
    private String lastname;
    private String studentID;
    private int AbsCount;
    // details about student absents
    private Workshop[] absentWorkshops;
    private int absentWorkshopsCount;

    public Student(String firstname, String lastname, String studentID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentID = studentID;
        this.AbsCount = 0;
        this.absentWorkshops = new Workshop[50];
        this.absentWorkshopsCount = 0;
    }

    public void increaseAbsCounter(){
        this.AbsCount++;
    }

    // Getters
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getStudentID() {
        return studentID;
    }
    public int getAbsCounter() {
        return AbsCount;
    }
    public Workshop[] getAbsentWorkshops() {
        return absentWorkshops;
    }
    public int getAbsentWorkshopsCount() {
        return absentWorkshopsCount;
    }

    // method to add absent workshop
    public void addAbsentWorkshop(Workshop workshop){
        if(absentWorkshopsCount > 50){return;}
        absentWorkshops[absentWorkshopsCount++] = workshop;
    }


    

}