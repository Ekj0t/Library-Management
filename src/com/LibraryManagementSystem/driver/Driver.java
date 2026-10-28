package com.LibraryManagementSystem.driver;

import com.LibraryManagementSystem.controller.Library;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Library controller = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    controller.addBook(id, title, author);
                    break;

                case 2:
                    controller.viewAllBooks();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    id = sc.nextInt();
                    var book = controller.searchBook(id);

                    if (book == null)
                        System.out.println("Book not found!");
                    else
                        System.out.println(book);
                    break;

                case 4:
                    System.out.print("Enter ID to borrow: ");
                    id = sc.nextInt();
                    controller.borrowBook(id);
                    break;

                case 5:
                    System.out.print("Enter ID to return: ");
                    id = sc.nextInt();
                    controller.returnBook(id);
                    break;

                case 6:
                    System.out.print("Enter ID to remove: ");
                    id = sc.nextInt();
                    controller.removeBook(id);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
