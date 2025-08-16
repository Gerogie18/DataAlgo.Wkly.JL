import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieTheatre {

    // --- MODEL: Data Management ---
    // Represents the seating chart. 0 = available, 1 = sold.
    // This 2D array is the core data structure for our application.
    private static int[][] seatingChart = {
        {0, 1, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 0, 0, 0},
        {1, 0, 1, 0, 0, 0, 1, 0}
    };

    private static final int ROWS = seatingChart.length;
    private static final int COLS = seatingChart[0].length;

    // --- VIEW: UI Elements & Rendering ---

    /**
     * Prints the current seating chart to the console.
     * 'O' represents an available seat.
     * 'X' represents a sold seat.
     */
    public static void printSeatingChart() {
        System.out.println("\n===== CINEMA SEATING CHART =====");
        System.out.print("   "); // Padding for column numbers
        for (int j = 0; j < COLS; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println("\n--------------------------");

        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + "| "); // Row number
            for (int j = 0; j < COLS; j++) {
                if (seatingChart[i][j] == 0) {
                    System.out.print("O "); // 'O' for available
                } else {
                    System.out.print("X "); // 'X' for sold
                }
            }
            System.out.println();
        }
        System.out.println("==============================");
        System.out.println("Legend: [O] = Available, [X] = Sold");
    }

    // --- CONTROLLER: Logic and Event Handling ---

    /**
     * Finds and suggests the first available seat.
     * @return A string with the suggested seat, or null if none are available.
     */
    private static String findAvailableSeat() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (seatingChart[i][j] == 0) {
                    return "Row " + (i + 1) + ", Seat " + (j + 1);
                }
            }
        }
        return null; // No available seats
    }

    /**
     * Handles the logic for reserving a seat.
     * @param scanner The Scanner object to read user input.
     */
    public static void reserveSeat(Scanner scanner) {
        try {
            System.out.print("Enter row number to reserve: ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter seat number to reserve: ");
            int col = scanner.nextInt() - 1;

            // Input validation
            if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
                System.out.println("Error: Invalid row or seat number. Please try again.");
                return;
            }

            // Check if seat is taken
            if (seatingChart[row][col] == 1) {
                System.out.print("Sorry, that seat is already taken. ");
                String suggestion = findAvailableSeat();
                if (suggestion != null) {
                    System.out.println("How about " + suggestion + "?");
                } else {
                    System.out.println("Unfortunately, the theater is full.");
                }
            } else {
                seatingChart[row][col] = 1; // Reserve the seat
                System.out.println("Seat at Row " + (row + 1) + ", Seat " + (col + 1) + " has been successfully reserved.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numbers only.");
            scanner.next(); // Clear the invalid input from the scanner
        }
    }

    /**
     * Handles the logic for canceling a reservation.
     * @param scanner The Scanner object to read user input.
     */
    public static void cancelSeat(Scanner scanner) {
        try {
            System.out.print("Enter row number to cancel: ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter seat number to cancel: ");
            int col = scanner.nextInt() - 1;

            // Input validation
            if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
                System.out.println("Error: Invalid row or seat number. Please try again.");
                return;
            }

            // Check if the seat was actually reserved
            if (seatingChart[row][col] == 0) {
                System.out.println("That seat is already available. No action taken.");
            } else {
                seatingChart[row][col] = 0; // Make the seat available
                System.out.println("Reservation for Row " + (row + 1) + ", Seat " + (col + 1) + " has been cancelled.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numbers only.");
            scanner.next(); // Clear the invalid input
        }
    }

    /**
     * The main method to run the application loop.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("Welcome to the Movie Theater Booking System!");

        while (choice != 4) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        printSeatingChart();
                        break;
                    case 2:
                        printSeatingChart(); // Show chart before booking
                        reserveSeat(scanner);
                        break;
                    case 3:
                        printSeatingChart(); // Show chart before canceling
                        cancelSeat(scanner);
                        break;
                    case 4:
                        System.out.println("Thank you for using the booking system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Important to clear the buffer
            }
        }
        scanner.close();
    }
}
