import java.util.*;
import java.io.*;

// Henadzi Kirykovich CS 210
// 5/22/2025
// Description: Read input from file, sve to array, sorting by  1Math and 2Physics, calculating average 

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner promt = new Scanner(System.in); // declaring object for scanner input
        Scanner inputFile = new Scanner(new File("C:\\Users\\info\\Desktop\\CS1-2\\QQQ2\\score.txt")); // connetion path to file
        PrintStream out = new PrintStream(new File("C:\\Users\\info\\Desktop\\CS1-2\\QQQ2\\above.txt")); // save result of sorting to new file

        int myChoice; // user's choice subject
        boolean isValid = true; // flag for stopping loop
        int gradeMath, gradePhysics, numberOfStudent = 0;
        int sumOfMath = 0; // sum of garade of Math
        int sumOfPysics = 0; // sum of garade of Physics
       
        while (inputFile.hasNext()) {
            inputFile.next(); // read name from file
            gradeMath = inputFile.nextInt();
            gradePhysics = inputFile.nextInt();
            sumOfMath = sumOfMath + gradeMath;
            sumOfPysics = sumOfPysics + gradePhysics;
            numberOfStudent++; // counting number of students
        }
        
        Double averageMath = (double) sumOfMath / numberOfStudent;
        Double averagePhysics = (double) sumOfPysics / numberOfStudent;

 
        String [] name = new String[numberOfStudent];
        int[] math = new int[numberOfStudent];
        int[] physics = new int[numberOfStudent];
        
        inputFile = new Scanner(new File("C:\\Users\\info\\Desktop\\CS1-2\\QQQ2\\score.txt")); // !!!!! re - open file again to read data

        for (int i=0; i < numberOfStudent; i++) {
            name[i] = inputFile.next(); // read name from file and save to array
            math[i] = inputFile.nextInt(); // read math grade from file and save to array
            physics[i] = inputFile.nextInt(); // read physics grade from file and save to array
        }


        do {
            System.out.print("Selecte a subject 1) Math   2)Physics: ");
            myChoice = promt.nextInt(); // input choice

            if (myChoice == 1){ 
                isValid = false;
                System.out.println("Name" + "      " + "Math" +"     " + "Physics");
                System.out.println("______________________________________");           

                for (int i = 0; i < numberOfStudent; i++) {
                    if (math[i] > averageMath) {
                        out.printf("%-10s %-10d %-10d\n", name[i], math[i], physics[i]);
                        System.out.printf("%-10s %-10d %-10d\n", name[i], math[i], physics[i]);
                    }
                }
                 System.out.printf("Average of Math: %2.1f\n", averageMath);

            } else if (myChoice == 2) {
                isValid = false;
                System.out.println("Name" + "      " + "Math" +"     " + "Physics");
                System.out.println("______________________________________");           

                for (int i = 0; i < numberOfStudent; i++) {
                    if (physics[i] > averagePhysics) {
                        out.printf("%-10s %-10d %-10d\n", name[i], math[i], physics[i]);
                        System.out.printf("%-10s %-10d %-10d\n", name[i], math[i], physics[i]);
                    }
                }
                 System.out.printf("Average of Physics: %2.1f\n", averagePhysics);

            };    

        } while (isValid);
    }
}
