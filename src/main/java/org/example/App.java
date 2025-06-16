package org.example;


import java.util.List;
import java.util.Map;

/**
 * Demonstrates usage of LibraryAnalyzer for analyzing library data.
 */
public class App 
{
    public static void main( String[] args )
    {

        // Sample data setup
        List<Author> authors = List.of(
                new Author("Alice", List.of(
                        new Book("Java Basics", "Programming", 4.5),
                        new Book("Advanced Java", "Programming", 4.8))),
                new Author("Bob", List.of(
                        new Book("World War II", "History", 4.2),
                        new Book("Ancient Civilizations", "History", 3.9))),
                new Author("Cathy", List.of(
                        new Book("Mystery Island", "Fiction", 4.0)))
        );

        LibraryAnalyzer analyzer = new LibraryAnalyzer();

        // 1. Flatten books
        List<Book> allBooks = analyzer.getAllBooks(authors);
        System.out.println("📚 All Books:");
        allBooks.forEach(book -> System.out.println("- " + book.getTitle()));

        // 2. Count books by genre
        Map<String, Long> genreCount = analyzer.countBooksByGenre(allBooks);
        System.out.println("\n📊 Book Count by Genre:");
        genreCount.forEach((genre, count) -> System.out.println(genre + ": " + count));

        // 3. Average rating by genre
        Map<String, Double> avgRatings = analyzer.averageRatingByGenre(allBooks);
        System.out.println("\n⭐ Average Rating by Genre:");
        avgRatings.forEach((genre, avg) -> System.out.printf("%s: %.2f%n", genre, avg));

        // 4. Custom collector: summary
        Map<String, GenreSummary> summaries = analyzer.summarizeGenres(allBooks);
        System.out.println("\n📘 Genre Summary (using custom collector):");
        summaries.forEach((genre, summary) -> System.out.println(genre + ": " + summary));

    }
}
