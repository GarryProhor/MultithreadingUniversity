package University_System;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class University {
    private String name;
    private int DoneFinal;
    private Queue<Student> studentsNames;
    private Queue<Integer> studentsMarks;
    private HashMap<String, Integer> ResultsTable;

    public University(String name) {
        this.name = name;
        studentsNames = new LinkedList<>();
        studentsMarks = new LinkedList<>();
        ResultsTable = new HashMap<>();
        DoneFinal = 0;
    }

    public void Decide() {
        System.out.println("Деканат принимает решение по зачислению или отказу в зачислении студенту: " + studentsNames.peek().getName());
    }

    public void Final() {
        switch (studentsNames.peek().getFaculty()) {
            case биологический:
                if (studentsMarks.peek() < 3) {
                    System.out.println("Студент " + studentsNames.peek().getName() + " не был зачислен на биологический факультет с баллом " + studentsMarks.peek());
                } else {
                    System.out.println("Студент " + studentsNames.peek().getName() + " был зачислен на биологический факультет с баллом " + studentsMarks.peek());
                }
                ResultsTable.put(studentsNames.poll().getName(), studentsMarks.poll());
                DoneFinal++;
                break;
            case юридический:
                if (studentsMarks.peek() < 4) {
                    System.out.println("Студент " + studentsNames.peek().getName() + " не был зачислен на юридический факультет с баллом " + studentsMarks.peek());
                } else {
                    System.out.println("Студент " + studentsNames.peek().getName() + " был зачислен на юридический факультет с баллом " + studentsMarks.peek());
                }
                ResultsTable.put(studentsNames.poll().getName(), studentsMarks.poll());
                DoneFinal++;
                break;
            case математический:
                if (studentsMarks.peek() < 5) {
                    System.out.println("Студент " + studentsNames.peek().getName() + " не был зачислен на математический факультет с баллом " + studentsMarks.peek());
                } else {
                    System.out.println("Студент " + studentsNames.peek().getName() + " был зачислен на математический факультет с баллом " + studentsMarks.peek());
                }
                ResultsTable.put(studentsNames.poll().getName(), studentsMarks.poll());
                DoneFinal++;
                break;
        }
    }

    public HashMap<String, Integer> getResultsTable() {
        return ResultsTable;
    }

    public int getDoneFinal() {
        return DoneFinal;
    }

    public Queue<Student> getStudentsNames() {
        return studentsNames;
    }

    public Queue<Integer> getStudentsMarks() {
        return studentsMarks;
    }

    public void setStudentsNames(Student student) {
        studentsNames.add(student);
    }

    public void setStudentsMarks(int currentMark) {
        studentsMarks.add(currentMark);
    }
}
