/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartlibrary;
import java.util.Scanner;
/**
 *
 * @author 24001
 */
public class SmartLibrary implements LibraryADT {
    private BookBST catalogue = new BookBST();
    private BorrowStack history = new BorrowStack();
    
    public void addBook(int i, String t, String a){
        catalogue.insert(i, t, a);
        System.out.println("Book added successly!");
        
    }
    
    public void searchBook(int isbn){
        Book b = catalogue.search(isbn);
        //Ensure it doesn't just check if null, but also checks if it's currently borrowed
        if ( b != null ){
            System.out.println("Found: "+ b.getTitle());
            
        }else if (b != null && !b.isBorrowed()){
            System.out.println("Found but status is: Currently Borrowed.");
            
        }else{
            System.out.println("Not found.");
        }
    }
    
    public void borrowBook (int i){
            Book b = catalogue.search(i);
            if (b == null){
                System.out.println("Error : Book not found in system catalogue.");
                
            }else if(b.isBorrowed()){
                System.out.println("Error: ' " + b.getTitle() + "' is already checked out by another student." );
            }else {
                b.setBorrowed(true); //Mark as borrowed
                history.push(b); // Pushes onto the LIFO history stack
                System.out.println("Success: You have borrowed ' " + b.getTitle() + " '.");
                
            }    
    }
    
    public void viewHistory(){
        history.show();
    }
    
    public void runMenu(){
        Scanner sc = new Scanner (System.in);
        while(true){
            printMenu();
            System.out.println("Choice:");
            
            //Input Validation : Check if user input is an integer
            if ( !sc.hasNextInt()){
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                sc.next(); // clear out the bad token
                continue;
            }
            
            int choice = sc.nextInt();
            if (choice == 5) {
                System.out.println("Exiting system. Goodbye!");
                break;
            }
            handleChoice(choice, sc);
        }
        sc.close();
    }
    
    private void printMenu(){
        System.out.println("\n--- Smart Library Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Search(BST)");
        System.out.println("3. Borrow (Stack)");
        System.out.println("4. History");
        System.out.println("5. Exit");
    }
    
    private void handleChoice(int choice, Scanner sc){
        switch (choice){
            case 1:
                System.out.println("Enter ISBN (Integer): ");
                while (!sc.hasNextInt()){
                    System.out.println("ISBN must be an integer!");
                    sc.next();
                }
                    
                
                int i = sc.nextInt();
                sc.nextLine(); //Clear scanner buffer space
                
                System.out.print("Enter Title: ");
                String t = sc.nextLine();
                
                System.out.print("Enter Author: ");
                String a = sc.nextLine();
                
                addBook(i, t, a);
     
                break;
                
            case 2: 
                System.out.print("Enter ISBN to search: ");
                if (sc.hasNextInt()) {
                    searchBook(sc.nextInt());
                } else {
                    System.out.println("Invalid ISBN format.");
                    sc.next();
                }
                break;
                
            case 3:
                System.out.println("Enter ISBN to borrow: ");
                if(sc.hasNextInt()){
                    borrowBook(sc.nextInt());  
                    
                }else{
                        System.out.println("Invalid ISBN format.");
                        sc.next();
                    }
            
            case 4: 
                viewLatestHistory();
                break;
                
            default:
                System.out.println("Invalid option. Please choose 1-5.");
                
            
        }
    }
}
