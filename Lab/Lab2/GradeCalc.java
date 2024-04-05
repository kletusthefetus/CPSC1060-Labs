//Give the proper file header
/*
    James Maner & Chase Harris
    CPSC1061: Lab 2
    Lab Section 003
    1/26/2023
*/
import java.util.Scanner;
public class GradeCalc {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
         //Create a scanner object
        
        final double ZYBOOK_WEIGHT = 0.1;
        final double PROGRAMMING_WEIGHT = 0.15;
        final double CLASS_EXERCISE_WEIGHT = 0.075;
        final double PROJECT_WEIGHT = 0.15;
        final double QUIZ_WEIGHT = 0.075;
        final double EXAM_WEIGHT = 0.3;
        final double LABS_WEIGHT = 0.15;
        //Create constants here

        String firstName;
        String lastName;
        int labSection;
        double zybookAvg;
        double progAvg;
        double exerciseAvg;
        double projAvg;
        double quizAvg;
        double examOne;
        double examTwo;
        double labAvg;
        double examAvg;
        double weightGrade;
        double finalExam;
        double examGrade;

        System.out.println("Hello, can I have your first name?");
        firstName = scnr.next();

        System.out.println("Can I have your last name?");
        lastName = scnr.next();

        System.out.println("What is your lab section?");
        labSection = scnr.nextInt();

        System.out.println("What is your Zybook Participant & Challenge Activities average?");
        zybookAvg = scnr.nextDouble();

        System.out.println("What is your Programming Assignments average?");
        progAvg = scnr.nextDouble();

        System.out.println("What is your In-Class Exercises average?");
        exerciseAvg = scnr.nextDouble();

        System.out.println("What is your Projects average?");
        projAvg = scnr.nextDouble();

        System.out.println("What is your Quizzes average?");
        quizAvg = scnr.nextDouble();

        System.out.println("What is your first exam grade?");
        examOne = scnr.nextDouble();

        System.out.println("What is your second exam grade?");
        examTwo = scnr.nextDouble();

        System.out.println("What is your Labs average?");
        labAvg = scnr.nextDouble();
        //Prompt the user for their information and save it to relevant variables
            //first name, last name, lab section, 
            //Zybooks activities average, Programming Assignments average,
            //In-Class Exercises average, Project average, Quiz average,
            //First exam grade, second exam grade, lab average
        
        examAvg = (examOne + examTwo) / 2;
        //Calculate exams average with given exams
        
        weightGrade = ((zybookAvg * ZYBOOK_WEIGHT) + (progAvg * PROGRAMMING_WEIGHT) + (exerciseAvg * CLASS_EXERCISE_WEIGHT) 
        + (projAvg * PROJECT_WEIGHT) + (quizAvg * QUIZ_WEIGHT) + (examAvg * EXAM_WEIGHT) + (labAvg * LABS_WEIGHT));       
        //Calculate the user's weighted average using the constants and entered grades

        System.out.print("Ok, " + firstName + " " + lastName + " from the lab section " + labSection + " your current weighted average is ");
        System.out.printf("%.2f", weightGrade);
        System.out.println("%.");
        //Print out the user's weighted average with the correct output format
        
        System.out.println("Put in a what if score for your final:");
        finalExam = scnr.nextDouble();
        //Prompt the user to put in a what if score for their final, and read it in
        
        examAvg = (examOne + examTwo + finalExam) / 3;
        //Calculate the exams average using the variable that you used above

        weightGrade = ((zybookAvg * ZYBOOK_WEIGHT) + (progAvg * PROGRAMMING_WEIGHT) + (exerciseAvg * CLASS_EXERCISE_WEIGHT) 
        + (projAvg * PROJECT_WEIGHT) + (quizAvg * QUIZ_WEIGHT) + (examAvg * EXAM_WEIGHT) + (labAvg * LABS_WEIGHT));
        //Recaclualte the weighted average using the weighted avergae formula that you used above
        
        System.out.print("Your grade would be ");
        System.out.printf("%.2f", weightGrade);
        System.out.print("% if you got a ");
        System.out.printf("%.2f", finalExam);
        System.out.println("% on the final.");
        //Print out the new weighted average
        
        System.out.println("What would you like your final grade to be?");
        weightGrade = scnr.nextDouble();
        //Prompt the user for what final grade they would like to get, read it in from the terminal
        
        examGrade = weightGrade - ((zybookAvg * ZYBOOK_WEIGHT) + (progAvg * PROGRAMMING_WEIGHT) + (exerciseAvg * CLASS_EXERCISE_WEIGHT) 
        + (projAvg * PROJECT_WEIGHT) + (quizAvg * QUIZ_WEIGHT) + (labAvg * LABS_WEIGHT));
        finalExam = ((examGrade / EXAM_WEIGHT) * 3) - examOne - examTwo;
        //Calculate the minimum grade to get on that final 
        
        System.out.print("The minimum score on your final to get a ");
        System.out.printf("%.2f", weightGrade);
        System.out.print("% is a ");
        System.out.printf("%.2f", finalExam);
        System.out.println("%.");
        //Print out the minimum grade in the correct format
    }  
}
