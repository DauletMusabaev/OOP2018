package task2;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.zip.CheckedOutputStream;

public class Course implements Serializable {
    private String courseTitle;
    private Set<Integer> courseInstrs = new HashSet<>();
    private Set<Integer> courseTB = new HashSet<>();
    static ArrayList<Course> c = new ArrayList<>();
    static ArrayList<Instructor> instructors = new ArrayList<>();
    static ArrayList<Textbook> textbooks = new ArrayList<>();

    public Course(){}

    public Course(String courseTitle, String lastName, String firstName, String department, String email,int isbn, String title, String authors){
        this.courseTitle = courseTitle;
        addNewTextbook(new Textbook(isbn, title, authors));
        addNewInstructor(new Instructor(lastName, firstName, department, email));
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public boolean addNewInstructor(Instructor ins){
        if(instructors.contains(ins)) {
            if (courseInstrs.contains(instructors.indexOf(ins)))
                return false;
            courseInstrs.add(instructors.indexOf(ins));
        }else{
            instructors.add(ins);
            courseInstrs.add(instructors.size()-1);
            return true;
        }
        return false;
    }

    public boolean addNewTextbook(Textbook t){
        if(textbooks.contains(t)) {
            if (courseTB.contains(textbooks.indexOf(t)))
                return false;
            courseTB.add(textbooks.indexOf(t));
        }else{
            textbooks.add(t);
            courseTB.add(textbooks.size()-1);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        String res = "Course: " + courseTitle + "\n";
        res += "Instructors: \n";
        Iterator it = courseInstrs.iterator();
        int i = 1;
        while(it.hasNext())
            res += (i++) + ") " + instructors.get((int)it.next()).toString() + "\n";
        res += "Textbooks: \n";
        it = courseTB.iterator();
        i = 1;
        while(it.hasNext())
            res += (i++) + ") " + textbooks.get((int)it.next()).toString() + "\n";

        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Course){
            Course c = (Course) obj;
            return c.courseTitle.equals(this.courseTitle);
        }
        return false;
    }
}
