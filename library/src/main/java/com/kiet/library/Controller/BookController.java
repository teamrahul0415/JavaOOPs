// // package com.kiet.library.Controller;

// // public class BookController {
    
// // }


// package com.kiet.library.Controller;

// import java.util.List;
// import java.util.Map;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.kiet.library.Model.Book;
// import com.kiet.library.Service.BookService;

// @RestController
// @RequestMapping("/books")
// public class BookController {

//     private final BookService bookService;

//     public BookController(BookService bookService) {
//         this.bookService = bookService;
//     }

//     @GetMapping
//     public List<Book> getAllBooks() {
//         return bookService.getAllBooks();
//     }

   
//     @GetMapping("/{bookId}")
//     public ResponseEntity<?> getBookById(
//             @PathVariable int bookId) {

//         Book book = bookService.getBookById(bookId);

//         if (book == null) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                     .body(Map.of("message", "Book not found"));
//         }

//         return ResponseEntity.ok(book);
//     }

    
//     @PostMapping
//     public ResponseEntity<Book> addBook(
//             @RequestBody Book book) {

//         Book savedBook = bookService.addBook(book);

//         return ResponseEntity.status(HttpStatus.CREATED)
//                 .body(savedBook);
//     }

//     @PutMapping("/{bookId}")
//     public ResponseEntity<?> updateBook(
//             @PathVariable int bookId,
//             @RequestBody Book updatedBook) {

//         Book book = bookService.updateBook(bookId, updatedBook);

//         if (book == null) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                     .body(Map.of("message", "Book not found"));
//         }

//         return ResponseEntity.ok(book);
//     }

  
//     @DeleteMapping("/{bookId}")
//     public ResponseEntity<Map<String, String>> deleteBook(
//             @PathVariable int bookId) {

//         boolean deleted = bookService.deleteBook(bookId);

//         if (!deleted) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                     .body(Map.of("message", "Book not found"));
//         }

//         return ResponseEntity.ok(
//                 Map.of("message", "Book deleted successfully"));
//     }

    
//     @GetMapping("/search")
//     public List<Book> searchByCategory(
//             @RequestParam String category) {

//         return bookService.searchByCategory(category);
//     }

    
//     @GetMapping("/published")
//     public List<Book> findPublishedFromYear(
//             @RequestParam int fromYear) {

//         return bookService.findPublishedFromYear(fromYear);
//     }
// }

//BY AutoWired through filed Injection....

package com.kiet.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kiet.library.Model.Book;
import com.kiet.library.Service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }


    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

  
    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable int bookId,
                           @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/{bookId}")
    public boolean deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }

   
    @GetMapping("/search")
    public List<Book> searchByCategory(@RequestParam String category) {
        return bookService.searchByCategory(category);
    }

  
    @GetMapping("/published")
    public List<Book> findPublishedFromYear(
            @RequestParam int fromYear) {
        return bookService.findPublishedFromYear(fromYear);
    }
}

