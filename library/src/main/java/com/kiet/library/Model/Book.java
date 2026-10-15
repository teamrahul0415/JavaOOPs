package com.kiet.library.Model;

public class Book {
    private int bookid;
    private String title;
    private String author;
    private String Category;
    private int publication_year;
    private boolean available;

public Book(int bookid, String title, String author,
            String Category, int publication_year,
            boolean available) {
    this.bookid = bookid;
    this.title = title;
    this.author = author;
    this.Category = Category;
    this.publication_year = publication_year;
    this.available = available;
}

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getpublication_year() {
        return publication_year;
    }

    public void setpublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }



}
