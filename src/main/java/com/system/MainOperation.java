package com.system;

import com.system.entity.User;
import com.system.service.UserService;
import com.system.serviceimp.UserServiceImpl;

import java.util.Scanner;

import static com.system.AllOperations.*;

public class MainOperation {

    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();

    public static void mainOps() {
        while (true) {
            System.out.println("Press 1. Login\nPress 2. Register\nPress 3. Quit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (login()) {
                        // Logged in successfully, continue with operations
                        while (true) {
                            System.out.println("Press 1. Manage Rooms\nPress 2. Manage Guests"
                                    + "\nPress 3. Manage Reservations\nPress 4. Manage Payments"
                                    + "\nPress 5. Manage Staff\nPress 6. Manage Users"
                                    + "\nPress 7. Logout\nPress 8. Quit");
                            int input = sc.nextInt();
                            sc.nextLine(); // Consume newline

                            switch (input) {
                                case 1:
                                    roomOperations();
                                    System.out.println("=======================================");
                                    break;

                                case 2:
                                    guestOperations();
                                    System.out.println("=======================================");
                                    break;

                                case 3:
                                    reservationOperations();
                                    System.out.println("=======================================");
                                    break;

                                case 4:
                                    paymentOperations();
                                    System.out.println("=======================================");
                                    break;

                                case 5:
                                    staffOperations();
                                    System.out.println("=======================================");
                                    break;

                                case 6:
                                    userOperations();
                                    System.out.println("=======================================");
                                    break;

                                case 7:
                                    // Log out and return to the login screen
                                    System.out.println("Logging out...");
                                    setLoggedInUser(null); // Clear logged-in user
                                    break;

                                case 8:
                                    System.out.println("Exiting the system...");
                                    System.exit(0);

                                default:
                                    System.out.println("Wrong input, please try again.");
                            }

                            // If the user chooses to logout, break out of the inner loop
                            if (input == 7) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Invalid credentials, please try again.");
                    }
                    break;

                case 2:
                    register();
                    break;

                case 3:
                    System.out.println("Exiting the system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void main(String[] args) {
        mainOps();
    }

    // Method to handle user login
    private static boolean login() {
        System.out.println("Enter Username:");
        String username = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        // Corrected method call from login() to authenticateUser()
        User user = userService.authenticateUser(username, password);
        if (user != null) {
            setLoggedInUser(user); // Set the logged-in user in AllOperations
            System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
            return true;
        } else {
            System.out.println("Login failed. Please check your username and password.");
            return false;
        }
    }

    // Method to handle user registration
    private static void register() {
        System.out.println("Enter Username:");
        String username = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        System.out.println("Enter Role (USER/STAFF):");
        String role = sc.nextLine().toUpperCase();

        User newUser = new User(0, username, password, role); // Assuming a suitable constructor
        User addedUser = userService.addUser(newUser);

        if (addedUser != null) {
            System.out.println("Registration successful! You can now log in with your credentials.");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    // Placeholder method for managing staff
    private static void staffOperations() {
        // Implement staff management operations here
        System.out.println("Staff management operations not yet implemented.");
    }

    // Placeholder method for managing users
    private static void userOperations() {
        // Implement user management operations here
        System.out.println("User management operations not yet implemented.");
    }
}
