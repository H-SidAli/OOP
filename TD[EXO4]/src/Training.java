public class Training {
    private String trainingCode;
    private String trainingName;
    private Student[] enrolledStudents;
    private Workshop[] workshops;
    private int studentsCount;
    private int workshopsCount;


    // Constructor
    public Training(String training_code, String training_name) {
        this.trainingCode = training_code;
        this.trainingName = training_name;
        this.enrolledStudents = new Student[30];
        this.workshops = new Workshop[30];
        this.studentsCount = 0;
        this.workshopsCount = 0;
    }

    // Getters
    public String getTrainingCode() {
        return trainingCode;
    }
    public String getTrainingName() {
        return trainingName;
    }
    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }
    public Workshop[] getWorkshops() {
        return workshops;
    }
    public int getStudentsCount() {
        return studentsCount;
    }
    public int getWorkshopsCount() {
        return workshopsCount;
    }

    //addStudent
    public boolean addStudent(Student student){
        if (studentsCount > 30){return false;}
        enrolledStudents[studentsCount++] = student;
        return true;
    }

    public boolean addWorkshop(Workshop workshop){
        if (workshopsCount > 10){return false;}
        workshops[workshopsCount++] = workshop;
        workshop.setTraining(this);
        return true;
    }


}