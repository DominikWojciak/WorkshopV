package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MemoryBookService implements BookService {

    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public Book getBookById(long id) {
        Optional<Book> first = list.stream()
                .filter(b -> b.getId() == id)
                .findFirst();
        return first.isPresent() ? first.get() : null;
    }

    public void addBookToList(Book book) {
        list.add(book);
    }

    public void editBook(Book book, long id) {
        int position = list.indexOf(getBookById(id));
        list.add(position, book);
        list.remove(position + 1);
    }

    public void removeBook(long id) {
        list.remove(getBookById(id));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}