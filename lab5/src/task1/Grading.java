package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class Grading {

    public static void grade() {
        try {

            FileReader fr = new FileReader("C:\\work\\OOp\\lab5\\src\\task1\\scores.txt");

            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while(line != null){
                String[] s = line.split(" ");
                new Student(s[0], s[1], Integer.parseInt(s[2]));
                line = br.readLine();
            }
            br.close();
            fr.close();



            FileWriter fw = new FileWriter("C:\\work\\OOp\\lab5\\src\\task1\\grades.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            int i = 1;
            for(Student s: Student.list){

                int k = s.getScore();

                String student = i++ + ") " + s.getSurname() + " " + s.getName() + " - \"";

                if(k >= Student.best - 10) student += "A\"\n";
                else if(k >= Student.best - 20)student += "B\"\n";
                else if(k >= Student.best - 30)student += "C\"\n";
                else if(k >= Student.best - 40)student += "D\"\n";
                else student += "F\"\n";

                bw.write(student);
            }

            bw.close();
            br.close();

        }catch (FileNotFoundException fe) {
            System.out.println("File NOT FOUND");
        }catch (IOException ioe){
            System.out.println("Can't read Scores");
        }
    }

    public static void maxMinAvg(){
        try{
        File f = new File("C:\\work\\OOp\\lab5\\src\\task1\\grades.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
        BufferedWriter bw = new BufferedWriter(pw);

        pw.write("Average - " + Student.average + "\n");
        pw.write("Maximum - " + Student.best + "\n");
        pw.write("Minimum - " + Student.min + "\n");
        bw.close();
        pw.close();
        }catch (IOException ioe){
            System.out.println("Can't write Grades");
        }
    }

    public static void main(String args []){
        grade();
        maxMinAvg();



    }
}
