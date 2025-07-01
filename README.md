## Password-Generator-Java

A secure Java-based password generator that creates customizable passwords based on user preferences.
Features

    Secure Random Generation: Uses Java's SecureRandom class for cryptographically strong password generation
    Customizable Length: Choose any password length greater than 0
    Character Type Selection: Include or exclude:
        Numbers (0-9)
        Lowercase letters (a-z)
        Uppercase letters (A-Z)
        Special characters (!@#$%^&*()_+-={}[]|;:,.<>?)
    Input Validation: Robust error handling for all user inputs
    User-Friendly Interface: Clear prompts and error messages

How to Use

    Compile the program:

    bash

    javac PasswordGenerator.java

    Run the program:

    bash

    java PasswordGenerator

    Follow the prompts:
        Enter desired password length (must be a positive integer)
        Choose which character types to include (yes/no for each)
        Your secure password will be generated and displayed

Security Features

    Uses SecureRandom instead of regular Random for cryptographically secure generation
    No password storage or logging
    Immediate memory cleanup after generation

Requirements

    Java 8 or higher
    No external dependencies

Contributing

Feel free to fork this project and submit pull requests for any improvements!

This project is open source and available under the MIT License.

Konstantin Bocharov - mrkoboch
