package demo.ttnd.controller;

import demo.ttnd.client.LibraryClient;
import demo.ttnd.dto.Book;
import demo.ttnd.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private LibraryClient libraryClient;

    @RequestMapping("/")
    String home() {
        return "Feign Micro-service";
    }

    @RequestMapping(method = RequestMethod.GET, value="/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Integer employeeId) {
        return libraryClient.getEmployee(employeeId);
    }

    @RequestMapping(method = RequestMethod.GET, value="/book")
    public List<Book> getBooks() {
        return libraryClient.getBookList();
    }

    @RequestMapping(method = RequestMethod.GET, value="/book/{bookId}")
    public Book getBook(@PathVariable("bookId") Integer bookId) {
        return libraryClient.findByIndex(bookId - 1);
    }
}
