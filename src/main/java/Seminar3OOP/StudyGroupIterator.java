package Seminar3OOP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class StudyGroupIterator implements Iterator <Student>, Iterable<Student>{

    private List<Student> students = new ArrayList<>();
    protected int currentIndex = 0;


    public StudyGroupIterator(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
//        currentIndex++;
        return currentIndex < students.size();

    }

    @Override
    public Student next() {
        if (hasNext()){
            return  students.get(currentIndex++);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void remove() {
        students.remove(currentIndex);
        currentIndex=0;
    }
    public int searchStudent(String name, int age, int yearStudy){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)&&
            students.get(i).getAge()==age &&
            students.get(i).getYearofStudy()==yearStudy) {
                return i;
            }
        }
        System.out.println("Student" + name + "not found!");
        return -1;
    }

    @Override
    public String toString() {
        return students+" ";
    }

    public void setCurrentIndex(int currentIndex){
        this.currentIndex = currentIndex;
    }

    public Student getStudent(int index){
        return students.get(index);
    }
    public int getCurrentIndex(){
        return currentIndex;
    }

    @Override
    public Iterator<Student> iterator() {
        return this;
    }
    public void reset(){
        currentIndex = 0;
    }
}

