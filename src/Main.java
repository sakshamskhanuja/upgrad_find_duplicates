import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students ids in the given database: ");

        try {
            // Stores the user input.
            int noOfStudents = Integer.parseInt(scanner.nextLine());

            // Checks if user entered 0 or a negative number.
            if (noOfStudents <= 0) {
                System.out.println("Enter a whole number greater than 0.");
                return;
            }

            // Forming Database of student ids.
            int[] studentIdDatabase = getRandomIntegerArray(noOfStudents);

            // Print student database.
            System.out.println("\nStudent ids:");
            printDatabase(studentIdDatabase);

            // Prints duplicate students.
            System.out.println("\nDuplicate student id:");
            findDuplicates(studentIdDatabase);
        } catch (NumberFormatException e) {
            System.out.println("\nPlease enter a whole number.");
        }

    }

    /**
     * Prints the contents of student id array.
     *
     * @param database Integer array.
     */
    private static void printDatabase(int[] database) {
        for (int i : database) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Prints duplicate values in the array.
     *
     * @param database Contains student ids.
     */
    private static void findDuplicates(int[] database) {
        // Stores duplicates found in database.
        ArrayList<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < database.length; i++) {
            for (int j = i + 1; j < database.length; j++) {
                if (database[i] == database[j]) {
                    addDuplicates(duplicates, database[i]);
                }
            }
        }

        // Prints duplicates.
        for (Integer i : duplicates) {
            System.out.print(i + " ");
        }
    }

    /**
     * Adds duplicate value found in student database to a list.
     *
     * @param duplicates Stores all the duplicate values found in student id database.
     * @param duplicate  Value found to be duplicate.
     */
    private static void addDuplicates(ArrayList<Integer> duplicates, int duplicate) {
        for (int i : duplicates) {
            // Checks if duplicate already present.
            if (i == duplicate) {
                return;
            }
        }
        duplicates.add(duplicate);
    }

    /**
     * Creates an integer array filled up random integers from 1 to 99.
     *
     * @param size Size of the array.
     * @return Integer array containing random integers.
     */
    private static int[] getRandomIntegerArray(int size) {
        int[] array = new int[size];

        // Finds a random number.
        Random random = new Random();

        // Filling up the array with random integers.
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1, 50);
        }
        return array;
    }
}
