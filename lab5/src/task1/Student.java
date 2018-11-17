package task1;

import java.util.ArrayList;

public class Student {
    private String name, surname;
    private int score;
    static int best = 0, min = 100, sum = 0, average;

    public static ArrayList<Student> list = new ArrayList<Student>();



    public Student(String name, String surname, int score){
        this.name = name;
        this.surname = surname;
        this.score = score;
        if(score > best)
            best = score;
        if(score < min)
            min = score;
        sum += score;
        list.add(this);
        average = sum / list.size();

    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
