/*
    James Maner & Chase Harris
    Lab Section 003
    CPSC 1061: Lab 5
    2/15/2023
 */
//Import scanner object
import java.util.Scanner;
import java.util.Arrays;

public class DatingApp {
    public static void main(String[] args) {
        //Initialize scanner
        Scanner scnr = new Scanner(System.in);

        //Declare any required varibles
        String exitString = "~801~";
        String favFoodUser;
        String favMusicUser;
        String favMovieUser;
        String userFirst;
        String userLast;
        String username;
        String concatNameUser;
        String matchUsername;
        String matchFirst;
        String matchLast;
        String favFoodMatch;
        String favMusicMatch;
        String favMovieMatch;
        String concatNameMatch;
        String bestUsernameMatch = "";
        int userSnapScore;
        int userMonth;
        int userDay;
        int userYear;
        int matchYear;
        int matchMonth;
        int matchDay;
        int count = 0;
        //int j = 0;
        int matchSnapScore;
        double currentScore = 0;
        double bestScore = 0;
        boolean leapYearMatch = false;
        boolean leapYearUser = false;
       // boolean letterUsed = false;
        //int[] letterBase = new int[50];

        //Prompt user for their username
        System.out.println("Hello, user, please put in your snapchat username:");
        username = scnr.next();

        //Prompt user for their first name
        System.out.println("Put in your first name:");
        userFirst = scnr.next();

        //Prompt user for their last name
        System.out.println("Put in your last name:");
        userLast = scnr.next();

        //Create one concatenated name combining the the user's first and last name
        concatNameUser = userFirst.concat(userLast);
        //System.out.println("DEBUG: concatNameUser = " + concatNameUser);

        //Prompt user for their birth year
        System.out.println("Put in the year you were born:");
        userYear = scnr.nextInt();

        //Calculate if the user's birth year is a leap year
        if ((userYear % 4) == 0)
        {
            leapYearUser = true;
        }

        //Prompt user for the month they were born
        System.out.println("Put in your birthday month as an integer:");
        userMonth = scnr.nextInt();

        //Loop until user enters a month value between 1 and 12
        while (userMonth > 12 || userMonth < 1)
        {
            System.out.println("Invalid birthday month. Please put in a birthday month between 1 and 12:");
            userMonth = scnr.nextInt();
        }
       
        //Prompt the user for their birthday day
        System.out.println("Put in your birthday day:");
        userDay = scnr.nextInt();

        //Loop until the user enters a day value that fits within the specified month, according to whether or not it is a leap year
        if (userMonth == 1 || userMonth == 3 || userMonth == 5 || userMonth == 7 || userMonth == 8 || userMonth == 10 || userMonth == 12)
        {
            while (userDay > 31 || userDay < 1)
            {
                System.out.println("Invalid day. Please put in a valid day:");
                userDay = scnr.nextInt();
            }
        }
        else if (userMonth == 4 || userMonth == 6 || userMonth == 9 || userMonth == 11)
        {
            while (userDay > 30 || userDay < 1)
            {
                System.out.println("Invalid day. Please put in a valid day:");
                userDay = scnr.nextInt();
            }
        }
        else 
        {
            if (leapYearUser)
            {
                while (userDay > 29 || userDay < 1)
                {
                    System.out.println("Invalid day. Please put in a valid day:");
                    userDay = scnr.nextInt();
                }
            }
            else 
            {
                while (userDay > 28 || userDay < 1)
                {
                    System.out.println("Invalid day. Please put in a valid day:");
                    userDay = scnr.nextInt();
                }
            }
        }
        
        //Prompt the user for their favorite food
        System.out.println("Put in your favorite food:");
        favFoodUser = scnr.next();

        //Prompt the user for their favorite movie
        System.out.println("Put in your favorite movie:");
        favMovieUser = scnr.next();

        //Prompt the user for their favorite genre of music
        System.out.println("Put in your favorite song genre:");
        favMusicUser = scnr.next();

        //Prompt the user for their snap score
        System.out.println("Please put in your snap score:");
        userSnapScore = scnr.nextInt();
        
        //Prompt the user for the snap username of a potential match
        System.out.println("Please put the snapchat username of an account:");
        matchUsername = scnr.next();

        //If the user enters the exit string as the match username it will skip the match information
        while (!(matchUsername.equals(exitString)))
        {
            count = 0;
            //j = 0;
            currentScore = 0;
            leapYearMatch = false;
            //letterUsed = false;

            //Prompt the user for the match's first name
            System.out.println("Put in their first name:");
            matchFirst = scnr.next();

            //Prompt the user for the match's last name
            System.out.println("Put in their last name:");
            matchLast = scnr.next();

            //Create a concatenated verson of the match's name combining the first and last name
            concatNameMatch = matchFirst.concat(matchLast);
            //System.out.println("DEBUG: concatNameMatch = " + concatNameMatch);

            //Count up each similar letter between the user's concatenated name and the match's
            for (int i = 0; i < concatNameUser.length(); i++)
            {
                for (int f = 0; f < concatNameMatch.length(); f++)
                {
                    if (concatNameUser.charAt(i) == concatNameMatch.charAt(f))
                    {
                        
                        //     for (int k = 0; k < j; k++)
                        // {
                        //     if (f == letterBase[k])
                        //     {
                        //         letterUsed = true;
                        //     }
                        // }

                        // if (!letterUsed)
                        // {
                            //letterBase[j] = f;
                            //System.out.println("DEBUG: index of matching letters:" + i + " and " + f);
                            count += 1;
                           // j++;
                            break;
                       // }
                       // letterUsed = false;
                    }
                }
            }

            //System.out.println("DEBUG: Count = " + count);

            //Create an initial compatibility score based on the number of similar letters in the two names
            currentScore = count / (double) concatNameUser.length();

            //System.out.println("DEBUG: initialScore = " + currentScore);

            //Prompt the user for the match's birth year
            System.out.println("Put in the year they were born:");
            matchYear = scnr.nextInt();

            //Calculate if the match's birth year is a leap year
            if ((matchYear % 4) == 0 && (matchYear % 100) != 0)
            {
                leapYearMatch = true;
            }

            ////Prompt the user for the match's birth month
            System.out.println("Put in their birthday month as an integer:");
            matchMonth = scnr.nextInt();

            //Loop until the user enters a month value between 1 and 12
            while (matchMonth > 12 || matchMonth < 1)
            {
                System.out.println("Invalid birthday month. Please put in a birthday month between 1 and 12:");
                matchMonth = scnr.nextInt();
            }

            //Prompt the user for the match's birth day
            System.out.println("Put in their birthday day:");
            matchDay = scnr.nextInt();

            //Loop until the user enters a day value that is within the range of the specified month, according to whether it is a leap year
            if (matchMonth == 1 || matchMonth == 3 || matchMonth == 5 || matchMonth == 7 || matchMonth == 8 || matchMonth == 10 || matchMonth == 12)
            {
                while (matchDay > 31 || matchDay < 1)
                {
                    System.out.println("Invalid day. Please put in a valid day:");
                    matchDay = scnr.nextInt();
                }
            }
            else if (matchMonth == 4 || matchMonth == 6 || matchMonth == 9 || matchMonth == 11)
            {
                while (matchDay > 30 || matchDay < 1)
                {
                    System.out.println("Invalid day. Please put in a valid day:");
                    matchDay = scnr.nextInt();
                }
            }
            else 
            {
                if (leapYearMatch)
                {
                    while (matchDay > 29 || matchDay < 1)
                    {
                        System.out.println("Invalid day. Please put in a valid day:");
                        matchDay = scnr.nextInt();
                    }
                }
                else 
                {
                    while (matchDay > 28 || matchDay < 1)
                    {
                        System.out.println("Invalid day. Please put in a valid day:");
                        matchDay = scnr.nextInt();
                    }
                }
            }

            //If the user and the match's birth years are within 3 years of one another then the compatibility score is increased by 1%
            if (matchYear <= userYear + 3 && matchYear >= userYear - 3)
            {
                //System.out.println("DEBUG: Checking for if Year");
                currentScore = currentScore * 1.01;
            }

            //System.out.println("DEBUG: yearScore = " + currentScore);

            //If the user and the match's birth months are within 2 months of eachother then the compatibility score is increased by 3%
            if (matchMonth <= userMonth + 2 && matchMonth >= userMonth - 2 )
            {
                //If the user and the match's birth days are within 10 days of eachother within the same month then the compatibility score is increased by 1%
                currentScore = currentScore * 1.03;
                //System.out.println("DEBUG: Checking for if Month");
                if(matchDay <= userDay + 10 && matchDay >= userDay - 10)
                {
                    //System.out.println("DEBUG: Checking for if Day");
                    currentScore = currentScore * 1.01;
                }
            }

            //System.out.println("DEBUG: monthDayScore = " + currentScore);

            //Prompt the user for the match's favorite food
            System.out.println("Put in their favorite food:");
            favFoodMatch = scnr.next();

            //If the match's favorite food matches the favorite of the user then compatibility is increased by 2%
            if (favFoodMatch.equalsIgnoreCase(favFoodUser))
            {
                //System.out.println("DEBUG: Checking for if Food");
                currentScore = currentScore * 1.02;
            }

            //System.out.println("DEBUG: foodScore = " + currentScore);

            //Prompt the user for the match's favorite movie
            System.out.println("Put in their favorite movie:");
            favMovieMatch = scnr.next();

            //If the match's favorite movie matches the favorite of the user then compatibility is increased by 3%
            if (favMovieMatch.equalsIgnoreCase(favMovieUser))
            {
                //System.out.println("DEBUG: Checking for if Movie");
                currentScore = currentScore * 1.03;
            }

            //System.out.println("DEBUG: movieScore = " + currentScore);

            //Prompt the user for the match's favorite music genre
            System.out.println("Put in their favorite song genre:");
            favMusicMatch = scnr.next();

            //If the match's favorite music genre matches the favorite of the user then compatibility is increased by 4%
            if (favMusicMatch.equalsIgnoreCase(favMusicUser))
            {
                //System.out.println("DEBUG: Checking for if Music");
                currentScore = currentScore * 1.04;
            }

            //System.out.println("DEBUG: musicScore = " + currentScore);

            //Prompt the user for the match's snap score
            System.out.println("Please put in their snap score:");
            matchSnapScore = scnr.nextInt();

            //If the match's snap score is 0 then the program assumes they are a bot and suggests they not be dated
            if (matchSnapScore == 0)
            {
                System.out.println("Bot has been detected. Do not consider dating this user.");
                currentScore = 0;
            }

            //Create a percentage value out of the current score instead of a decimal
            currentScore = currentScore * 100;

            //If the current compatibility score is greater than the last highest compatibility score then the current score and the username is stored as the new best score and best username
            if (currentScore > bestScore)
            {
                bestScore = currentScore;
                bestUsernameMatch = matchUsername;
            }

            //Loop the functions until the exit string is entered
            System.out.println("Please put the snapchat username of an account:");
            matchUsername = scnr.next();

        }

        //Once the exit string is entered, this statement will display the best match and the compatibility rate of the best match
        System.out.printf("Your closest match is %s with a compatibility rating of %.2f", bestUsernameMatch, bestScore);
        System.out.println("%.");

       
    }
}
