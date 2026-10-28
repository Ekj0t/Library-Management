package com.LibraryManagementSystem.controller;

import com.LibraryManagementSystem.model.Book;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    // Add Book
    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    // View All Books
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Search Book
    public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Borrow Book
    public void borrowBook(int id) {
        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (!book.isAvailable()) {
            System.out.println("Book already borrowed!");
        } else {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully!");
        }
    }

    // Return Book
    public void returnBook(int id) {
        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (book.isAvailable()) {
            System.out.println("Book was not borrowed!");
        } else {
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        }
    }

    // Remove Book
    public void removeBook(int id) {
        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found!");
        } else {
            books.remove(book);
            System.out.println("Book removed successfully!");
        }
    }
}
