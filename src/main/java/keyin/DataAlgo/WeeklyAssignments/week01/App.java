package week01;

/*
Calculate the average temperature, and give how many days are above the average temperature
  1. Take an input from the user (eg. 5)
  2. Prompt the user to enter all the 5 numbers (temperature values)
  3. Calculate the average temperature
  4. Given the average temperature, how many of the numbers in the line 2 are above the average temperature?

Fun additions:
    * temps only accepted for earth temperatures.
    * TempAnalysis can accept any array length, it's decided at app level.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TempAnalysis tempAnalysis = new TempAnalysis(new Temp[0]);
        int USER_INPUT_TEMPS = 5;
        Temp[] userTemps = new Temp[USER_INPUT_TEMPS];
        int count = 0;
        boolean repeat = true;

        while (repeat) {
            count = 0;
            while (count <userTemps.length) {
                System.out.print("Enter temperature " + (count +1) + ": ");
                String input = scanner.next();
                try {
                    userTemps[count] = new Temp(input);
                    count++;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            tempAnalysis.updateTemps(userTemps);
            System.out.println(tempAnalysis.toString());

            System.out.print("Would you like to analyze new data? (Y/N): ");
            String response = scanner.next().toUpperCase();
            repeat = response.equals("Y");

        }

        scanner.close();
    }
}
