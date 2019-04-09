package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookService memoryBookService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @GetMapping("")
    public List<Book> printBooks() {
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book printBooks(@PathVariable long id) {
        return memoryBookService.getBookById(id);
    }

    @PostMapping("")
    public void addBook( @RequestBody Book book){
        memoryBookService.addBookToList(book);
    }

    @PutMapping(path="/{id}")
    public void editBook(@RequestBody Book book, @PathVariable long id){
        memoryBookService.editBook(book, id);
    }

    @DeleteMapping(path="/{id}")
    public void removeBook(@PathVariable long id){
        memoryBookService.removeBook(id);
    }
}
