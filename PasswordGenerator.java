import java.security.SecureRandom;
import java.util.Scanner;


// A secure password generator that creates customizable passwords based on user preferences.
// Users can specify password length and choose which character types to include.

public class PasswordGenerator {
    public static void main(String[] args) {
        // Define character sets for password generation
        String Numbers = "0123456789";
        String LowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String UpperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SpecialCharacters = "!@#$%^&*()_+_={}[]";

        // Create Scanner object for user input
        Scanner userInput = new Scanner(System.in);

        // Get valid password length from user
        int lengthOfPassword = -1;
        do {
            System.out.println("Welcome to the password generator, how long do you want your password to be? (enter an integer value greater than 0)");

            // Check if input is actually an integer
            if (userInput.hasNextInt()) {
                lengthOfPassword = userInput.nextInt();
                if (lengthOfPassword <= 0) {
                    System.out.println("Please enter an integer value greater than 0!\n");
                }
            } else {
                // Clear invalid input and prompt again
                System.out.println("Please enter a valid INTEGER value\n");
                userInput.next(); // Consume the invalid input
                lengthOfPassword = -1;
            }
        } while (lengthOfPassword <= 0); // Keep asking until valid input

        // Get user preference for including numbers
        String numbersOrNot;
        do {
            System.out.println("Do you want numbers in your password? (yes/no)");
            numbersOrNot = userInput.next();
            if (!numbersOrNot.equalsIgnoreCase("yes") && !numbersOrNot.equalsIgnoreCase("no")) {
                System.out.println("Please enter yes or no!");
            }
        } while (!numbersOrNot.equalsIgnoreCase("yes") && !numbersOrNot.equalsIgnoreCase("no"));
        boolean includeNumbers = numbersOrNot.equalsIgnoreCase("yes");

        // Get user preference for including uppercase letters
        String uppercaseOrNot;
        do {
            System.out.println("Should there be uppercase letters? (yes/no)");
            uppercaseOrNot = userInput.next();
            if (!uppercaseOrNot.equalsIgnoreCase("yes") && !uppercaseOrNot.equalsIgnoreCase("no")) {
                System.out.println("Please enter yes or no!");
            }
        } while (!uppercaseOrNot.equalsIgnoreCase("yes") && !uppercaseOrNot.equalsIgnoreCase("no"));
        boolean includeUppercase = uppercaseOrNot.equalsIgnoreCase("yes");

        // Get user preference for including lowercase letters
        String lowerCaseOrNot;
        do {
            System.out.println("Do you want lowercase letters? (yes/no)");
            lowerCaseOrNot = userInput.next();
            if (!lowerCaseOrNot.equalsIgnoreCase("yes") && !lowerCaseOrNot.equalsIgnoreCase("no")) {
                System.out.println("Please enter yes or no!");
            }
        } while (!lowerCaseOrNot.equalsIgnoreCase("yes") && !lowerCaseOrNot.equalsIgnoreCase("no"));
        boolean includeLowercase = lowerCaseOrNot.equalsIgnoreCase("yes");

        // Get user preference for including special characters
        String specialCharactersOrNot;
        do {
            System.out.println("Do you want special characters? (yes/no)");
            specialCharactersOrNot = userInput.next();
            if (!specialCharactersOrNot.equalsIgnoreCase("yes") && !specialCharactersOrNot.equalsIgnoreCase("no")) {
                System.out.println("Please enter yes or no!");
            }
        } while (!specialCharactersOrNot.equalsIgnoreCase("yes") && !specialCharactersOrNot.equalsIgnoreCase("no"));
        boolean includeSpecialCharacters = specialCharactersOrNot.equalsIgnoreCase("yes");

        // Create SecureRandom object for cryptographically secure random generation
        SecureRandom random = new SecureRandom();

        // Build character pool based on user preferences
        String characterPool = "";

        // Add character sets to pool based on user choices
        if (includeNumbers) {
            characterPool += Numbers;
        }
        if (includeUppercase) {
            characterPool += UpperCaseLetters;
        }
        if (includeLowercase) {
            characterPool += LowerCaseLetters;
        }
        if (includeSpecialCharacters) {
            characterPool += SpecialCharacters;
        }

        // Check if user selected at least one character type
        if (characterPool.isEmpty()) {
            System.out.println("Error, you didn't select anything to be in your password!");
            return; // Exit program if no character types selected
        }

        // Generate the password
        String password = "";
        for (int i = 0; i < lengthOfPassword; i++) {
            // Pick a random index from the character pool
            int randomIndex = random.nextInt(characterPool.length());
            // Add the character at that index to the password
            password += characterPool.charAt(randomIndex);
        }

        // Display the generated password
        System.out.println("Your password is \n" + password);
    }
}