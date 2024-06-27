package com.search;

public class LibraryMangementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("Effective Java", "Joshua Bloch", "1234567890"));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "0987654321"));
        library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt", "1122334455"));

        // Display all books
        System.out.println("All books in the library:");
        library.displayBooks();

        // Linear Search
        System.out.println("\nLinear Search for 'Clean Code':");
        Book linearSearchResult = library.linearSearch("Clean Code");
        System.out.println(linearSearchResult != null ? linearSearchResult : "Book not found");

        // Binary Search
        System.out.println("\nBinary Search for 'The Pragmatic Programmer':");
        Book binarySearchResult = library.binarySearch("The Pragmatic Programmer");
        System.out.println(binarySearchResult != null ? binarySearchResult : "Book not found");

        // Compare search performance
        compareSearchPerformance(library, "Effective Java", "Nonexistent Book");
    }

    private static void compareSearchPerformance(Library library, String existingTitle, String nonExistingTitle) {
        long startTime, endTime;

        // Linear search for an existing book
        startTime = System.nanoTime();
        library.linearSearch(existingTitle);
        endTime = System.nanoTime();
        System.out.println("Linear Search for existing book: " + (endTime - startTime) + " ns");

        // Binary search for an existing book
        startTime = System.nanoTime();
        library.binarySearch(existingTitle);
        endTime = System.nanoTime();
        System.out.println("Binary Search for existing book: " + (endTime - startTime) + " ns");

        // Linear search for a non-existing book
        startTime = System.nanoTime();
        library.linearSearch(nonExistingTitle);
        endTime = System.nanoTime();
        System.out.println("Linear Search for non-existing book: " + (endTime - startTime) + " ns");

        // Binary search for a non-existing book
        startTime = System.nanoTime();
        library.binarySearch(nonExistingTitle);
        endTime = System.nanoTime();
        System.out.println("Binary Search for non-existing book: " + (endTime - startTime) + " ns");
    }
}

