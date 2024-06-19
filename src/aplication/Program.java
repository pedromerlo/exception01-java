package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy):");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Check-out date (dd/MM/yyyy):");
        Date checkOut = sdf.parse(sc.next());

        Reservation reservation = new Reservation();

        String errors = reservation.updateDates(checkIn, checkOut);
        if(errors!= null){
            System.out.println("Error in reservation: " + errors);
            System.exit(0);
        }
        reservation.setRoomNumber(roomNumber);
        System.out.println("Reservation: " + reservation.toString());
        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date (dd/MM/yyyy):");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy):");
        checkOut = sdf.parse(sc.next());
        errors = reservation.updateDates(checkIn, checkOut);
        if(errors!= null){
            System.out.println("Error in reservation: " + errors);
            System.exit(0);
        }
        System.out.println("Reservation: " + reservation.toString());
        sc.close();
    }}
