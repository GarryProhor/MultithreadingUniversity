import University_System.Professor;
import University_System.Student;
import University_System.University;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        University university = new University("Универ");
        Professor professor = new Professor("Профессор", university);
        Student student1 = new Student("Пётр", professor);
        Student student2 = new Student("Иван", professor);
        Student student3 = new Student("Денис", professor);
        Student student4 = new Student("Павел", professor);

        StudentThread studentThread1 = new StudentThread(student1);
        StudentThread studentThread2 = new StudentThread(student2);
        StudentThread studentThread3 = new StudentThread(student3);
        StudentThread studentThread4 = new StudentThread(student4);

        ProfessorThread professorThread = new ProfessorThread(professor);
        UniversityThread universityThread = new UniversityThread(university);

        studentThread1.start();
        studentThread2.start();
        studentThread3.start();
        studentThread4.start();

        professorThread.start();
        universityThread.start();
    }

    static class StudentThread extends Thread {
        private Student student;

        StudentThread(Student student) {
            this.student = student;
        }

        public void run() {
            student.Registration();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            student.Performance();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            student.Broadcast();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ProfessorThread extends Thread {
        private Professor professor;

        ProfessorThread(Professor professor) {
            this.professor = professor;
        }

        public void run() {
            while (professor.getDoneCounter() != 4) {
                if (professor.getQueue().size() == 0) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    professor.Examination();
                    try {
                        sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    professor.SubmitForDeanOffice();
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class UniversityThread extends Thread {
        private University university;

        UniversityThread(University university) {
            this.university = university;
        }

        public void run() {
            while (university.getDoneFinal() != 4) {
                if (university.getStudentsNames().size() == 0 && university.getStudentsMarks().size() == 0) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    university.Decide();
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    university.Final();
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Итоговые оценки абитуриентов " + university.getResultsTable());
        }
    }
}
