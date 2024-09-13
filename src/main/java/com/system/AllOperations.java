package com.system;

import com.system.service.*;
import com.system.serviceimp.*;
import com.system.entity.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static com.system.MainOperation.mainOps;

public class AllOperations {

    static RoomService roomService = new RoomServiceImpl();
    static GuestService guestService = new GuestServiceImpl();
    static ReservationService reservationService = new ReservationServiceImpl();
    static PaymentService paymentService = new PaymentServiceImpl();
    static UserService userService = new UserServiceImpl();

    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Variable to hold the logged-in user
    static User loggedInUser;

    // This method should be called after login to set the logged-in user
    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    // Utility method to check if user is an admin
    private static boolean isAdmin() {
        return loggedInUser != null && "ADMIN".equalsIgnoreCase(loggedInUser.getRole());
    }

    public static void roomOperations() {
        while (true) {
            System.out.println("Press 1. Add Room Details\n2. Retrieve All Room Data\n"
                    + "3. Update Room Data\n4. Delete Room Data\n5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine();  // Consume the newline

            switch (input) {
                case 1:
                    // Restrict adding room details to admin only
                    if (isAdmin()) {
                        Room roomToAdd = inputRoomDetails();
                        roomService.addRoom(roomToAdd);
                        System.out.println("Room data has been added successfully: " + roomToAdd);
                    } else {
                        System.out.println("Access Denied: Only admins can add room details.");
                    }
                    break;
                case 2:
                    // Both Admin and Guests can view room data
                    List<Room> rooms = roomService.getAllRooms();
                    rooms.forEach(System.out::println);
                    break;
                case 3:
                    // Restrict updating room details to admin only
                    if (isAdmin()) {
                        System.out.println("Enter Room ID to update the information:");
                        int roomIdToUpdate = sc.nextInt();
                        sc.nextLine();
                        Room roomToUpdate = roomService.getRoomById(roomIdToUpdate);

                        if (roomToUpdate != null) {
                            Room updatedRoomDetails = inputRoomDetails();
                            updatedRoomDetails.setRoomId(roomIdToUpdate);
                            roomService.updateRoom(updatedRoomDetails);
                            System.out.println("Room data has been updated successfully: " + updatedRoomDetails);
                        } else {
                            System.out.println("Room ID not found");
                        }
                    } else {
                        System.out.println("Access Denied: Only admins can update room details.");
                    }
                    break;
                case 4:
                    // Restrict deleting room details to admin only
                    if (isAdmin()) {
                        System.out.println("Enter Room ID to delete the information:");
                        int roomIdToDelete = sc.nextInt();
                        sc.nextLine();
                        roomService.deleteRoom(roomIdToDelete);
                        System.out.println("Room data has been deleted successfully.");
                    } else {
                        System.out.println("Access Denied: Only admins can delete room details.");
                    }
                    break;
                case 5:
                    mainOps(); // Navigate back to the main menu
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void guestOperations() {
        // Only admins can perform guest operations
        if (!isAdmin()) {
            System.out.println("Access Denied: Only admins can perform guest operations.");
            return;
        }

        while (true) {
            System.out.println("Press 1. Add Guest Details\n2. Retrieve All Guest Data\n"
                    + "3. Update Guest Data\n4. Delete Guest Data\n5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine();  // Consume the newline

            switch (input) {
                case 1:
                    Guest guest = guestInputs();
                    Guest savedGuest = guestService.updateGuest(guest);
                    System.out.println("Guest Data has been saved successfully: " + savedGuest);
                    break;
                case 2:
                    List<Guest> guests = guestService.getAllGuests();
                    guests.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter Guest ID to update the information:");
                    int guestId = sc.nextInt();
                    sc.nextLine();
                    Guest existingGuest = guestService.getGuestById(guestId);
                    if (existingGuest != null) {
                        Guest updatedGuest = guestInputs();
                        Guest updatedInfo = guestService.updateGuest(updatedGuest);
                        System.out.println("Guest Data has been updated Successfully: " + updatedInfo);
                    } else {
                        System.out.println("Guest ID not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter Guest ID to delete the information:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String message = guestService.deleteGuest(id);
                    System.out.println(message);
                    break;
                case 5:
                    mainOps();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void reservationOperations() {
        // Only admins can perform reservation operations
        if (!isAdmin()) {
            System.out.println("Access Denied: Only admins can perform reservation operations.");
            return;
        }

        while (true) {
            System.out.println("Press 1. Add Reservation Details\n2. Retrieve All Reservation Data\n"
                    + "3. Update Reservation Data\n4. Delete Reservation Data\n5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine();  // Consume the newline

            switch (input) {
                case 1:
                    Reservation reservation = reservationInputs();
                    Reservation savedReservation = reservationService.addReservation(reservation);
                    System.out.println("Reservation Data has been saved successfully: " + savedReservation);
                    break;
                case 2:
                    List<Reservation> reservations = reservationService.getAllReservations();
                    reservations.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter Reservation ID to update the information:");
                    int reservationId = sc.nextInt();
                    sc.nextLine();
                    Reservation existingReservation = reservationService.getReservation(reservationId);
                    if (existingReservation != null) {
                        Reservation updatedReservation = reservationInputs();
                        Reservation updatedInfo = reservationService.updateReservation(updatedReservation);
                        System.out.println("Reservation Data has been updated Successfully: " + updatedInfo);
                    } else {
                        System.out.println("Reservation ID not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter Reservation ID to delete the information:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String message = reservationService.deleteReservation(id);
                    System.out.println(message);
                    break;
                case 5:
                    mainOps();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void paymentOperations() {
        // Only admins can perform payment operations
        if (!isAdmin()) {
            System.out.println("Access Denied: Only admins can perform payment operations.");
            return;
        }

        while (true) {
            System.out.println("Press 1. Add Payment Details\n2. Retrieve All Payment Data\n"
                    + "3. Update Payment Data\n4. Delete Payment Data\n5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine();  // Consume the newline

            switch (input) {
                case 1:
                    Payment payment = paymentInputs();
                    Payment savedPayment = paymentService.addPayment(payment);
                    System.out.println("Payment Data has been saved successfully: " + savedPayment);
                    break;
                case 2:
                    List<Payment> payments = paymentService.getAllPayments();
                    payments.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter Payment ID to update the information:");
                    int paymentId = sc.nextInt();
                    sc.nextLine();
                    Payment existingPayment = paymentService.getPayment(paymentId);
                    if (existingPayment != null) {
                        Payment updatedPayment = paymentInputs();
                        Payment updatedInfo = paymentService.updatePayment(updatedPayment);
                        System.out.println("Payment Data has been updated Successfully: " + updatedInfo);
                    } else {
                        System.out.println("Payment ID not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter Payment ID to delete the information:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String message = paymentService.deletePayment(id);
                    System.out.println(message);
                    break;
                case 5:
                    mainOps();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    public static Room inputRoomDetails() {
        System.out.println("Enter Room ID:");
        int roomId = sc.nextInt();
        sc.nextLine(); // Consume the newline

        System.out.println("Enter Room Number:");
        String roomNumber = sc.nextLine();

        System.out.println("Enter Room Type:");
        String roomType = sc.nextLine();

        System.out.println("Enter Price Per Night:");
        double pricePerNight = sc.nextDouble();
        sc.nextLine(); // Consume the newline

        System.out.println("Enter Availability Status:");
        String availabilityStatus = sc.nextLine();


        return new Room(roomId, roomNumber, roomType, pricePerNight, availabilityStatus);
    }

    public static Guest guestInputs() {
        System.out.println("Enter Guest ID:");
        int guestId = sc.nextInt();
        sc.nextLine(); // Consume the newline

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phone = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter Identification Number (Aadhar/PAN):");
        String identificationNumber = sc.nextLine();

        return new Guest(guestId, name, email, phone, address, identificationNumber);
    }

    public static Reservation reservationInputs() {
        System.out.println("Enter Reservation ID:");
        int reservationId = sc.nextInt();

        System.out.println("Enter Guest ID:");
        int guestId = sc.nextInt();

        System.out.println("Enter Room ID:");
        int roomId = sc.nextInt();
        sc.nextLine(); // Consume the newline

        Date checkInDate = parseDate("Enter Check-In Date (yyyy-MM-dd):");
        Date checkOutDate = parseDate("Enter Check-Out Date (yyyy-MM-dd):");

        System.out.println("Enter Status (Occupied/Available):");
        String status = sc.nextLine();

        return new Reservation(reservationId, guestId, roomId, checkInDate, checkOutDate, status);
    }

    public static Payment paymentInputs() {
        System.out.println("Enter Payment ID:");
        int paymentId = sc.nextInt();

        System.out.println("Enter Reservation ID:");
        int reservationId = sc.nextInt();

        System.out.println("Enter Amount:");
        double amount = sc.nextDouble();
        sc.nextLine(); // Consume the newline

        Date paymentDate = parseDate("Enter Payment Date (yyyy-MM-dd):");

        System.out.println("Enter Payment Method (Cash/Card):");
        String paymentMethod = sc.nextLine();

        return new Payment(paymentId, reservationId, amount, paymentDate, paymentMethod);
    }

    private static Date parseDate(String prompt) {
        Date date = null;
        while (date == null) {
            System.out.println(prompt);
            String dateString = sc.nextLine();
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
        return date;
    }
}
