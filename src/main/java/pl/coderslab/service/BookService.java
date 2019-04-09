package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {
    public Book getBookById(long id);
    public void addBookToList(Book book);
    public void editBook(Book book, long id);
    public void removeBook(long id);
    public List<Book> getList();
    public void setList(List<Book> list);
}
