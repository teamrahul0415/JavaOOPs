package com.kiet.library.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.kiet.library.Model.Book;

@Repository 
public class BookRepository {
    private final JdbcTemplate jdbc;

    BookRepository(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }

    // @Autowired 
    // JdbcTemplate jdbc; //filed injection

    // private final RowMapper<Book> bookMapper =newq RowMapper<>(){

    // }


private final RowMapper<Book> bookMapper = new RowMapper<Book>() {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        Book book = new Book();

        book.setBookid(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setCategory(rs.getString("category"));
        book.setpublication_year(rs.getInt("publication_year"));
        book.setAvailable(rs.getBoolean("available"));

        return book;
    }
};

public List<Book> findAll() {
    String sql = "SELECT * FROM books ORDER BY book_id";

    return jdbc.query(sql, bookMapper);
}


// public Book findByid(int bookId){
    
// }

    public List<Book> findByid(int id) {
        return jdbc.query("SELECT * FROM books WHERE book_id = ?", bookMapper, id);
    }

    public int insert(Book b) {
        String sql = "INSERT INTO books " +
            "(book_id, title, author, category, publication_year, available) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbc.update(sql, b.getBookid(), b.getTitle(), b.getAuthor(),
            b.getCategory(), b.getpublication_year(), b.isAvailable());
    }

    public int deleteById(int id) {
        return jdbc.update("DELETE FROM books WHERE book_id = ?", id);
    }


    
}
