package University_System;

import java.util.LinkedList;
import java.util.Queue;

public class Professor {
    private String name;
    private Queue<Student> queue;
    private University university;
    private int DoneCounter;

    public Professor(String name, University university) {
        this.name = name;
        this.university = university;
        queue = new LinkedList<>();
    }

    public void Examination() {
        System.out.println("Профессор начал проверку работы студента " + queue.peek().getName());
    }

    public void SubmitForDeanOffice() {
        int markForCurrentStudent = (int) (Math.random()*(1+4)) + 1;
        university.setStudentsNames(queue.peek());
        university.setStudentsMarks(markForCurrentStudent);
        System.out.println("Профессор передал результат работы студента " + queue.poll().getName() + " в деканат на решение");
        DoneCounter++;
    }

    public synchronized void setQueue(Student student) {
        queue.add(student);
    }

    public int getDoneCounter() {
        return DoneCounter;
    }

    public Queue<Student> getQueue() {
        return queue;
    }
}
