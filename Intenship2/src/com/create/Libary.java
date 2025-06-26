package com.create;

import java.util.HashMap;
import java.util.Map;

class Library {
    private Map<String, Book> books;
    private Map<String, User> users;

    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    public void issueBook(String bookTitle, String userName) {
        Book book = books.get(bookTitle);
        User user = users.get(userName);

        if (book != null && user != null && book.isAvailable()) {
            book.setAvailability(false);
            user.setBorrowedBook(bookTitle);
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book is not available or user not found.");
        }
    }

    public void returnBook(String userName) {
        User user = users.get(userName);

        if (user != null && user.getBorrowedBook() != null) {
            Book book = books.get(user.getBorrowedBook());
            book.setAvailability(true);
            user.setBorrowedBook(null);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("User has not borrowed any book.");
        }
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}
