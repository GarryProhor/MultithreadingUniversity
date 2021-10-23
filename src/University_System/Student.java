package University_System;

public class Student {
    private String name;
    private Professor professor;
    private Faculties faculty;

    public Student (String name, Professor professor){
        this.name = name;
        this.professor = professor;
        this.faculty = null;
    }

    public void Registration () {
        System.out.println("Студент " + name + " начал регистрацию...");
    }

    public void Performance () {
        int chooseFaculty = (int) (Math.random()*(1+2)) + 1;
        switch (chooseFaculty) {
            case 1:
                faculty = Faculties.биологический;
                break;
            case 2:
                faculty = Faculties.юридический;
                break;
            case 3:
                faculty = Faculties.математический;
                break;
        }
        System.out.println("Студент " + name + " закончил регистрацию, выбрал " + faculty.name() + " факультет и приступил к выполнению заданий...");
    }

    public void Broadcast () {
        professor.setQueue(this);
        System.out.println("Студент " + name + " выполнил задания и передал преподавателю на оценку...");
    }

    public String getName() {
        return name;
    }

    public Faculties getFaculty() {
        return faculty;
    }
}
