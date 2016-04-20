package demo.ttnd.client;

import demo.ttnd.dto.Book;
import demo.ttnd.dto.Employee;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("library-service")
public interface LibraryClient {
    @RequestMapping(method = RequestMethod.GET, value="/book")
    public List<Book> getBookList();

    @RequestMapping(method = RequestMethod.GET, value="/book/{bookId}")
    public Book findByIndex(@PathVariable("bookId") Integer bookId);

    @RequestMapping(method = RequestMethod.GET, value="/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Integer employeeId);
}

