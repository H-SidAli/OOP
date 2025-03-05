public class Workshop {
    private Training training;
    private String date;
    private String time;
    private String status = "planned";
    private Student[] absentStudents;

    // Constructor
    public Workshop(String date, String time) {
        this.date = date;
        this.time = time;
        this.status = "planned";
        this.absentStudents = new Student[0];
    }

    // Getters
    public Training getTraining() {
        return training;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getStatus() {
        return status;
    }
    public Student[] getAbsentStudents() {
        return absentStudents;
    }

    // Setter for the training
    public void setTraining(Training training) {
        this.training = training;
    }


    // mark as conducted with recording absentees
    public void markAsConducted(Student[] absentees){
        if(this.status.equals("conducted")){return;}
        this.status = "conducted";

        for (Student absentee : absentees){
            for (int i = 0; i < training.getStudentsCount(); i++){
                if(training.getEnrolledStudents()[i].getStudentID().equals(absentee.getStudentID())){
                    absentee.increaseAbsCounter();
                    absentee.addAbsentWorkshop(this);
                    break;
                }
            }
        }

        // storing the list of absentees
        this.absentStudents = absentees;
    }
}
