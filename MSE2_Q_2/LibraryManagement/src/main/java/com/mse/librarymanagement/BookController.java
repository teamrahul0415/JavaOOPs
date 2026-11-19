package com.mse.librarymanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/books")
public class BookController {

    List<Book> books = new ArrayList<>();

    
    @PostMapping
    public String addBook(@RequestBody Book b) {

        books.add(b);

        return "Book Added Successfully";
    }

    
    @GetMapping
    public List<Book> getAllBooks() {

        return books;
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
            @PathVariable int id) {

        for (Book b : books) {

            if (b.getId() == id) {
                return ResponseEntity.ok(b);
            }
        }

        return ResponseEntity.notFound().build();
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable int id,
            @RequestBody Book newBook) {

        for (Book b : books) {

            if (b.getId() == id) {

                b.setTitle(newBook.getTitle());
                b.setAuthor(newBook.getAuthor());
                b.setCategory(newBook.getCategory());
                b.setAvailableCopies(
                    newBook.getAvailableCopies()
                );

                return ResponseEntity.ok(b);
            }
        }

        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(
            @PathVariable int id) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId() == id) {

                books.remove(i);

                return ResponseEntity.ok(
                    "Book Deleted Successfully"
                );
            }
        }

        return ResponseEntity.status(404)
                .body("Book Not Found");
    }
}