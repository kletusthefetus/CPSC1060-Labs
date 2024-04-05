/*
    James Maner & Chase Harris
    CPSC 1061: Lab 3
    Lab Section 003
    1/31/2023
*/
//Import scanner
import java.util.Scanner;

public class TaxCalc {
    public static void main(String[] args) { 
        //Set up scanner
        Scanner scnr = new Scanner(System.in);
        

        //declare all double variables, characters, or constants needed for calculations
        final double MEDICARE_TAX_RATE = 0.0145;
        final double SOCIAL_SECURITY_TAX_RATE = 0.062;
        char scRes;
        char workPay;
        double workSalary; 
        double workHours;
        double hourPay;
        double deduct;
        double fedTax;
        double stateTax;
       

        //First set of questions with a yes or no input
        System.out.println("Welcome to the South Carolina tax calculator.");
        System.out.println("Are you a single resident of South Carolina? (y/n)");
        scRes = scnr.next().charAt(0);
     
        //Assigning workPay so that it does not cause a delcaration error if workpay is not declared in the switch statement
        workPay = 0;
        
        //Assessment of the y/n input, if 'n' or miscellaneous input is detected the program will close
        switch (scRes) {
            case 'y':
             System.out.println("Are you a salary worker or an hourly worker? (s/h)");
             workPay = scnr.next().charAt(0);
             break;

            case 'n':
             System.out.println("This calculator is only for South Carolina residents who are filing single. Closing the program.");
             System.exit(0);
             break;

            default:
             System.out.println("Please enter a valid option, y or n. Closing the program.");
             System.exit(0);
             break;
        }
        
        //Assigning workSalary to avoid declaration error if workSalary is not assigned in the switch statement
        workSalary = 0;
       
        //Assesment of the workPay character established in the last statment, this determines the gross income value and if a miscellaneuous input is detected it ends the program
       switch (workPay)
            {
            case 's':
             System.out.println("Input your salary:");
             workSalary = scnr.nextDouble();
             break;

            case 'h':
             System.out.println("How many hours did you work each week?");
             workHours = scnr.nextDouble();
             if (workHours >= 40)
             {
                System.out.println("You are considered a full time worker.");
             }
             else 
             {
                 System.out.println("You are considered a part time worker.");
             }
             System.out.println("What is your hourly pay?");
             hourPay = scnr.nextDouble();
             workSalary = workHours * hourPay * 50;
             break;

            default:
             System.out.println("Invalid input. Closing the program.");
             System.exit(0);
             break;
            }

        //Prompting the user to input deductions, used in later calculations
        System.out.println("What are your deductions for this year?");
        deduct = scnr.nextDouble();

        //Establishing a maximum deduction cap
        if (deduct > 12950)
        {
            deduct = 12950.00;
        }
        
        //Creating a taxable income variable to be used in the calculation of taxes, rounded up in order to avoid long double figures
        double taxIncome = Math.ceil( workSalary - deduct );

        //Calculating the federal income tax using the taxable income value, corresponding with the federal tax brackets in the lab assignment
        if (taxIncome <= 10275)
        {
            fedTax = ((taxIncome) * 0.1);
        }
        else if (taxIncome <= 41775)
        {
            fedTax = ((taxIncome - 10275) * 0.12) + (10275 * 0.1);
        }
        else if (taxIncome <= 89075)
        {
            fedTax = ((taxIncome - 41775) * 0.22) + ((41775 - 10275) * 0.12) + (10275 * 0.1);
        }
        else if (taxIncome <= 170050)
        {
            fedTax = ((taxIncome - 89075) * 0.24) + ((89075 - 41775) * 0.22) + ((41775 - 10275) * 0.12) + (10275 * 0.1);
        }
        else if (taxIncome <= 215950)
        {
            fedTax = ((taxIncome - 170050) * 0.32) + ((170050 - 89075) * 0.24) + ((89075 - 41775) * 0.22) + ((41775 - 10275) * 0.12) + (10275 * 0.1);
        }
        else if (taxIncome <= 539900)
        {
            fedTax = ((taxIncome -  215950) * 0.35) + ((215950 - 170050) * 0.32) + ((170050 - 89075) * 0.24) + ((89075 - 41775) * 0.22) + ((41775 - 10275) * 0.12) + (10275 * 0.1);
        }
        else
        {
            fedTax = ((taxIncome - 539900) * 0.37) + ((539900 -  215950) * 0.35) + ((215950 - 170050) * 0.32) + ((170050 - 89075) * 0.24) + ((89075 - 41775) * 0.22) + ((41775 - 10275) * 0.12) + (10275 * 0.1);
        }
        
        //Calculating the state income tax using the taxable income value, corresponding with the state tax brackets in the lab assignment
        if (taxIncome <= 3200)
        {
            stateTax = 0;
        }
        else if (taxIncome <= 6410)
        {
            stateTax = (taxIncome - 3200) * 0.03;
        }
        else if (taxIncome <= 9620)
        {
            stateTax = ((taxIncome - 6410) * 0.04) + ((6410 - 3200) * 0.03);
        }
        else if (taxIncome <= 12820)
        {
            stateTax = ((taxIncome - 9620) * 0.05) + ((9620 - 6410) * 0.04) + ((6410 - 3200) * 0.03);
        }
        else if (taxIncome <= 16040)
        {
            stateTax = ((taxIncome - 12820) * 0.06) + ((12820 - 9620) * 0.05) + ((9620 - 6410) * 0.04) + ((6410 - 3200) * 0.03);
        }
        else 
        {
            stateTax = ((taxIncome - 16040) * 0.07) + ((16040 - 12820) * 0.06) + ((12820 - 9620) * 0.05) + ((9620 - 6410) * 0.04) + ((6410 - 3200) * 0.03);
        }

        //Calculation of medicare tax, social security, total taxes, and net income after taxes
        double medCareCost = taxIncome * MEDICARE_TAX_RATE;
        double ssCost = taxIncome * SOCIAL_SECURITY_TAX_RATE;
        double totalTax = fedTax + stateTax + medCareCost + ssCost;
        double netIncome = workSalary - totalTax;

        //Add a print statement to show all of the tax information that you just calculated
        System.out.println("HERE IS YOUR TAX INFORMATION");
        System.out.print("GROSS INCOME: $");
        System.out.printf("%.2f", workSalary);
        System.out.println("");
        System.out.print("TOTAL DEDUCTIONS: $");
        System.out.printf("%.2f", deduct);
        System.out.println("");
        System.out.println("TAXES");
        System.out.print("  SOCIAL SECURITY: $");
        System.out.printf("%.2f", ssCost);
        System.out.println("");
        System.out.print("  MEDICARE: $");
        System.out.printf("%.2f", medCareCost);
        System.out.println("");
        System.out.print("  FEDERAL INCOME TAX: $");
        System.out.printf("%.2f", fedTax);
        System.out.println("");
        System.out.print("  STATE INCOME TAX: $");
        System.out.printf("%.2f", stateTax);
        System.out.println("");
        System.out.print("TOTAL TAXES: $");
        System.out.printf("%.2f", totalTax);
        System.out.println("");
        System.out.print("NET INCOME: $");
        System.out.printf("%.2f", netIncome);
        System.out.println("");
        
       
        
    }
}