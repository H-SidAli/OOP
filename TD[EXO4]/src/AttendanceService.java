public class AttendanceService {
    private Training[] trainings;
    private int trainingCounter;

    //Constructor
    public AttendanceService() {
        this.trainings = new Training[100];
        this.trainingCounter = 0;
    }


    //addTraining
    public void addTraining(Training training){
        if(trainingCounter > 100){return;}
        this.trainings[trainingCounter++] = training;
    }

    public void recordAbsences(Workshop workshop, Student[] absentees){
        workshop.markAsConducted(absentees);
    }

    // the different displays
    public void displayEnrolledStudents() {
        System.out.println("\nEnrolled Students with Absences:");
        for (int i = 0; i < trainingCounter; i++) {
            Training t = trainings[i];
            System.out.println("\nTraining: " + t.getTrainingCode() + " - " + t.getTrainingName());
            for (int j = 0; j < t.getStudentsCount(); j++) {
                Student s = t.getEnrolledStudents()[j];
                System.out.printf("%s %s (ID: %s) - Absences: %d%n",
                        s.getFirstname(), s.getLastname(),
                        s.getStudentID(), s.getAbsCounter());
                // displaying absent workshops
                for (int k = 0; k < s.getAbsentWorkshopsCount(); k++) {
                    Workshop w = s.getAbsentWorkshops()[k];
                    System.out.printf("    %s %s%n", w.getDate(), w.getTime());
                }
            }
        }
    }

    public void displayWorkshops(Training training) {
        System.out.println("\nAll Workshops:");
        for (int i = 0; i < training.getWorkshopsCount(); i++) {
            Workshop w = training.getWorkshops()[i];
            System.out.printf("Date: %s Time: %s Status: %s%n",
                    w.getDate(), w.getTime(), w.getStatus());
        }
    }

    public void displayWorkshops(Training training, String statusFilter) {
        System.out.println("\n" + statusFilter + " Workshops:");
        for (int i = 0; i < training.getWorkshopsCount(); i++) {
            Workshop w = training.getWorkshops()[i];
            if (w.getStatus().equals(statusFilter)) {
                System.out.printf("Date: %s Time: %s%n", w.getDate(), w.getTime());
            }
        }
    }

    public void displayAbsentees(Workshop workshop) {
        System.out.println("\nAbsent Students:");
        for (Student s : workshop.getAbsentStudents()) {
            System.out.printf("%s %s%n", s.getFirstname(), s.getLastname());
        }
    }


}
