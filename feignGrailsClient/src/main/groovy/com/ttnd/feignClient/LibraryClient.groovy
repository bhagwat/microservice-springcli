package com.ttnd.feignClient

import com.ttnd.dto.Book
import com.ttnd.dto.Employee
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("library-service")
public interface LibraryClient {
    @RequestMapping(method = RequestMethod.GET, value = "/book")
    public List<Book> getBookList()

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookId}")
    public Book findByIndex(@PathVariable("bookId") Long bookId)

    @RequestMapping(method = RequestMethod.GET, value = "/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Long employeeId)
}
