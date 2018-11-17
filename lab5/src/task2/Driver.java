package task2;

import java.io.*;
import java.util.*;


public class Driver  {
    static Scanner sc = new Scanner(System.in);
    static private boolean logadmin = true;



    private static boolean checkLogin(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\work\\OOp\\lab5\\src\\task2\\admin.txt"));
            String log = sc.next();
            String pass = sc.next();
            String hash = "";
            if(log.equals(br.readLine().split(" ")[1])){
                for(int i = 0; i < pass.length(); i++)
                    hash += (char)(pass.charAt(i)+log.charAt(i%log.length()));
                if(hash.equals(br.readLine().split(" ")[1]))
                    return true;
            }
            return false;
        }catch (FileNotFoundException fe){
            System.out.println("File NOT FOUND");
        }catch (IOException e){
            System.out.println("Can't read Scores");
        }
        return false;
    }

    private static void adminMenu(){
        System.out.println("Choose operation (enter number from 1 to 4): ");
        System.out.println("1) Add new course");
        System.out.println("2) Add new textbook");
        System.out.println("3) Add new instructor");
        System.out.println("4) Clear data");
        System.out.println("5) exit");
        int oper = sc.nextInt();
        if(oper >= 1 && oper <=5) {
            try {
                BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileWriter(new File("C:\\work\\OOp\\lab5\\src\\task2\\admin.txt"), true)));
                if(logadmin){
                    bw.write(new Date() + " admin logged in to system\n");
                    logadmin = false;
                }
                switch (oper){
                    case 1:
                        System.out.println("Adding course with Instructor and Textbook:");
                        String zhai = sc.nextLine();
                        System.out.print("Course title:");
                        String courseTitle = sc.nextLine();
                        System.out.print("Instructor FirstName:");
                        String fn = sc.nextLine();
                        System.out.print("Instructor LastName:");
                        String ln = sc.nextLine();
                        System.out.print("Instructor Department:");
                        String dep = sc.nextLine();
                        System.out.print("Instructor email:");
                        String email = sc.nextLine();
                        System.out.print("Textbook Title:");
                        String title = sc.nextLine();
                        System.out.print("Textbook authors:");
                        String auth = sc.nextLine();
                        System.out.print("Textbook isbn:");
                        int isbn  = sc.nextInt();

                        Course newcourse = new Course();
                        newcourse.setCourseTitle(courseTitle);

                        if(!Course.c.contains(newcourse)){
                            Course.c.add(newcourse);
                            bw.write( new Date()+ " admin added new course \"" + courseTitle + "\"\n");
                        }
                        if(Course.c.get(Course.c.indexOf(newcourse)).addNewInstructor(new Instructor(ln, fn, dep, email)))
                            bw.write( new Date()+ " admin added new Instructor \"" + ln + " " + fn + "\"\n");
                        if(Course.c.get(Course.c.indexOf(newcourse)).addNewTextbook(new Textbook(isbn, title, auth)))
                            bw.write( new Date()+ " admin added new Textbook \"" + title + "\"\n");
                        break;
                    case 2:

                        System.out.println("Adding Textbook: \n");

                        zhai = sc.nextLine();
                        System.out.print("Course Title:");
                        courseTitle = sc.nextLine();
                        System.out.print("Textbook Title:");
                        title = sc.nextLine();
                        System.out.print("Textbook authors:");
                        auth = sc.nextLine();
                        do {
                            System.out.print("Textbook isbn:");
                        }
                        while (!sc.hasNextInt());
                        isbn  = sc.nextInt();

                        newcourse  = new Course();
                        newcourse.setCourseTitle(courseTitle);

                        if(!Course.c.contains(newcourse)){
                            Course.c.add(newcourse);
                            bw.write( new Date()+ " admin added new course \"" + courseTitle + "\"\n");
                        }
//                        if(Course.c.get(Course.c.indexOf(newcourse)).addNewInstructor(new Instructor(ln, fn, dep, email)))
//                            bw.write( new Date()+ " admin added new Instructor \"" + ln + " " + fn + "\"\n");
                        if(Course.c.get(Course.c.indexOf(newcourse)).addNewTextbook(new Textbook(isbn, title, auth)))
                            bw.write( new Date()+ " admin added new Textbook \"" + title + "\"\n");

//                        if(!Course.c.contains(newcourse)) {
//                            Course.c.add(newcourse);
//                            if (Course.c.get(Course.c.indexOf(newcourse)).addNewTextbook(new Textbook(isbn, title, auth)))
//                                bw.write(new Date() + " admin added new Textbook \"" + title + "\"\n");
//                        }
                        break;
                    case 3:
                        System.out.println("Adding instructor \n");

                        zhai = sc.nextLine();
                        System.out.print("Course title:");
                        courseTitle = sc.nextLine();
                        System.out.print("Instructor's FirstName:");
                        fn = sc.nextLine();
                        System.out.print("Instructor's LastName:");
                        ln = sc.nextLine();
                        System.out.print("Instructor's Department:");
                        dep = sc.nextLine();
                        System.out.print("Instructor's email:");
                        email = sc.nextLine();

                        newcourse  = new Course();
                        newcourse.setCourseTitle(courseTitle);

                        if(!Course.c.contains(newcourse)){
                            Course.c.add(newcourse);
                            bw.write( new Date()+ " admin added new course \"" + courseTitle + "\"\n");
                        }
                        if(Course.c.get(Course.c.indexOf(newcourse)).addNewInstructor(new Instructor(ln, fn, dep, email)))
                            bw.write( new Date()+ " admin added new Instructor \"" + ln + " " + fn + "\"\n");

//                        if(!Course.c.contains(newcourse)) {
//                            Course.c.add(newcourse);
//                            if (Course.c.get(Course.c.indexOf(newcourse)).addNewInstructor(new Instructor(ln, fn, dep, email)))
//                                bw.write(new Date() + " admin added new Instructor \"" + ln + " " + fn + "\"\n");
//                        }
                        break;
                    case 4:
                        Course.c.clear();
                        Course.textbooks.clear();
                        Course.instructors.clear();
                        break;
                    case 5:
                        return;
                }
                bw.close();
                adminMenu();

            } catch (FileNotFoundException fe) {
                System.out.println("File NOT FOUND");
            } catch (IOException e) {
                System.out.println("Can't read Scores");
            }
        }else{
            adminMenu();
        }
    }

    private static void adminMode(){
        System.out.println("Write login and password separated by space");
        if(checkLogin())
            adminMenu();
        else{
            System.out.println("Wrong login or password!!");
            adminMode();
        }

    }

    private static void userMode(){
        if(Course.c.size() > 0) {
            System.out.println("\n\nChoose code of Course for display information\n");
            for (int i = 0; i < Course.c.size(); i++) {
                System.out.println((i+1) + ") " + Course.c.get(i).getCourseTitle());
            }
            System.out.println("Write course number from 1 to " + Course.c.size());
            int n;
            while(!sc.hasNextInt()){}
                n = sc.nextInt();
                if (n >= 1 && n <= Course.c.size())
                    System.out.print(Course.c.get(n - 1));
                else {
                    System.out.println("Error!!! Enter code of course!!!");
                    userMode();
                    return;
                }

                System.out.println("\n\nEnter '0' for exit or something to show courses\n");
                while(!sc.hasNextInt()){}
                n = sc.nextInt();
                if (n != 0)
                    userMode();
        }else{
            System.out.println("Courses not found");
        }
    }

    private static void StartMenu(){

        System.out.println("Please, choose mode: \"0\" - admin mode; \"1\" - user mode; \"-1\" - to exit");
        int mode = sc.nextInt();
        if(mode == 1)
            userMode();
        else if(mode == 0)
            adminMode();
        else if(mode == -1)
            return;
        else
            System.out.println("Wrong choose!!! Enter '0' or '1' or '-1' for choice");

        StartMenu();
    }

    static void serialize(boolean b){
        try{
            if(b){
                ObjectInputStream ois= new ObjectInputStream(new FileInputStream("courses.txt"));
                Course.c = (ArrayList<Course>) ois.readObject();
                ois= new ObjectInputStream(new FileInputStream("textbooks.txt"));
                Course.textbooks = (ArrayList<Textbook>) ois.readObject();
                ois = new ObjectInputStream(new FileInputStream("instructors.txt"));
                Course.instructors = (ArrayList<Instructor>) ois.readObject();
            }else{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("courses.txt"));
                oos.writeObject(Course.c);
                oos = new ObjectOutputStream(new FileOutputStream("textbooks.txt"));
                oos.writeObject(Course.textbooks);
                oos = new ObjectOutputStream(new FileOutputStream("instructors.txt"));
                oos.writeObject(Course.instructors);
            }

        } catch (FileNotFoundException fe) {
            System.out.println("File NOT FOUND");
        } catch (IOException e) {
            System.out.println("Can't read Scores");
        } catch (ClassNotFoundException fe){
            System.out.println("Class not found");
        }

    }

    public static void main(String args[]){
        serialize(true);
        StartMenu();
        serialize(false);

    }


}
