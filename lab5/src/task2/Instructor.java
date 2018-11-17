package task2;

import java.io.Serializable;

public class Instructor implements Serializable {

    private String lastName, firstName, department, email;

    public Instructor(String lastName, String firstName, String department, String email){
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + email + " " + department;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Instructor){
            Instructor i = (Instructor) obj;
            return i.email.equals(this.email) && i.department.equals(this.department) && i.lastName.equals(this.lastName) && i.firstName.equals(this.firstName);
        }
        return false;
    }
}
