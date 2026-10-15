// package com.kiet.library.Service;

// public class BookService {
    
// }



package com.kiet.library.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.library.Model.Book;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(201, "Effective Java",
                "Joshua Bloch", "Programming", 2018, true));

        books.add(new Book(202, "Clean Code",
                "Robert C. Martin", "Programming", 2008, true));

        books.add(new Book(203, "The Alchemist",
                "Paulo Coelho", "Fiction", 1988, false));

        books.add(new Book(204, "Wings of Fire",
                "A. P. J. Abdul Kalam", "Biography", 1999, true));

        books.add(new Book(205, "Head First Java",
                "Kathy Sierra", "Programming", 2022, true));
    }


    public List<Book> getAllBooks() {
        return books;
    }

    
    public Book getBookById(int bookId) {
        for (Book b : books) {
            if (b.getBookid() == bookId) {
                return b;
            }
        }
        return null;
    }

    
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    
    public Book updateBook(int bookId, Book updatedBook) {
        for (Book b : books) {
            if (b.getBookid() == bookId) {
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
                b.setCategory(updatedBook.getCategory());
                b.setpublication_year(
                        updatedBook.getpublication_year());
                b.setAvailable(updatedBook.isAvailable());

                return b;
            }
        }
        return null;
    }

    
    public boolean deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookid() == bookId) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    
    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book b : books) {
            if (b.getCategory().equalsIgnoreCase(category)) {
                result.add(b);
            }
        }

        return result;
    }

    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book b : books) {
            if (b.getpublication_year() >= fromYear) {
                result.add(b);
            }
        }

        return result;
    }
}
