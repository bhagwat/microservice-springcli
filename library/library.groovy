@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.RC1')
@Grab('spring-cloud-starter-eureka-server')

import org.springframework.context.annotation.Bean
import org.springframework.core.ParameterizedTypeReference
import org.springframework.web.client.RestTemplate
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
class LibraryApp {
    @Bean
    @LoadBalanced
    RestTemplate loadBalanced() {
        return new RestTemplate();
    }
}

@RestController
class LibraryController {
    @Autowired
    @LoadBalanced
    RestTemplate loadBalanced

    @RequestMapping("/")
    String home() {
        "Library Micro-service"
    }

    @RequestMapping("/employee/{employeeId}")
    public Employee get(@PathVariable Integer employeeId) {
        List<Employee> employees = loadBalanced.exchange(
                "http://employee-service/employees",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                },
                (Object) "mstine"
        ).getBody()
        return employees[employeeId - 1]
    }

    @Autowired
    LibraryService libraryService

    @RequestMapping("/book")
    List<Book> getBooks(){libraryService.getBooks()}

    @RequestMapping("/book/{bookId}")
    Book getBook(@PathVariable Integer bookId){libraryService.getBooks()[bookId-1]}
}

class Employee {
    String name;
    Integer age
}

class Book {
    String name;
    String author
}

@Component
class LibraryService{
    public List<Book>getBooks(){
        (1..10).collect{new Book(name: "Book "+it, author: "Author "+it)}
    }
}