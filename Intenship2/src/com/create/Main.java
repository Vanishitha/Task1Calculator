package com.create;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding some books and users
        library.addBook(new Book("Book1", "Author1"));
        library.addBook(new Book("Book2", "Author2"));
        library.addUser(new User("User1"));
        library.addUser(new User("User2"));

        while (true) {
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    library.issueBook(bookTitle, userName);
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    library.returnBook(userName);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}